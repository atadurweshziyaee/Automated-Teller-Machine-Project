package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;



public class Deposits extends JFrame implements ActionListener {

    JTextField textDeposite;
    JButton buttonDeposit, buttonBack;
    String pin;
    Deposits(String pin){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel labelMessage = new JLabel("Enter Amount you want to Deposit");
        labelMessage.setFont(new Font("System", Font.BOLD, 16));
        labelMessage.setForeground(Color.WHITE);
        labelMessage.setBounds(460,180,400,35);
        image.add(labelMessage);      // if you want to show message on the image.

        textDeposite = new JTextField();
        textDeposite.setBackground(new Color(36, 33, 33));
        textDeposite.setFont(new Font("Raleway", Font.BOLD, 16));
        textDeposite.setForeground(Color.WHITE);
        textDeposite.setBounds(460,230,320,25);
        image.add(textDeposite);

        buttonDeposit = new JButton("Deposite");
        buttonDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonDeposit.setBackground(new Color(36, 33, 33));
        buttonDeposit.setForeground(Color.WHITE);
        buttonDeposit.setBounds(700,362,150,35);
        buttonDeposit.addActionListener(this);
        image.add(buttonDeposit);

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
    public void actionPerformed(ActionEvent e) {

        String amount = textDeposite.getText();
        Date date = new Date();
        try{

            if(e.getSource() == buttonDeposit){
                if(textDeposite.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Amount");
                }
                else {


                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into transaction(pin_no, date, status, amount) values('" + pin + "', '" + date + "', 'Deposit','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "₹" +amount + " Deposited Successfully");

                    setVisible(false);
                    new Main_Class(pin);

                }


            }
            else if(e.getSource() == buttonBack){
                setVisible(false);
                new Main_Class(pin);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposits("");
    }
}
