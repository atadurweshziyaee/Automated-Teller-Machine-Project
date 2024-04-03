package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    JButton buttonBack;
    String pin;
    MiniStatement(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank_logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 35, 65, 65);
        add(image);

        JLabel labelMessage1 = new JLabel("एटीएम ग्राहक सलाह/ATM Customer Advice");
        labelMessage1.setFont(new Font("System", Font.BOLD, 18));
        labelMessage1.setForeground(Color.BLACK);
        labelMessage1.setBounds(5, 5, 355, 18);
        add(labelMessage1);

        JLabel labelMessage2 = new JLabel("दुर्वेश बैंक ऑफ इंडिया");
        labelMessage2.setFont(new Font("Raleway", Font.BOLD, 18));
        labelMessage2.setForeground(Color.BLACK);
        labelMessage2.setBounds(100, 40, 300, 30);
        add(labelMessage2);

        JLabel labelMessage3 = new JLabel("Durwesh Bank of India");
        labelMessage3.setFont(new Font("Raleway", Font.BOLD, 18));
        labelMessage3.setForeground(Color.BLACK);
        labelMessage3.setBounds(100, 60, 300, 30);
        add(labelMessage3);

        JLabel labelMessage4 = new JLabel();
        labelMessage4.setBounds(10, 90, 400, 40);
        add(labelMessage4);

        JLabel labelMessage5 = new JLabel();
        labelMessage5.setBounds(10, 110, 400, 40);
        add(labelMessage5);

        JLabel labelMessage6 = new JLabel("Transaction");
        labelMessage6.setForeground(Color.BLACK);
        labelMessage6.setBounds(150, 140, 200, 40);
        add(labelMessage6);

        JLabel labelMessage7 = new JLabel("==================================================");
        labelMessage7.setForeground(Color.BLACK);
        labelMessage7.setBounds(5, 160, 500, 30);
        add(labelMessage7);

        JLabel labelMessage8 = new JLabel("Date                                                     status                        amount ");

        labelMessage8.setBounds(10, 180, 500, 40);
        labelMessage7.setForeground(Color.BLACK);
        add(labelMessage8);

        JLabel labelMessage9 = new JLabel("==================================================");
        labelMessage9.setForeground(Color.BLACK);
        labelMessage9.setBounds(5, 200, 500, 30);
        add(labelMessage9);

        JLabel labelMessage10 = new JLabel();
        labelMessage10.setBounds(10, 220, 390, 280);
        add(labelMessage10);

        JLabel labelMessage11 = new JLabel();
        labelMessage11.setBounds(240,496,400,30);
        add(labelMessage11);

        buttonBack = new JButton("Back");
        buttonBack.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonBack.setBackground(new Color(36, 33, 33));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(150, 520, 100, 20);
        buttonBack.addActionListener(this);
        add(buttonBack);


        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin_no = '" + pin + "'");
            while (resultSet.next()) {
                labelMessage4.setText("Card Number : XXXXXXXXXXXX" + resultSet.getString("card_no").substring(11, 15));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from accountdetail where pin_no = '" + pin + "'");
            while (resultSet.next()) {
                labelMessage5.setText("Account Type : " + resultSet.getString("account_type"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from transaction where pin_no = '" + pin + "'");
            while (resultSet.next()) {

                labelMessage10.setText(labelMessage10.getText()+"<html>" +resultSet.getString("date") +"&emsp;&emsp;"+ resultSet.getString("status") + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + resultSet.getString("amount")+"<br><br><html>");

                if (resultSet.getString("status").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else if (resultSet.getString("status").equals("Debit")) {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            labelMessage11.setText("Total Balance : "+balance);

        } catch (Exception e) {
            e.printStackTrace();
        }


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(1000, 150);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == buttonBack){
                setVisible(false);
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MiniStatement("1234");
    }
}
