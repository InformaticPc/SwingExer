package jSlider;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class MyJSlider {
    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}

class MyFrame extends JFrame{

    public MyFrame() {
        setBounds(200, 150, 700, 400);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         // setVisible(true);!!
        add(new MyPanel());
    }
    
}

class MyPanel extends JPanel implements ActionListener, ChangeListener{

    private JSlider slider;
    private JComboBox<String> comboList;
    private String[] list={"Yu Gothic Medium", "Verdana", "Sitka Display", "Trebuchet MS"};
    private JLabel text;
    
    public MyPanel() {

        setLayout(new BorderLayout());
        //a panel for add slider & combolist in North
        JPanel panelTop=new JPanel();

        comboList=new JComboBox<>(list);
        comboList.setSelectedItem("Sitka Display");

        text=new JLabel("Prove text");
        
        //setup slider
        slider=new JSlider(SwingConstants.HORIZONTAL, 5, 52, 15);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // ADD ChangeListener
        slider.addChangeListener(this);
        //ADD ActionListener
        comboList.addActionListener(this);
        
        //text start as slider and comboList values
        text.setFont(new Font((String) comboList.getSelectedItem(), Font.PLAIN, slider.getValue()));
        text.setHorizontalAlignment(SwingConstants.CENTER);//Align in the center

        //add components to NORTH panel
        panelTop.add(comboList);
        panelTop.add(slider);

        add(panelTop, BorderLayout.NORTH);
        add(text, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name=(String)comboList.getSelectedItem();
        text.setFont(new Font(name, Font.PLAIN, slider.getValue()));
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        String name=(String)comboList.getSelectedItem();

        text.setFont(new Font(name, Font.PLAIN, slider.getValue()));
    }
    
}
