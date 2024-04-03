package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    // constructor.
    Login(){
        super("Bank Management System");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);


        // This is for Greeting in Login page.
        label1 = new JLabel("Welcome to ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGrade", Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No : ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(16);
        textField2.setForeground(Color.BLACK);
        textField2.setFont(new Font("Arrial", Font.BOLD, 20));
        textField2.setBounds(325, 190, 230, 30);
        add(textField2);


        label3 = new JLabel("PIN : ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setBounds(150,230,375,30);
        add(label3);

        passwordField3 = new JPasswordField(16);
        passwordField3.setForeground(Color.BLACK);
        passwordField3.setFont(new Font("Arrial", Font.BOLD,28));
        passwordField3.setBounds(325, 230, 230, 30);
        add(passwordField3);


        // This is for Button in the login page.

        button1 = new JButton("SIGN IN");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setFont(new Font("Arrial",Font.BOLD,16));
        button1.setBounds(300,300,100,28);
        button1.addActionListener(this);
        add(button1);


        button2 = new JButton("CLEAR");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setFont(new Font("Arrial", Font.BOLD,16));
        button2.setBounds(450,300,100,28);
        button2.addActionListener(this);
        add(button2);


        button3 = new JButton("SIGN UP");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setFont(new Font("Arrial", Font.BOLD,16));
        button3.setBounds(300, 350, 250,28);
        button3.addActionListener(this);
        add(button3);
        // This is for the background for login page.
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);



        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true); // this is for not showing the minimize, maximize, close bar in the screen.
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource() == button1){

                String cardNo = textField2.getText();
                String pin = passwordField3.getText();

                Conn c = new Conn();
                String query = "select * from login where card_no = '"+cardNo+"' and pin_no = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Card no or password should be correct and All fields must be filled");
                }



            }
            else if(e.getSource() == button2){
                textField2.setText("");  // this is for setting the value.
                passwordField3.setText(""); // this is for setting the value.

            }
            else if(e.getSource() == button3){
                    new UserDetail();
                    setVisible(false);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String args[]){
        new Login();
    }
}
