package jTextArea;


import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class UseDocuments {
    public static void main(String[] args) {
        new MyFrame().setVisible(true);;
    }
}

class MyFrame extends JFrame{
    
    public MyFrame(){
        setBounds(900, 150, 700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        add(new MyPanel());
    }    
}

class MyPanel extends JPanel implements ActionListener{
    private JTextArea readArea;
    public MyPanel(){
        //JTEXFIELDS
        JTextField readTextField = new JTextField(20);

        //JTEXTAREA
        readArea = new JTextArea(5, 15);//JTextArea always have Documents inside

        //JSCROLLPANE panel where put the document to be able to scroll it
        JScrollPane scrollPane = new JScrollPane(readArea);
        
        //JBUTTON for print area text in console
        JButton button = new JButton("Print text in console");
        button.addActionListener(this);
        
        readArea.setLineWrap(true);//its wraps automaticly WITHOUT pressing <enter>
        
        Document doc = readTextField.getDocument();
        doc.addDocumentListener(new TextListen());//Its listening the Documents NOT the JTField
        
        add(readTextField);
        add(scrollPane);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(readArea.getText());
    }
}

class TextListen implements DocumentListener{

    @Override
    public void insertUpdate(DocumentEvent e) {
        // When you introduce text to the document
        System.out.println("You have INTRODUCED text");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // When you remove text to the document
        System.out.println("You have REMOVED Text");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
    }

}
