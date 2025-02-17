package com.durwesh.ziyaee;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class UserDetail extends JFrame implements ActionListener {

    JRadioButton male, female, others, married, unmarried;
    JButton buttonNext;
    JTextField textName, textFName, textEmail, textCity, textPin, textState;
    JTextArea textAreaAddress;
    JDateChooser dateChooser;
    Random ran = new Random();

    // this is for random generate number;
    long first4No = (ran.nextLong()%9000l) + 1000l;

    // this is for always get positive number;
    String first = " " + Math.abs(first4No);

    UserDetail(){
        super("Application Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("Application Form No. " + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(750,0,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 90, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Raleway", Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD,18));
        textName.setForeground(Color.BLACK);
        textName.setBounds(300, 190, 400, 30);
        add(textName);


        JLabel labelFatherName = new JLabel("Father's Name : ");
        labelFatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFatherName.setBounds(100, 230, 200, 30);
        add(labelFatherName);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway", Font.BOLD, 18));
        textFName.setForeground(Color.BLACK);
        textFName.setBounds(300, 230, 400, 30);
        add(textFName);

        JLabel labelDate = new JLabel("D.O.B : ");
        labelDate.setFont(new Font("Raleway", Font.BOLD,20));
        labelDate.setBounds(100,270, 200,30);
        add(labelDate);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 270, 400, 30);
        add(dateChooser);


        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setFont(new Font("Raleway", Font.BOLD,20));
        labelGender.setBounds(100,310,200,30);
        add(labelGender);

        male = new JRadioButton("Male");
        male.setBackground(new Color(222,255,228));
        male.setFont(new Font("Raleway", Font.BOLD,18));
        male.setBounds(300, 310, 100, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(new Color(222,255,228));
        female.setFont(new Font("Raleway", Font.BOLD,18));
        female.setBounds(400, 310, 100, 30);
        add(female);

        others = new JRadioButton("Others");
        others.setBackground(new Color(222,255,228));
        others.setFont(new Font("Raleway", Font.BOLD,18));
        others.setBounds(500, 310, 100, 30);
        add(others);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        buttonGroup.add(others);


        JLabel labelEmail = new JLabel("E-mail : ");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 18));
        labelEmail.setBounds(100,350,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 18));
        textEmail.setForeground(Color.BLACK);
        textEmail.setBounds(300,350,400,30);
        add(textEmail);

        JLabel labelMS = new JLabel("Marital Status : ");
        labelMS.setFont(new Font("Raleway", Font.BOLD, 18));
        labelMS.setBounds(100,390,200,30);
        add(labelMS);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        married.setBackground(new Color(222,255,228));
        married.setBounds(300,390,100,30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
        unmarried.setBackground(new Color(222,255,228));
        unmarried.setBounds(400, 390, 200, 30);
        add(unmarried);

        ButtonGroup maritalStatus = new ButtonGroup();
        maritalStatus.add(married);
        maritalStatus.add(unmarried);

        JLabel labelAddress = new JLabel("Address : ");
        labelAddress.setFont(new Font("Raleway", Font.BOLD,18));
        labelAddress.setBounds(100,430,200,30);
        add(labelAddress);

        textAreaAddress = new JTextArea(4,20);
        textAreaAddress.setFont(new Font("Raleway", Font.BOLD, 18));
        textAreaAddress.setBounds(300,430,400,30);
        add(textAreaAddress);

        JLabel labelCity = new JLabel("City : ");
        labelCity.setFont(new Font("Raleway",Font.BOLD,18));
        labelCity.setBounds(100,470,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 18));
        textCity.setBounds(300,470,400,30);
        add(textCity);

        JLabel labelPin = new JLabel("Pin : ");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 18));
        labelPin.setBounds(100, 510, 200, 30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 18));
        textPin.setBounds(300,510,400,30);
        add(textPin);

        JLabel labelState = new JLabel("State : ");
        labelState.setFont(new Font("Raleway", Font.BOLD, 18));
        labelState.setBounds(100,550,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 18));
        textState.setBounds(300,550,400,30);
        add(textState);

        buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setBackground(Color.BLACK);
        buttonNext.setBounds(600,620,100,30);
        buttonNext.addActionListener(this);
        add(buttonNext);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360,40);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = first;
        String name = textName.getText();
        String FName = textFName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }
        else if(female.isSelected()){
            gender = "female";
        }
        else if(others.isSelected()){
            gender = "others";
        }

        String email = textEmail.getText();

        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "married";
        }
        else if(unmarried.isSelected()){
            maritalStatus = "unmarried";
        }

        String address = textAreaAddress.getText();
        String city = textCity.getText();
        String pin = textPin.getText();
        String state = textState.getText();


        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else{
                Conn conn1 = new Conn();
                String query = "insert into userdetail values('"+formNo+"', '"+name+"', '"+FName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                conn1.statement.executeUpdate(query);
                new UserMoreDetail(first);
                setVisible(false);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new UserDetail();
    }
}
