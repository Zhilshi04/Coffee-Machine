package com.coffeemachine.coffeemachineguifx;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CoffeeMachineGUIFillAndRemain extends JFrame {
    private JButton fillBtn, clearBtn;
    private JCheckBox waterCheck, milkCheck, beansCheck, cupsCheck;
    private JTextField waterField, milkField, beansField, cupsField;
    private boolean isWaterChecked, isMilkChecked, isBeansChecked, isCupsChecked;
    private JTable table;
    private DefaultTableModel tableModel;
    public CoffeeMachineGUIFillAndRemain(CoffeeMachine coffeeMachine){
        super("Fill and remaining");
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel fillPanel = new JPanel();
        fillPanel.setLayout(new BoxLayout(fillPanel, BoxLayout.Y_AXIS));

        // create a pair panel for the water components
        JPanel waterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        waterField = new JTextField("", 15);
        waterField.setEnabled(false);
        waterCheck = new JCheckBox("Fill Water");
        waterPanel.add(waterField);
        waterPanel.add(waterCheck);
        fillPanel.add(waterPanel);

        // create a pair panel for the milk components
        JPanel milkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        milkField = new JTextField("", 15);
        milkField.setEnabled(false);
        milkCheck = new JCheckBox("Fill Milk");
        milkPanel.add(milkField);
        milkPanel.add(milkCheck);
        fillPanel.add(milkPanel);

        // create a pair panel for the beans components
        JPanel beansPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        beansField = new JTextField("", 15);
        beansField.setEnabled(false);
        beansCheck = new JCheckBox("Fill Beans");
        beansPanel.add(beansField);
        beansPanel.add(beansCheck);
        fillPanel.add(beansPanel);

        JPanel cupsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cupsField = new JTextField("", 15);
        cupsField.setEnabled(false);
        cupsCheck = new JCheckBox("Fill Cups");
        cupsPanel.add(cupsField);
        cupsPanel.add(cupsCheck);
        fillPanel.add(cupsPanel);

        container.add(fillPanel, BorderLayout.WEST);

        CheckboxHandler checkboxHandler = new CheckboxHandler();
        waterCheck.addItemListener( checkboxHandler );
        milkCheck.addItemListener( checkboxHandler );
        beansCheck.addItemListener( checkboxHandler );
        cupsCheck.addItemListener( checkboxHandler );

        // create table model with two columns: "Name" and "Value"
        tableModel = new DefaultTableModel(new String[]{"Type", "Value"}, 0);
        // add data to table model from the enum
        tableModel.addRow(new Object[]{"Water", coffeeMachine.getWater()});
        tableModel.addRow(new Object[]{"Milk", coffeeMachine.getMilk()});
        tableModel.addRow(new Object[]{"Beans", coffeeMachine.getBeans()});
        tableModel.addRow(new Object[]{"Cups", coffeeMachine.getCups()});

        // create table with the table model
        table = new JTable();
        table.setModel(tableModel);

        // add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        FillButtonHandler fillButtonHandler = new FillButtonHandler(coffeeMachine);
        ClearButtonHandler clearButtonHandler = new ClearButtonHandler();
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fillBtn = new JButton("Confirm");
        fillBtn.addActionListener( fillButtonHandler );
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener( clearButtonHandler );
        btnPanel.add(fillBtn);
        btnPanel.add(clearBtn);

        container.add(btnPanel, BorderLayout.WEST);

        // add the scroll pane to the panel
        container.add(scrollPane, BorderLayout.CENTER);

        setSize(480, 800);
        setVisible(true);
        setResizable(false);
    }

    class FillButtonHandler implements ActionListener{
        private CoffeeMachine coffeeMachine;
        private JTextField[] inputField =  {waterField, milkField, beansField, cupsField};
        private JCheckBox[] checkBoxes = {waterCheck, milkCheck, beansCheck, cupsCheck};
        private String types[] = {"Water", "Milk", "Bean", "Cup"};
        public FillButtonHandler(CoffeeMachine coffeeMachine){
            this.coffeeMachine = coffeeMachine;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < inputField.length; i++){
                if (inputField[i].isEnabled() && !inputField[i].getText().equals("")){
                    int newValue = Integer.parseInt(inputField[i].getText());
                    int current = switch (types[i]) {
                        case "Water" -> coffeeMachine.getWater();
                        case "Milk" -> coffeeMachine.getMilk();
                        case "Bean" -> coffeeMachine.getBeans();
                        case "Cup" -> coffeeMachine.getCups();
                        default -> 0;
                    };

                    int totalValue = current + newValue;
                    System.out.printf("Updating %s: " + current + " + " + newValue + " = " + totalValue + "\n", types[i]);
                    switch (types[i]) {
                        case "Water" : {
                            coffeeMachine.setWater(totalValue);
                            tableModel.setValueAt(totalValue, 0, 1);
                            break;
                        }
                        case "Milk" : {
                            coffeeMachine.setMilk(totalValue);
                            tableModel.setValueAt(totalValue, 1, 1);
                            break;
                        }
                        case "Bean" : {
                            coffeeMachine.setBeans(totalValue);
                            tableModel.setValueAt(totalValue, 2, 1);
                            break;
                        }
                        case "Cup" : {
                            coffeeMachine.setCups(totalValue);
                            tableModel.setValueAt(totalValue, 2, 1);
                            break;
                        }
                    };
                }
                inputField[i].setText("");
                inputField[i].setEnabled(false);
                checkBoxes[i].setSelected(false);
            }
            tableModel.fireTableDataChanged();
        }
    }

    class ClearButtonHandler implements ActionListener{
        private JCheckBox[] checkBoxes = {waterCheck, milkCheck, beansCheck, cupsCheck};
        private JTextField[] textFields = {waterField, milkField, beansField, cupsField};

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < checkBoxes.length; i++) {
                textFields[i].setText("");
                textFields[i].setEnabled(false);
                checkBoxes[i].setSelected(false);
            }
        }
    }

    class CheckboxHandler implements ItemListener{
        private boolean[] isChecked = {isWaterChecked, isMilkChecked, isBeansChecked, isCupsChecked};
        private JCheckBox[] checkBoxes = {waterCheck, milkCheck, beansCheck, cupsCheck};
        private JTextField[] textFields = {waterField, milkField, beansField, cupsField};

        @Override
        public void itemStateChanged(ItemEvent e) {
            for (int i = 0; i < checkBoxes.length; i++) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getSource() == checkBoxes[i]) {
                        isChecked[i] = true;
                        System.out.printf("status %s : " + isChecked[i] + "\n", checkBoxes[i].getText());
                        textFields[i].setEnabled(true);
                    }
                }
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    if (e.getSource() == checkBoxes[i]) {
                        isChecked[i] = false;
                        System.out.printf("status %s : " + isChecked[i] + "\n", checkBoxes[i].getText());
                        textFields[i].setEnabled(false);
                    }
                }
                textFields[i].repaint();
            }
        }
    }

}
