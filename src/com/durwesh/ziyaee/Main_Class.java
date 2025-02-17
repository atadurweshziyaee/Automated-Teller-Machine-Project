package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {

    JButton buttonDeposite, buttonWithdrawal, buttonFastCash, buttonMini, buttonPinChange, buttonBalEnqry, buttonExit, buttonLogin;
    String pin;
    Main_Class(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel labelMessage = new JLabel("Select your Option");
        labelMessage.setBounds(430, 180, 700, 35);
        labelMessage.setFont(new Font("System", Font.BOLD, 28));
        labelMessage.setForeground(Color.WHITE);
        image.add(labelMessage);

        buttonDeposite = new JButton("Deposite");
        buttonDeposite.setForeground(Color.WHITE);
        buttonDeposite.setBackground(new Color(36, 33, 33));
        buttonDeposite.setBounds(410,274,150,35);
        buttonDeposite.addActionListener(this);
        image.add(buttonDeposite);

        buttonWithdrawal = new JButton("Withdrawal");
        buttonWithdrawal.setForeground(Color.WHITE);
        buttonWithdrawal.setBackground(new Color(36, 33, 33));
        buttonWithdrawal.setBounds(700,274,150,35);
        buttonWithdrawal.addActionListener(this);
        image.add(buttonWithdrawal);

        buttonFastCash = new JButton("Fast Cash");
        buttonFastCash.setForeground(Color.WHITE);
        buttonFastCash.setBackground(new Color(36, 33, 33));
        buttonFastCash.setBounds(410,318,150,35);
        buttonFastCash.addActionListener(this);
        image.add(buttonFastCash);

        buttonMini = new JButton("Mini Statement");
        buttonMini.setForeground(Color.WHITE);
        buttonMini.setBackground(new Color(36, 33, 33));
        buttonMini.setBounds(700,318,150,35);
        buttonMini.addActionListener(this);
        image.add(buttonMini);

        buttonPinChange = new JButton("Pin Change");
        buttonPinChange.setForeground(Color.WHITE);
        buttonPinChange.setBackground(new Color(36, 33, 33));
        buttonPinChange.setBounds(410,362,150,35);
        buttonPinChange.addActionListener(this);
        image.add(buttonPinChange);

        buttonBalEnqry = new JButton("Balance Enquiry");
        buttonBalEnqry.setForeground(Color.WHITE);
        buttonBalEnqry.setBackground(new Color(36, 33, 33));
        buttonBalEnqry.setBounds(700,362,150,35);
        buttonBalEnqry.addActionListener(this);
        image.add(buttonBalEnqry);

        buttonExit = new JButton("Exit");
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setBackground(new Color(36, 33, 33));
        buttonExit.setBounds(700,406,150,35);
        buttonExit.addActionListener(this);
        image.add(buttonExit);

        buttonLogin = new JButton("Login Page");
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBackground(new Color(36, 33, 33));
        buttonLogin.setBounds(410,406,150,35);
        buttonLogin.addActionListener(this);
        image.add(buttonLogin);



        setLayout(null);
        setLocation(0, 0);
        setSize(1550, 1080);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        try{
            if(e.getSource() == buttonDeposite){
                new Deposits(pin);
                setVisible(false);
            }
            else if(e.getSource() == buttonExit){
                System.exit(0);
            }
            else if(e.getSource() == buttonWithdrawal){

                new Withdrawal(pin);
                setVisible(false);
            }
            else if(e.getSource() == buttonBalEnqry){

                new BalanceEnquiry(pin);
                setVisible(false);
            }
            else if(e.getSource() == buttonFastCash){

                new FastCash(pin);
                setVisible(false);
            }
            else if (e.getSource() == buttonPinChange) {

                new PinChange(pin);
                setVisible(false);
            }
            else if(e.getSource() == buttonMini){
                new MiniStatement(pin);
            }
            else if(e.getSource() == buttonLogin){
                setVisible(false);
                new Login();
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Main_Class("");
    }
}
