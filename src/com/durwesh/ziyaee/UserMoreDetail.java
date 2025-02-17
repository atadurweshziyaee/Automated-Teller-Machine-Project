package com.durwesh.ziyaee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMoreDetail extends JFrame implements ActionListener {
    JComboBox comboBoxReligion, comboBoxCategory, comboBoxIncome, comboBoxEducational, comboBoxOccupation;
    JRadioButton buttonSeniorY, buttonSeniorN, buttonExistY, buttonExistN;
    JButton buttonNext;
    JTextField textPAN, textAadhar;
    String formNo;
    UserMoreDetail(String first){

        super("Application Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formNo = first;

        JLabel labelFormNo = new JLabel("Form No:- ");
        labelFormNo.setFont(new Font("Raleway", Font.BOLD,22));
        labelFormNo.setBounds(300,10,200,40);
        add(labelFormNo);

        JLabel labelActualFormNo = new JLabel(formNo);
        labelActualFormNo.setFont(new Font("Raleway", Font.BOLD,22));
        labelActualFormNo.setBounds(400,10,200,40);
        add(labelActualFormNo);

        JLabel labelPageNo = new JLabel("Page 2");
        labelPageNo.setFont(new Font("Raleway", Font.BOLD, 18));
        labelPageNo.setBounds(750,40,600, 40);
        add(labelPageNo);

        JLabel labelDetails = new JLabel("Additional Details");
        labelDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        labelDetails.setBounds(350,100,400,40);
        add(labelDetails);

        JLabel labelReligion = new JLabel("Religion : ");
        labelReligion.setFont(new Font("Raleway", Font.BOLD, 22));
        labelReligion.setBounds(100,140,300,40);
        add(labelReligion);

        String religion[] = {"selected","hindu", "Muslim", "sikh", "christan", "Others"};
        comboBoxReligion = new JComboBox(religion);
        comboBoxReligion.setFont(new Font("Raleway", Font.BOLD, 18));
        comboBoxReligion.setBackground(new Color(252,208,76));
        comboBoxReligion.setBounds(300, 145, 400, 30);
        add(comboBoxReligion);

        JLabel labelCategory = new JLabel("Category : ");
        labelCategory.setFont(new Font("Raleway", Font.BOLD, 22));
        labelCategory.setBounds(100,180,300,40);
        add(labelCategory);

        String category[] = {"General", "OBC", "SC", "ST", "Others"};
        comboBoxCategory = new JComboBox(category);
        comboBoxCategory.setFont(new Font("Raleway", Font.BOLD, 18));
        comboBoxCategory.setBackground(new Color(252,208,76));
        comboBoxCategory.setBounds(300, 185, 400, 30);
        add(comboBoxCategory);

        JLabel labelIncome = new JLabel("Income : ");
        labelIncome.setFont(new Font("Raleway", Font.BOLD, 22));
        labelIncome.setBounds(100,220,300,40);
        add(labelIncome);

        String income[] = {"NULL", "< 1,50,000","< 2,50,000", "< 5,00,000", "Upto 10 Lac", " > 10 Lac"};
        comboBoxIncome = new JComboBox(income);
        comboBoxIncome.setFont(new Font("Raleway", Font.BOLD, 18));
        comboBoxIncome.setBackground(new Color(252,208,76));
        comboBoxIncome.setBounds(300, 225, 400, 30);
        add(comboBoxIncome);

        JLabel labelEducational = new JLabel("Educational : ");
        labelEducational.setFont(new Font("Raleway", Font.BOLD, 22));
        labelEducational.setBounds(100,260,300,40);
        add(labelEducational);

        String educational[] = {"Illitrate", "Matriculation", "Inter", "UG", "PG", "Master's", "PHD"};
        comboBoxEducational = new JComboBox(educational);
        comboBoxEducational.setFont(new Font("Raleway", Font.BOLD, 18));
        comboBoxEducational.setBackground(new Color(252,208,76));
        comboBoxEducational.setBounds(300, 265, 400, 30);
        add(comboBoxEducational);

        JLabel labelOccupation = new JLabel("Occupation : ");
        labelOccupation.setFont(new Font("Raleway", Font.BOLD, 22));
        labelOccupation.setBounds(100,300,300,40);
        add(labelOccupation);

        String occupation[] = {"Self-Employed", "Salaried", "Business-man", "Retried", "Student","Others"};
        comboBoxOccupation = new JComboBox(occupation);
        comboBoxOccupation.setFont(new Font("Raleway", Font.BOLD, 18));
        comboBoxOccupation.setBackground(new Color(252,208,76));
        comboBoxOccupation.setBounds(300, 305, 400, 30);
        add(comboBoxOccupation);

        JLabel labelPAN = new JLabel("PAN no : ");
        labelPAN.setFont(new Font("Raleway", Font.BOLD, 22));
        labelPAN.setBounds(100, 340, 300, 40);
        add(labelPAN);

        textPAN = new JTextField();
        textPAN.setFont(new Font("Raleway", Font.BOLD, 18));
        textPAN.setBounds(300, 345, 400, 30);
        textPAN.setBackground(new Color(252,208,76));
        add(textPAN);

        JLabel labelAadhar = new JLabel("Aadhar no : ");
        labelAadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        labelAadhar.setBounds(100, 380, 300, 40);
        add(labelAadhar);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        textAadhar.setBounds(300, 385, 400, 30);
        textAadhar.setBackground(new Color(252,208,76));
        add(textAadhar);

        JLabel labelSeniorCtz = new JLabel("Senior Citizen : ");
        labelSeniorCtz.setFont(new Font("Raleway", Font.BOLD, 22));
        labelSeniorCtz.setBounds(100, 425, 300, 40);
        add(labelSeniorCtz);

        buttonSeniorY = new JRadioButton("Yes");
        buttonSeniorY.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonSeniorY.setBackground(new Color(252,208,76));
        buttonSeniorY.setBounds(350,425,100,30);
        add(buttonSeniorY);

        buttonSeniorN = new JRadioButton("No");
        buttonSeniorN.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonSeniorN.setBackground(new Color(252,208,76));
        buttonSeniorN.setBounds(450,425,100,30);
        add(buttonSeniorN);

        ButtonGroup buttonGroupSenior = new ButtonGroup();
        buttonGroupSenior.add(buttonSeniorY);
        buttonGroupSenior.add(buttonSeniorN);

        JLabel labelExistAcc = new JLabel("Existing Account : ");
        labelExistAcc.setFont(new Font("Raleway", Font.BOLD, 22));
        labelExistAcc.setBounds(100, 465, 300, 40);
        add(labelExistAcc);

        buttonExistY = new JRadioButton("Yes");
        buttonExistY.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonExistY.setBackground(new Color(252,208,76));
        buttonExistY.setBounds(350,465,100,30);
        add(buttonExistY);

        buttonExistN = new JRadioButton("No");
        buttonExistN.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonExistN.setBackground(new Color(252,208,76));
        buttonExistN.setBounds(450,465,100,30);
        add(buttonExistN);

        ButtonGroup buttonExistAcc = new ButtonGroup();
        buttonExistAcc.add(buttonExistY);
        buttonExistAcc.add(buttonExistN);

        buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("Raleway", Font.BOLD, 18));
        buttonNext.setForeground(new Color(252,208,76));
        buttonNext.setBackground(Color.BLACK);
        buttonNext.setBounds(600,600,100,30);
        buttonNext.addActionListener(this);
        add(buttonNext);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String reli = (String) comboBoxReligion.getSelectedItem();
        String cate = (String) comboBoxCategory.getSelectedItem();
        String income = (String) comboBoxIncome.getSelectedItem();
        String educa = (String) comboBoxEducational.getSelectedItem();
        String occu = (String) comboBoxOccupation.getSelectedItem();
        String pan = textPAN.getText();
        String aadhar = textAadhar.getText();

        String seniorCtz = " ";
        if(buttonSeniorY.isSelected()){
            seniorCtz = "Yes";
        }
        else if(buttonSeniorN.isSelected()){
            seniorCtz = "No";
        }

        String existAcc = " ";
        if(buttonExistY.isSelected()){
            existAcc = "Yes";
        }
        else if(buttonExistN.isSelected()){
            existAcc = "No";
        }

        try{
            if(textPAN.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else{
                Conn conn1 = new Conn();
                String query = "insert into usermoredetail values('"+formNo+"', '"+reli+"', '"+cate+"', '"+income+"', '"+educa+"', '"+occu+"', '"+pan+"', '"+aadhar+"', '"+seniorCtz+"', '"+existAcc+"')";
                conn1.statement.executeUpdate(query);
                new AccountDetails(formNo);
                setVisible(false);
            }

        }
        catch(Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new UserMoreDetail("");
    }
}
