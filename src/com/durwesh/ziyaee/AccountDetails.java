package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AccountDetails extends JFrame implements ActionListener {

    JRadioButton rButtonSav, rButtonCurr, rButtonFix, rButtonRecurr;
    JCheckBox checkBoxAtm, checkBoxNetBank, checkBoxMobBank, checkBoxEmailAlrt, checkBoxCheque, checkBoxStatement;
    JButton buttonSubmit, buttonCancel;
    String formNo;
    AccountDetails(String formNo){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formNo = formNo;

        JLabel labelFormNo = new JLabel("FormNo:- ");
        labelFormNo.setFont(new Font("Raleway", Font.BOLD, 18));
        labelFormNo.setBounds(300,10,100,30);
        add(labelFormNo);

        JLabel labelActualFormNo = new JLabel(formNo);
        labelActualFormNo.setFont(new Font("Raleway", Font.BOLD, 18));
        labelActualFormNo.setBounds(400,10,100,30);
        add(labelActualFormNo);


        JLabel labelPage = new JLabel("Page 3");
        labelPage.setFont(new Font("Raleway", Font.BOLD, 18));
        labelPage.setBounds(700,5,100,30);
        add(labelPage);

        JLabel labelAccDetail = new JLabel("-:Account Details:-");
        labelAccDetail.setFont(new Font("Raleway", Font.BOLD, 24));
        labelAccDetail.setBounds(350,100,300,40);
        add(labelAccDetail);

        JLabel labelAccType = new JLabel("Account Type :");
        labelAccType.setFont(new Font("Raleway", Font.BOLD, 18));
        labelAccType.setBounds(100,200,300,30);
        add(labelAccType);

        rButtonSav = new JRadioButton("Saving Account");
        rButtonSav.setFont(new Font("Raleway", Font.BOLD, 18));
        rButtonSav.setBackground(new Color(215,252,252));
        rButtonSav.setBounds(150, 250, 250, 30);
        add(rButtonSav);

        rButtonCurr = new JRadioButton("Current Account");
        rButtonCurr.setFont(new Font("Raleway", Font.BOLD, 18));
        rButtonCurr.setBackground(new Color(215,252,252));
        rButtonCurr.setBounds(400, 250, 400, 30);
        add(rButtonCurr);

        rButtonFix = new JRadioButton("Fixed Deposit Account");
        rButtonFix.setFont(new Font("Raleway", Font.BOLD, 18));
        rButtonFix.setBackground(new Color(215,252,252));
        rButtonFix.setBounds(150, 300, 250, 30);
        add(rButtonFix);

        rButtonRecurr = new JRadioButton("Recurring Deposit Account");
        rButtonRecurr.setFont(new Font("Raleway", Font.BOLD, 18));
        rButtonRecurr.setBackground(new Color(215,252,252));
        rButtonRecurr.setBounds(400, 300, 350, 30);
        add(rButtonRecurr);

        ButtonGroup groupType = new ButtonGroup();
        groupType.add(rButtonSav);
        groupType.add(rButtonCurr);
        groupType.add(rButtonFix);
        groupType.add(rButtonRecurr);

        JLabel labelCardDetail1 = new JLabel("Card Number: ");
        labelCardDetail1.setFont(new Font("Raleway", Font.BOLD, 18));
        labelCardDetail1.setBounds(100, 350, 300, 25);
        add(labelCardDetail1);

        JLabel labelCardDetail2 = new JLabel("XXXX-XXXX-XXXX-4215");
        labelCardDetail2.setFont(new Font("Raleway", Font.BOLD, 18));
        labelCardDetail2.setBounds(400, 350, 300, 25);
        add(labelCardDetail2);

        JLabel labelCardDetail3 = new JLabel("(Your 16-digit card number)");
        labelCardDetail3.setFont(new Font("Raleway", Font.BOLD, 14));
        labelCardDetail3.setBounds(100, 370, 300, 30);
        add(labelCardDetail3);

        JLabel labelCardDetail4 = new JLabel("(It would appear on atm card/cheque book and statement)");
        labelCardDetail4.setFont(new Font("Raleway", Font.BOLD, 14));
        labelCardDetail4.setBounds(400, 370, 430, 30);
        add(labelCardDetail4);

        JLabel labelCardDetail5 = new JLabel("PIN: ");
        labelCardDetail5.setFont(new Font("Raleway", Font.BOLD, 18));
        labelCardDetail5.setBounds(100, 420, 200, 25);
        add(labelCardDetail5);

        JLabel labelCardDetail6 = new JLabel("XXXX");
        labelCardDetail6.setFont(new Font("Raleway", Font.BOLD, 18));
        labelCardDetail6.setBounds(400, 420, 200, 25);
        add(labelCardDetail6);

        JLabel labelCardDetail7 = new JLabel("Service Required:");
        labelCardDetail7.setFont(new Font("Raleway", Font.BOLD, 18));
        labelCardDetail7.setBounds(100, 470, 300, 25);
        add(labelCardDetail7);

        checkBoxAtm = new JCheckBox("ATM Card");
        checkBoxAtm.setFont(new Font("Raleway", Font.BOLD, 18));
        checkBoxAtm.setBackground(new Color(215,252,252));
        checkBoxAtm.setBounds(150, 520, 200, 25);
        add(checkBoxAtm);

        checkBoxNetBank = new JCheckBox("Net Banking");
        checkBoxNetBank.setFont(new Font("Raleway", Font.BOLD, 18));
        checkBoxNetBank.setBackground(new Color(215,252,252));
        checkBoxNetBank.setBounds(400, 520, 200, 25);
        add(checkBoxNetBank);

        checkBoxCheque = new JCheckBox("Cheque Book");
        checkBoxCheque.setFont(new Font("Raleway", Font.BOLD, 18));
        checkBoxCheque.setBackground(new Color(215,252,252));
        checkBoxCheque.setBounds(150, 560, 200, 25);
        add(checkBoxCheque);

        checkBoxMobBank = new JCheckBox("Mobile Banking");
        checkBoxMobBank.setFont(new Font("Raleway", Font.BOLD, 18));
        checkBoxMobBank.setBackground(new Color(215,252,252));
        checkBoxMobBank.setBounds(400, 560, 200, 25);
        add(checkBoxMobBank);

        checkBoxStatement = new JCheckBox("E-Statement");
        checkBoxStatement.setFont(new Font("Raleway", Font.BOLD, 18));
        checkBoxStatement.setBackground(new Color(215,252,252));
        checkBoxStatement.setBounds(150, 600, 200, 25);
        add(checkBoxStatement);

        checkBoxEmailAlrt = new JCheckBox("E-mail Alert");
        checkBoxEmailAlrt.setFont(new Font("Raleway", Font.BOLD, 18));
        checkBoxEmailAlrt.setBackground(new Color(215,252,252));
        checkBoxEmailAlrt.setBounds(400, 600, 200, 25);
        add(checkBoxEmailAlrt);

        JCheckBox checkBoxAgree = new JCheckBox("I hereby decleares that the above entend details correct.",true);
        checkBoxAgree.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBoxAgree.setBackground(new Color(215,252,252));
        checkBoxAgree.setBounds(100, 640, 500, 25);
        add(checkBoxAgree);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonSubmit.setForeground(new Color(215,252,252));
        buttonSubmit.setBackground(Color.BLACK);
        buttonSubmit.setBounds(200,700,100,25);
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonCancel.setForeground(new Color(215,252,252));
        buttonCancel.setBackground(Color.BLACK);
        buttonCancel.setBounds(500,700,100,25);
        buttonCancel.addActionListener(this);
        add(buttonCancel);


        getContentPane().setBackground(new Color(215,252,252));
        setSize(850,800);
        setLayout(null);
        setLocation(400, 20);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String accType = null;
        if(rButtonSav.isSelected()){
            accType = "Saving Account";
        }
        else if(rButtonCurr.isSelected()){
            accType = "Current Account";
        }
        else if(rButtonFix.isSelected()){
            accType = "Fixed Deposit Account";
        }
        else if(rButtonRecurr.isSelected()){
            accType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong()%90000000l) + 1409963000000000l;
        String cardNo = "" + Math.abs(first7);

        long first3 = (ran.nextLong()%9000l) + 1000l;
        String pin = "" + Math.abs(first3);

        String service = "";
        if(checkBoxAtm.isSelected()){
            service = service + "ATM Card, ";
        }
        if(checkBoxNetBank.isSelected()){
            service = service + "Net Banking, ";
        }
        if(checkBoxCheque.isSelected()){
            service = service + "Cheque Book, ";
        }
        if(checkBoxMobBank.isSelected()){
            service = service + "Mobile Banking, ";
        }
        if(checkBoxStatement.isSelected()){
            service = service + "E-Statement, ";
        }
        if(checkBoxEmailAlrt.isSelected()){
            service = service + "Email Alert";
        }

        try{
            if(e.getSource()==buttonSubmit){ // if user will click on submit button then.
                if(accType.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else{
                    Conn con1 = new Conn();
                    String query1 = "insert into accountdetail values('"+formNo+"', '"+accType+"', '"+cardNo+"', '"+pin+"', '"+service+"')";
                    String query2 = "insert into login values('"+formNo+"', '"+cardNo+"', '"+pin+"')";
                    con1.statement.executeUpdate(query1);
                    con1.statement.executeUpdate(query2);
                    //It will show the message on the screen at the time of submiting the form.
                    JOptionPane.showMessageDialog(null, "Card no :- " + cardNo + "\nPin no :- " + pin);
                    new Deposits(pin);
                    setVisible(false);
                }
            }
            else if(e.getSource() == buttonCancel){
                System.exit(0);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AccountDetails("");
    }
}
