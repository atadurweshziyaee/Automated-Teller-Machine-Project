package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField passwordField1, passwordField2;
    JButton buttonChange, buttonBack;
    String pin;
    PinChange(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel labelMessage1 = new JLabel("Change your 4-digit PIN");
        labelMessage1.setFont(new Font("System", Font.BOLD, 16));
        labelMessage1.setForeground(Color.WHITE);
        labelMessage1.setBounds(530,180,400,35);
        image.add(labelMessage1);      // if you want to show message on the image.

        JLabel labelMessage2 = new JLabel("New PIN : ");
        labelMessage2.setFont(new Font("System", Font.BOLD, 16));
        labelMessage2.setForeground(Color.WHITE);
        labelMessage2.setBounds(460,220,200,35);
        image.add(labelMessage2);

        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("System", Font.BOLD, 16));
        passwordField1.setBackground(new Color(36, 33, 33));
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setBounds(600,220,200,30);
        image.add(passwordField1);

        JLabel labelMessage3 = new JLabel("Re-type PIN : ");
        labelMessage3.setFont(new Font("System", Font.BOLD, 16));
        labelMessage3.setForeground(Color.WHITE);
        labelMessage3.setBounds(460,260,200,35);
        image.add(labelMessage3);

        passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("System", Font.BOLD, 16));
        passwordField2.setBackground(new Color(36, 33, 33));
        passwordField2.setForeground(Color.WHITE);
        passwordField2.setBounds(600,260,200,30);
        image.add(passwordField2);

        buttonChange = new JButton("Change PIN");
        buttonChange.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonChange.setBackground(new Color(36, 33, 33));
        buttonChange.setForeground(Color.WHITE);
        buttonChange.setBounds(700,362,150,35);
        buttonChange.addActionListener(this);
        image.add(buttonChange);

        buttonBack = new JButton("Back");
        buttonBack.setFont(new Font("Raleway", Font.BOLD, 16));
        buttonBack.setBackground(new Color(36, 33, 33));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(700,406,150,35);
        buttonBack.addActionListener(this);
        image.add(buttonBack);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pwd1 = passwordField1.getText();
        String pwd2 = passwordField2.getText();
        try{
            if(e.getSource()==buttonChange){
                if(passwordField1.getText().equals("") || passwordField2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Password");
                }
                else {
                    if(pwd1.equals(pwd2)){
                        Conn c = new Conn();
                        String query1 = "update login set pin_no = '"+pwd2+"' where pin_no = '"+pin+"'";
                        String query2 = "update signupthree set pin_no = '"+pwd2+"' where pin_no = '"+pin+"'";
                        String query3 = "update transaction set pin_no = '"+pwd2+"' where pin_no = '"+pin+"'";

                        c.statement.executeUpdate(query1);
                        c.statement.executeUpdate(query2);
                        c.statement.executeUpdate(query3);

                        JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                        setVisible(false);
                        new Main_Class(pin);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Password must be same");
                        return;
                    }
                }
            }
            else if(e.getSource()==buttonBack){
                setVisible(false);
                new Main_Class(pin);
            }


        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
