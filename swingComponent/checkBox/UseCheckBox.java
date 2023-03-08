package checkBox;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UseCheckBox {
    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}
class MyFrame extends JFrame{
    
    public MyFrame(){
        setBounds(900, 150, 700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        add(new MyPanel());
    }    
}

class MyPanel extends JPanel{

    private JPanel panelNorth;
    private JPanel panelSouth;
    private JLabel text;
    private JCheckBox checkBoxBolt;
    private JCheckBox checkBoxItalic;
    
    public MyPanel(){
        
        setLayout(new BorderLayout());
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        checkBoxBolt = new JCheckBox("Bolt font");
        checkBoxItalic = new JCheckBox("Italic font");
        
        text = new JLabel("Text to check check Box");
        text.setFont(new Font("Courier", Font.PLAIN, 20));

        panelNorth.add(text);

        checkBoxBolt.addActionListener(new CheckBoxAction());
        checkBoxItalic.addActionListener(new CheckBoxAction());

        panelSouth.add(checkBoxBolt);
        panelSouth.add(checkBoxItalic);

        
        add(panelNorth, BorderLayout.NORTH);
        add(panelSouth, BorderLayout.SOUTH);

        
        //NO SE ACTUALIZAN CUANDO HAGO CLIK EN LOS CKECKS
    }
    private class CheckBoxAction implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int font=0;
            if(checkBoxBolt.isSelected()) font+=1;
            
            if(checkBoxItalic.isSelected()) font+=Font.ITALIC;
            
            text.setFont(new Font("Courier", font, 20));
        }
    }

}

