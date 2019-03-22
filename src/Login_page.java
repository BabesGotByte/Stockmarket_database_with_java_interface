import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login_page extends JFrame {
    public void Login_page(){
        Login_page frame = new Login_page();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");
        int x = ((screenSize.width*10)/32);
        JTextField username_T = new JTextField(15);
        JPasswordField password_T = new JPasswordField(15);
        JButton login = new JButton("Sign In");
        JButton exit = new JButton("Exit");

        username.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        password.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        login.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        exit.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        username_T.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));
        password_T.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));

        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
//                if((username_T.getText().equals("Anshul"))&&(password_T.getText().equals("Anshul123"))){
//                    //JOptionPane.showMessageDialog(null,"Successfully Login");
//                    Data_option d = new Data_option();
//                    d.Data_option();
//                    frame.setVisible(false);
//                }
//                else{
//                    JOptionPane.showMessageDialog(null,"Invalid combination of username and password");
//                }
                //////////////////////////////////////database part/////////////////////////////////////////////////
                try {
                    String a = username_T.getText();
                    char c[] = password_T.getPassword();
                    String b = new String(c);
//                    System.out.println(b);
//                    System.out.println(b); System.out.println(b);

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String query = "SELECT Username,Password FROM Signup WHERE Username='"+a+"' AND Password='"+b+"';";
//                    System.out.println(query);
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AD7","root","agarwal777anshul");
                    Statement s =conn.createStatement();
                    ResultSet r =s.executeQuery(query);
                    if(r.next()){
                        JOptionPane.showMessageDialog(null, "Logged in");
                        Data_option d = new Data_option();
                                d.Data_option(a);
                                frame.setVisible(false);
                    }
                    //System.out.println(b);

                    s.close();
                    r.close();

                }
                catch(Exception n){
                    JOptionPane.showMessageDialog(null,n);
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(
                        null,"Would you like EXIT",
                        "Question",
                        JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                    Startpage.main(new String[]{});
                    frame.setVisible(false);
                }
            }
        });

        Design obj = new Design(new GridBagLayout());
        obj.drawing();

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.insets = new Insets(10, 10, 10, 10);
        constraints1.gridx = 0;
        constraints1.gridy = 0;

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.CENTER;
        constraints2.insets = new Insets(10, 10, 10, 10);
        constraints2.gridx = 0;
        constraints2.gridy = 1;

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.CENTER;
        constraints3.insets = new Insets(10, 10, 10, 10);
        constraints3.gridx = 1;
        constraints3.gridy = 0;

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.anchor = GridBagConstraints.CENTER;
        constraints4.insets = new Insets(10, 10, 10, 10);
        constraints4.gridx = 1;
        constraints4.gridy = 1;

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.anchor = GridBagConstraints.CENTER;
        constraints5.insets = new Insets(10, 20, 10, 10);
        constraints5.gridx = 0;
        constraints5.gridy = 2;

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.anchor = GridBagConstraints.CENTER;
        constraints6.insets = new Insets(10, 10, 10, 20);
        constraints6.gridx = 1;
        constraints6.gridy = 2;

        obj.add(username, constraints1);
        obj.add(password, constraints2);
        obj.add(username_T, constraints3);
        obj.add(password_T, constraints4);
        obj.add(login, constraints5);
        obj.add(exit, constraints6);


        frame.add(obj);
    }
}



