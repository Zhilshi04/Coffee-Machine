package com.coffeemachine.coffeemachineguifx;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeCahsOut extends CoffeeMachine {
        public CoffeeCahsOut(CoffeeMachine c){
            JFrame frame = new JFrame();
            JPanel bPannel = new JPanel();
            JPanel labelPannel = new JPanel();
            JButton bClear = new JButton("Cash Out");
            JLabel label = new JLabel();
            JLabel labelCashOut = new JLabel();
            label.setText("Cash : "+c.getCash()+" $");
            labelCashOut.setText("Cash Out : "+c.getCashOut()+" $");
            label.setVerticalTextPosition(SwingConstants.BOTTOM);
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            label.setBorder(new EmptyBorder(0,150,0,0));
            bClear.setPreferredSize(new Dimension(120,60));
            bPannel.add(bClear);
            bClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.setCashOut(c.getCash());
                    JOptionPane.showMessageDialog(new JFrame(), "Cash Out : "+c.getCash(), "Cash Out", JOptionPane.INFORMATION_MESSAGE);
                    c.setCash(0);
                    labelCashOut.setText("Cash Out : "+c.getCashOut()+" $");
                    label.setText("Cash : "+c.getCash()+" $");
                    System.out.println(c.getCashOut());

                }
            });
            frame.add(bPannel,BorderLayout.CENTER);
            labelPannel.add(labelCashOut,BorderLayout.NORTH);
            labelPannel.add(label,BorderLayout.NORTH);

            frame.add(labelPannel,BorderLayout.NORTH);
            frame.setSize(480, 800);
            frame.setVisible(true);
            frame.setResizable(false);
        }
}
