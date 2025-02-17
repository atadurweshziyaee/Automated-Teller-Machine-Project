package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton buttonBack;
    JLabel labelShowBal;
    String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel labelMessage = new JLabel("Available Balance");
        labelMessage.setFont(new Font("System", Font.BOLD, 16));
        labelMessage.setForeground(Color.WHITE);
        labelMessage.setBounds(460,180,400,35);
        image.add(labelMessage);      // if you want to show message on the image.


        labelShowBal = new JLabel();
        labelShowBal.setBackground(new Color(36, 33, 33));
        labelShowBal.setFont(new Font("Raleway", Font.BOLD, 16));
        labelShowBal.setForeground(Color.WHITE);
        labelShowBal.setBounds(460,230,320,25);
        image.add(labelShowBal);

        buttonBack = new JButton("Back");
        buttonBack.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonBack.setBackground(new Color(36, 33, 33));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(700,406,150,35);
        buttonBack.addActionListener(this);
        image.add(buttonBack);


        int balance = 0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from transaction where pin_no = '"+pin+"'");
            while(resultSet.next()){
                if(resultSet.getString("status").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else if(resultSet.getString("status").equals("Debit")){

                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        labelShowBal.setText(""+balance);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource() == buttonBack){
                setVisible(false);
                new Main_Class(pin);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
