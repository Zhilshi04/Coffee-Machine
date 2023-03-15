    package com.coffeemachine.coffeemachineguifx;

    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.IOException;

    public class CoffeeMachineGUI extends JFrame{
        private CoffeeMachine coffeeMachine = new CoffeeMachine(500, 540, 120, 9, 550);
        private JButton orderBtn, fillBtn, takeBtn;
        private JLabel label, heroLabelIcon;
        private Font headerFont = new Font("TimesRoman", Font.BOLD, 24);
        private Font btnFont = new Font("TimesRoman", Font.BOLD, 18);
        private JTable table;
        private DefaultTableModel tableModel;
        public CoffeeMachineGUI(){
            super("KRATAIBIN");
            Container container = getContentPane();
            container.setLayout(new BorderLayout());

            ImageIcon heroIcon = new ImageIcon("src/main/resources/com/coffeemachine/coffeemachineguifx/krataibin-icon.PNG");
            Image heroImg = heroIcon.getImage();
            Image heroScaledImg = heroImg.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
            ImageIcon heroScaledIcon = new ImageIcon(heroScaledImg);

            ImageIcon icon = new ImageIcon("src/main/resources/com/coffeemachine/coffeemachineguifx/order-icon.png");
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);

            heroLabelIcon = new JLabel("");
            heroLabelIcon.setIcon(heroScaledIcon);

            JPanel heroIconPanel = new JPanel();
            heroIconPanel.add(heroLabelIcon);

            label = new JLabel("KRATAIBIN");
            label.setFont(headerFont);

            JPanel headerLabelPanel = new JPanel();
            headerLabelPanel.add(label);

            orderBtn = new JButton("Drinks and coffee");
            orderBtn.setFocusable(false); // Remove the focusability of
            orderBtn.setIcon(scaledIcon);
            orderBtn.setFont(btnFont);
            orderBtn.setForeground(Color.WHITE);
            orderBtn.setVerticalTextPosition(SwingConstants.CENTER);
            orderBtn.setHorizontalTextPosition(SwingConstants.LEFT);
            orderBtn.setPreferredSize(new Dimension(400,150));
            orderBtn.setBackground(Color.decode("#4d1a19"));
            orderBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new CoffeeMachineGUIOrder(coffeeMachine, tableModel);
                }
            });

            fillBtn = new JButton("Fill and check stock");
            fillBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
            fillBtn.setHorizontalTextPosition(SwingConstants.CENTER);
            fillBtn.setPreferredSize(new Dimension(200,150));
            fillBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new CoffeeMachineGUIFillAndRemain(coffeeMachine);
                }
            });

            takeBtn = new JButton("Take out cash");
            takeBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
            takeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
            takeBtn.setPreferredSize(new Dimension(200,150));
            takeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new CoffeeCahsOut(coffeeMachine);
                }
            });
            JPanel verticalPanel = new JPanel();
            verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));

            JPanel orderBtnPanel = new JPanel();
            orderBtnPanel.add(orderBtn);

            JPanel horizontalBtnPanel = new JPanel();
            horizontalBtnPanel.setLayout(new FlowLayout());
            horizontalBtnPanel.add(fillBtn);
            horizontalBtnPanel.add(takeBtn);

            // create table model with three columns: "Ordered name" and "Quantity" and "Price"
            tableModel = new DefaultTableModel(new String[]{"Ordered name", "Quantity", "Price"}, 0);

            // create table with the table model
            table = new JTable();
            table.setModel(tableModel);

            // add the table to a scroll pane
            JScrollPane scrollPane = new JScrollPane(table);

            verticalPanel.add(heroIconPanel);
            verticalPanel.add(headerLabelPanel);
            verticalPanel.add(orderBtnPanel);
            verticalPanel.add(horizontalBtnPanel);
            verticalPanel.add(scrollPane);

            // Create a panel with FlowLayout to center the components horizontally
            JPanel horizontalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            horizontalPanel.add(verticalPanel);

            container.add(horizontalPanel, BorderLayout.CENTER);

            setSize(480, 800);
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        public static void main(String[] args) {
            new CoffeeMachineGUI();
        }
    }
