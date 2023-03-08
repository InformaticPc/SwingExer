package jComboBox;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTest{
    
    public static void main(String[] args) {

        String[]fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String string : fonts) {
            System.out.println(string);
        }
        new MyFrame().setVisible(true);
    }
}

class MyFrame extends JFrame{
    MyFrame(){
        setBounds(200, 150, 700, 400);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         // setVisible(true);!!
        add(new MyPanel());
    }
}

class MyPanel extends JPanel implements ActionListener{

    private JComboBox<String> comboList;
    private String[] list={"Yu Gothic Medium", "Verdana", "Sitka Display", "Trebuchet MS"};
    private JLabel text;
    
    public MyPanel() {

        setLayout(new BorderLayout());

        comboList=new JComboBox<>(list);
        text=new JLabel("Prove text");
        text.setHorizontalAlignment(SwingConstants.CENTER);//Align in the center
        
        comboList.addActionListener(this);
        add(comboList, BorderLayout.NORTH);
        add(text, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name=(String)comboList.getSelectedItem();
        text.setFont(new Font(name, Font.PLAIN, 20));
    }
    
}