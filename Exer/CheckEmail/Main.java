package CheckEmail;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Main {
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

class MyPanel extends JPanel implements ActionListener {
private JTextField readTextField;
private JButton buttonCheck;
private JButton printResult;
// CONSTRUCTOR PANEL
    public MyPanel() {
        setLayout(new GridLayout(3, 0));

        readTextField = new JTextField(20);
        buttonCheck = new JButton("check email");
        printResult = new JButton();
        printResult.setEnabled(false);
        
        add(readTextField);
        add(buttonCheck);
        add(printResult);

        buttonCheck.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int count=0;
        char[] character = readTextField.getText().toCharArray();
        if (readTextField.getText().length()>0) {//if text are at least have 1 character in field
            for (int i = 0; i < character.length; i++) {//for(int i = 0; i < readTextField.getText().length; i++)
                if (character[i]=='@') {                //if(readTextField.getText().charAt(i)=='@') count++
                     count++;
                 }
                
            }
            if (count==1) {
                printResult.setText("Correct email");
            }
            else{
                printResult.setText("Wrong email!!");
            }
            
        }
    }

    
}



