package RadioButtons;


import java.awt.event.*;

import javax.swing.*;


public class RadioButtons {
    public static void main(String[] args) {
        new MyFrame().setVisible(true);;
    }
}

class MyFrame extends JFrame{

    MyFrame() {
        setBounds(200, 150, 700, 400);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         // setVisible(true);!!
        add(new MyPanel());
    }

}

class MyPanel extends JPanel implements ActionListener{
    private JRadioButton button1;
    private JRadioButton button2;
    private JRadioButton button3;

    MyPanel(){
        
        //intance radioButton
        button1= new JRadioButton("Si");
        button2= new JRadioButton("No");
        button3= new JRadioButton("Depende");
        
        //add listener
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        //Create a group
        ButtonGroup group=new ButtonGroup();
        group.add(button1);
        group.add(button3);
        group.add(button2);
        
        //add to panel
        add(button1);
        add(button2);
        add(button3);

    }
    //ACTION
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton button=(AbstractButton)e.getSource();
        System.out.println(button.getText());
    }

    
}

