package jSpinner;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
/*
 * CHECK ALSO SpinnerNumberModel (HOLD <Ctrl>+clik)
 */


public class MyJSpinner {
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

class MyPanel extends JPanel{

    private JSpinner spinner;

    public MyPanel() {

        String[] months={"Jan","Feb","Mar","Apr","May","Jun"};
        SpinnerListModel listModel = new SpinnerListModel(months);
        
        spinner=new JSpinner(listModel);
        spinner.setPreferredSize(new Dimension(50, 20));
        
        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(spinner.getValue());
            }
            
        });

        add(spinner);
    }

    
}
