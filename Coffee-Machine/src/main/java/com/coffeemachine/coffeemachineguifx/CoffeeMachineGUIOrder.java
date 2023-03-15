package com.coffeemachine.coffeemachineguifx;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeMachineGUIOrder extends  JFrame{
    public CoffeeMachineGUIOrder(CoffeeMachine coffeeMachine, DefaultTableModel tableModel){
        Container c = getContentPane();
        String fileOrder = "../resources/com/coffeemachine/coffeemachineguifx/order-icon.png";
        ImageIcon icon = new ImageIcon(((new ImageIcon(fileOrder).getImage()).getScaledInstance( 40, 60, Image.SCALE_DEFAULT)));
        Icon x = new ImageIcon(icon.getImage());
        JPanel contentLabel = new JPanel();
        contentLabel.setLayout(new GridLayout(0,3,10,10));
        contentLabel.setSize(new Dimension(879,455));
        contentLabel.setVisible(true);

        JButton btnLatte = new JButton("Latte",icon);
        btnLatte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoffeeTypes type = CoffeeTypes.LATTE;
                new CoffeeMachineGUIPayment(coffeeMachine, type, tableModel);
            }
        });
        btnLatte.setVerticalTextPosition(SwingConstants.BOTTOM);
//        btnLatte.setHorizontalTextPosition(SwingConstants.SOUTH);
        btnLatte.setPreferredSize(new Dimension(50,200));
        contentLabel.add(btnLatte);

        JButton btnCapu = new JButton("Capuccino",icon);
        btnCapu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoffeeTypes type = CoffeeTypes.CAPPUCCINO;
                new CoffeeMachineGUIPayment(coffeeMachine, type, tableModel);
            }
        });
        btnCapu.setVerticalTextPosition(SwingConstants.BOTTOM);
//        btnCapu.setHorizontalTextPosition(SwingConstants.SOUTH);
        btnCapu.setPreferredSize(new Dimension(50,200));
        contentLabel.add(btnCapu);

        JButton btnEs = new JButton("Espresso",icon);
        btnEs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoffeeTypes type = CoffeeTypes.ESPRESSO;
                new CoffeeMachineGUIPayment(coffeeMachine, type, tableModel);
            }
        });
        btnEs.setVerticalTextPosition(SwingConstants.BOTTOM);
//        btnEs.setHorizontalTextPosition(SwingConstants.SOUTH);
        btnEs.setPreferredSize(new Dimension(50,200));
        contentLabel.add(btnEs);

        JPanel panel = new JPanel();
        panel.add(contentLabel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        contentLabel.setBorder(new EmptyBorder(50,10,1,10));
        c.add(contentLabel,BorderLayout.NORTH);
        c.add(panel);
        setSize(480,800);
        setVisible(true);
    }
}