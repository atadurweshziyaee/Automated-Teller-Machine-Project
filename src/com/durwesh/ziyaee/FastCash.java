package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    String pin;
    JButton buttonDebit100, buttonDebit500, buttonDebit1000, buttonDebit5000, buttonDebit10000, buttonDebit20000, buttonBack;
    FastCash(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel labelMessage = new JLabel("Select your Amount");
        labelMessage.setBounds(430, 180, 700, 35);
        labelMessage.setFont(new Font("System", Font.BOLD, 28));
        labelMessage.setForeground(Color.WHITE);
        image.add(labelMessage);

        buttonDebit100 = new JButton("₹ 100");
        buttonDebit100.setForeground(Color.WHITE);
        buttonDebit100.setBackground(new Color(36, 33, 33));
        buttonDebit100.setBounds(410,274,150,35);
        buttonDebit100.addActionListener(this);
        image.add(buttonDebit100);

        buttonDebit500 = new JButton("₹ 500");
        buttonDebit500.setForeground(Color.WHITE);
        buttonDebit500.setBackground(new Color(36, 33, 33));
        buttonDebit500.setBounds(700,274,150,35);
        buttonDebit500.addActionListener(this);
        image.add(buttonDebit500);

        buttonDebit1000 = new JButton("₹ 1000");
        buttonDebit1000.setForeground(Color.WHITE);
        buttonDebit1000.setBackground(new Color(36, 33, 33));
        buttonDebit1000.setBounds(410,318,150,35);
        buttonDebit1000.addActionListener(this);
        image.add(buttonDebit1000);

        buttonDebit5000 = new JButton("₹ 5000");
        buttonDebit5000.setForeground(Color.WHITE);
        buttonDebit5000.setBackground(new Color(36, 33, 33));
        buttonDebit5000.setBounds(700,318,150,35);
        buttonDebit5000.addActionListener(this);
        image.add(buttonDebit5000);

        buttonDebit10000 = new JButton("₹ 10000");
        buttonDebit10000.setForeground(Color.WHITE);
        buttonDebit10000.setBackground(new Color(36, 33, 33));
        buttonDebit10000.setBounds(410,362,150,35);
        buttonDebit10000.addActionListener(this);
        image.add(buttonDebit10000);

        buttonDebit20000 = new JButton("₹ 20000");
        buttonDebit20000.setForeground(Color.WHITE);
        buttonDebit20000.setBackground(new Color(36, 33, 33));
        buttonDebit20000.setBounds(700,362,150,35);
        buttonDebit20000.addActionListener(this);
        image.add(buttonDebit20000);

        buttonBack = new JButton("Back");
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBackground(new Color(36, 33, 33));
        buttonBack.setBounds(700,406,150,35);
        buttonBack.addActionListener(this);
        image.add(buttonBack);


        setLayout(null);
        setLocation(0, 0);
        setSize(1550, 1080);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonBack){
            setVisible(false);
            new Main_Class(pin);
        }
        else{

            String amount = ((JButton)e.getSource()).getText().substring(2);
            Conn c = new Conn();
            Date date = new Date();

            try{
                ResultSet resultSet = c.statement.executeQuery("select * from transaction where pin_no = '"+pin+"'");
                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("status").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }
                    else if(resultSet.getString("status").equals("Debit")){
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(e.getSource() != buttonBack && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into transaction values('"+pin+"', '"+date+"', 'Debit', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "₹"+amount+" Debited Successfully");

            }
            catch(Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Main_Class(pin);
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
