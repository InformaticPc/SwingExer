package Exer.swingComponets;

import javax.swing.JPanel;

import SwingComponets.AbstractMyFrame;
import java.awt.event.*;
import java.awt.*;

import java.beans.*;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExerSwing {
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyFrame extends AbstractMyFrame{
    MyFrame(){
        super();
        add(new MyPanel());
    }
}
class MyPanel extends JPanel implements ActionListener{
    private static byte count=0;//used for print the new user just once.
    private JPanel top;
    private JPanel center;
    private JPanel botton;
    private JTextField textName;
    private JTextField textSurname;
    private JLabel labelName;
    private JLabel labelSurname;
    private JTextArea textArea;
    private JButton button1;
    private JButton button2;
    private JCheckBox box1;
    private JCheckBox box2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;

    MyPanel(){
        setLayout(new BorderLayout());
        
        //paneles
        top=new JPanel();
        center=new JPanel();
        botton=new JPanel();

        //TextField
        textName=new JTextField(20);
        textSurname=new JTextField(20);

        //Labels
        labelName=new JLabel("Name:");
        labelSurname=new JLabel("Surname:");

        //TextArea
        textArea=new JTextArea(15, 40);
        JScrollPane scrollPanel=new JScrollPane(textArea);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //buttons
        button1=new JButton("Button1");
        button2=new JButton("Button2");

        //checkBox
        box1=new JCheckBox("box 1:");
        box1.doClick();
        box2=new JCheckBox("box 2:");

        //radio button
        radioButton1=new JRadioButton("Radio 1:");
        radioButton2=new JRadioButton("Radio 2:");

        //listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        box1.addActionListener(this);
        box2.addActionListener(this);
        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);
        
        //add top panell
        top.add(labelName);
        top.add(textName);
        top.add(labelSurname);
        top.add(textSurname);

        //add central panel
        center.add(scrollPanel);
        
        //add botton panel
        botton.add(button1);
        botton.add(button2);
        botton.add(box1);
        botton.add(box2);
        botton.add(radioButton1);
        botton.add(radioButton2);

        //add panels
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(botton, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton button=(AbstractButton)e.getSource();
        if(count==0)textArea.setText("User: "+textName.getText()+" "+textSurname.getText()+"\n"); count++;//fist action in whatever button
        if(button.isSelected()) textArea.append(button.getText()+" selected\n");
        else if(e.getSource()==button1) textArea.append(button.getText()+" pressed\n");
        else if(e.getSource()==button2) textArea.append(button.getText()+" pressed\n");
        else textArea.append(button.getText()+" unselect\n");
    }
}