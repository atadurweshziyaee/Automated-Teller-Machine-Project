package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField textWithdrawal;
    JButton buttonWithdrawal, buttonBack;
    String pin;
    Withdrawal(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);


        JLabel labelMessage2 = new JLabel("Enter Amount");
        labelMessage2.setFont(new Font("System", Font.BOLD, 16));
        labelMessage2.setForeground(Color.WHITE);
        labelMessage2.setBounds(460,220,400,35);
        image.add(labelMessage2);    // if you want to show message on the image.

        textWithdrawal = new JTextField();
        textWithdrawal.setBackground(new Color(36, 33, 33));
        textWithdrawal.setFont(new Font("Raleway", Font.BOLD, 16));
        textWithdrawal.setForeground(Color.WHITE);
        textWithdrawal.setBounds(460,250,320,25);
        image.add(textWithdrawal);

        buttonWithdrawal = new JButton("Withdrawal");
        buttonWithdrawal.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonWithdrawal.setBackground(new Color(36, 33, 33));
        buttonWithdrawal.setForeground(Color.WHITE);
        buttonWithdrawal.setBounds(700,362,150,35);
        buttonWithdrawal.addActionListener(this);
        image.add(buttonWithdrawal);

        buttonBack = new JButton("Back");
        buttonBack.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonBack.setBackground(new Color(36, 33, 33));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(700,406,150,35);
        buttonBack.addActionListener(this);
        image.add(buttonBack);



        this.pin = pin;
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        try{
            String amount = textWithdrawal.getText();
            Date date = new Date();

            if(e.getSource() == buttonBack){
                setVisible(false);
                new Main_Class(pin);
            }
            else if(e.getSource() == buttonWithdrawal){
                if(textWithdrawal.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter amount");
                }
                else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from transaction where pin_no = '"+pin+"'");
                    int balane = 0;
                    while(resultSet.next()){
                        if(resultSet.getString("status").equals("Deposit")){
                            balane += Integer.parseInt(resultSet.getString("amount"));
                        }
                        else {

                            balane -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(balane < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Fund");
                        return;
                    }
                    else if(balane > Integer.parseInt(amount)){
                        c.statement.executeUpdate("insert into transaction values('"+pin+"', '"+date+"', 'Debit', '"+amount+"')");
                        JOptionPane.showMessageDialog(null, "₹"+amount+" Debited Successfully");
                        setVisible(false);
                        new Main_Class(pin);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Insufficient Fund");
                    }
                }


            }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
