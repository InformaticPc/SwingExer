package jTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MainTextFields {
    public static void main(String[] args) {
        new MyFrame().setVisible(true);        
    }
}

class MyFrame extends JFrame{
    
    public MyFrame(){
        setBounds(200, 150, 700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        add(new MyPanel());
    }    
}

class MyPanel extends JPanel{
    private JTextField readTextField;//read keyboard
    private JTextField prinTextField;//print text from another textField
    private String text="";//used for save text from printTextFields and concat strings to new text printed
    public MyPanel(){
        //read TEXT FIELD
        readTextField = new JTextField(20);
        add(readTextField);
        // JBUTTON
        JButton button = new JButton("print text");
        button.addActionListener(new GetText());
        add(button);
        //print TEXT FIELD
        prinTextField = new JTextField(20);
        add(prinTextField);
    }
    private class GetText implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            prinTextField.setText(text + readTextField.getText()+" ");
            text=prinTextField.getText();
            readTextField.setText("");
        } 
    }
}

