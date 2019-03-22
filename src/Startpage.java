import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startpage extends JFrame {

    public static void main(String args[]){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Startpage frame = new Startpage();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l = new JLabel("Welcome");
        JButton login = new JButton("Sign In");
        JButton sign_up = new JButton("Sign up");

        login.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*9)/320)));
        sign_up.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*9)/320)));
        l.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*9)/320)));

        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Login_page f1 = new Login_page();
                f1.Login_page();
                frame.setVisible(false);
            }
        });
        sign_up.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Signup_page f2 = new Signup_page();
                f2.Signup_page();
                frame.setVisible(false);
            }
        });

        Design obj = new Design(new GridBagLayout());
        obj.drawing();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 4;

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.insets = new Insets(10, 10, 10, 10);
        constraints1.gridx = 2;
        constraints1.gridy = 4;

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.CENTER;
        constraints2.insets = new Insets(10, 10, 10, 10);
        constraints2.gridx = 1;
        constraints2.gridy = 0;

        obj.add(login, constraints);
        obj.add(sign_up, constraints1);
        obj.add(l, constraints2);

        frame.add(obj);
    }
}

