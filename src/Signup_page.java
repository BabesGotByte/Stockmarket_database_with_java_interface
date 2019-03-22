import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Check{
    public static boolean isValid_first_name(String s)
    {
        return s.matches( "[A-Z][a-zA-Z]*" );
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_middle_name(String s)
    {
        return s.matches( "[a-zA-Z]*" );
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_last_name(String s)
    {
        return s.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_mob_num(String s)
    {
        // 1) Begins with 0 or 91
        // 2) Then contains 7 or 8 or 9.
        // 3) Then contains 9 digits
        Pattern p = Pattern.compile("[0-9]{10}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_email_id(String s)
    {
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//condition for username
// have to check whether username exists in the database or not
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_password(String s)
    {
        Pattern p = Pattern.compile("[a-zA-Z]*");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

public class Signup_page extends JFrame {
    public void Signup_page(){
        Signup_page frame = new Signup_page();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel first_name = new JLabel("First Name");
        JLabel middle_name = new JLabel("Middle Name");
        JLabel last_name = new JLabel("Last Name");
        JLabel mob = new JLabel("Mobile num");
        JLabel email = new JLabel("Email");
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");
        JLabel confirm_password = new JLabel("Confirm Password");

        first_name.setFont(new Font("Serif", Font.PLAIN, 20));
        middle_name.setFont(new Font("Serif", Font.PLAIN, 20));
        last_name.setFont(new Font("Serif", Font.PLAIN, 20));
        mob.setFont(new Font("Serif", Font.PLAIN, 20));
        email.setFont(new Font("Serif", Font.PLAIN, 20));
        username.setFont(new Font("Serif", Font.PLAIN, 20));
        password.setFont(new Font("Serif", Font.PLAIN, 20));
        confirm_password.setFont(new Font("Serif", Font.PLAIN, 20));

        JTextField first_name_T = new JTextField(15);
        JTextField middle_name_T = new JTextField(15);
        JTextField last_name_T = new JTextField(15);
        JTextField mob_T = new JTextField(15);
        JTextField email_T = new JTextField(15);
        JTextField username_T = new JTextField(15);
        JTextField password_T = new JTextField(15);
        JTextField confirm_password_T = new JTextField(15);

        JButton submit = new JButton("Submit");
        JButton exit = new JButton("Exit");

        submit.setFont(new Font("Serif", Font.PLAIN, 40));
        exit.setFont(new Font("Serif", Font.PLAIN, 40));

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String a1 = first_name_T.getText();
                String a2 = last_name_T.getText();
                String a3 = mob_T.getText();
                String a4 = email_T.getText();
                String a6 = password_T.getText();
                String a7 = confirm_password_T.getText();
                Check c1 = new Check();
                if(!(c1.isValid_first_name(a1))){
                    JOptionPane.showMessageDialog(null,"Invalid first name   \nFirst name should be like Anshul");
                }
                if(!(c1.isValid_last_name(a2))){
                    JOptionPane.showMessageDialog(null,"Invalid last name");
                }
                if(!(c1.isValid_mob_num(a3))){
                    JOptionPane.showMessageDialog(null,"Invalid mobile number  \n0/91 6757574789 ");
                }
                if(!(c1.isValid_email_id(a4))){
                    JOptionPane.showMessageDialog(null,"Invalid email id");
                }
                if(!(c1.isValid_password(a6))){
                    JOptionPane.showMessageDialog(null,"Invalid password   \nust contains one digit from 0-9\n" +
                            " must contains one lowercase characters\n" +
                            " must contains one uppercase characters\n" +
                            " must contains one special symbols in the list \"@#$%\"\n" +
                            " match anything with previous condition checking\n" +
                            " length at least 6 characters and maximum of 20\t\n" +
                            ")\t\t\t# End of group");
                }
                if(!((a7).equals(a6))){
                    JOptionPane.showMessageDialog(null,"Both the password and confirm password should be same");
                }


                if((c1.isValid_first_name(a1))&&(c1.isValid_last_name(a2))&&(c1.isValid_mob_num(a3))&&(c1.isValid_email_id(a4))&&(c1.isValid_password(a6))&&((a7).equals(a6))) {
                    JOptionPane.showMessageDialog(null,"Your entries are saved succesfully");
                    try {
                        String query = " insert into Signup(First_name,Middle_name,Last_name,Mob,Email,Username,Password,Confirm_password)"+" values (?,?,?,?,?,?,?,?)";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AD7","root","agarwal777anshul");
                        PreparedStatement p = conn.prepareStatement(query);

                        p.setString(1, first_name_T.getText());
                        p.setString(2, middle_name_T.getText());
                        p.setString(3, last_name_T.getText());
                        p.setString(4, mob_T.getText());
                        p.setString(5, email_T.getText());
                        p.setString(6, username_T.getText());
                        p.setString(7, password_T.getText());
                        p.setString(8, confirm_password_T.getText());
                        p.execute();
                        p.close();

                    } catch (Exception q) {
                        System.out.println(q.getMessage());
                    }
                }
                //JOptionPane.showMessageDialog(null,"Your entries are saved succesfully");
                Startpage.main(new String[]{});
                frame.setVisible(false);
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

        Design1 obj = new Design1(new GridBagLayout());
        obj.drawing();

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.insets = new Insets(10, 10, 10, 10);
        constraints1.gridx = 1;
        constraints1.gridy = 1;

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.CENTER;
        constraints2.insets = new Insets(10, 10, 10, 10);
        constraints2.gridx = 1;
        constraints2.gridy = 2;

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.CENTER;
        constraints3.insets = new Insets(10, 10, 10, 10);
        constraints3.gridx = 1;
        constraints3.gridy = 3;

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.anchor = GridBagConstraints.CENTER;
        constraints4.insets = new Insets(10, 10, 10, 10);
        constraints4.gridx = 1;
        constraints4.gridy = 4;

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.anchor = GridBagConstraints.CENTER;
        constraints5.insets = new Insets(10, 10, 10, 10);
        constraints5.gridx = 1;
        constraints5.gridy = 5;

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.anchor = GridBagConstraints.CENTER;
        constraints6.insets = new Insets(10, 10, 10, 10);
        constraints6.gridx = 1;
        constraints6.gridy = 6;
        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.anchor = GridBagConstraints.CENTER;
        constraints7.insets = new Insets(10, 10, 10, 10);
        constraints7.gridx = 1;
        constraints7.gridy = 7;

        GridBagConstraints constraints8 = new GridBagConstraints();
        constraints8.anchor = GridBagConstraints.CENTER;
        constraints8.insets = new Insets(10, 10, 10, 10);
        constraints8.gridx = 1;
        constraints8.gridy = 8;

        GridBagConstraints constraints9 = new GridBagConstraints();
        constraints9.anchor = GridBagConstraints.CENTER;
        constraints9.insets = new Insets(10, 10, 10, 10);
        constraints9.gridx = 2;
        constraints9.gridy = 1;

        GridBagConstraints constraints10 = new GridBagConstraints();
        constraints10.anchor = GridBagConstraints.CENTER;
        constraints10.insets = new Insets(10, 10, 10, 10);
        constraints10.gridx = 2;
        constraints10.gridy = 2;

        GridBagConstraints constraints11 = new GridBagConstraints();
        constraints11.anchor = GridBagConstraints.CENTER;
        constraints11.insets = new Insets(10, 10, 10, 10);
        constraints11.gridx = 2;
        constraints11.gridy = 3;

        GridBagConstraints constraints12 = new GridBagConstraints();
        constraints12.anchor = GridBagConstraints.CENTER;
        constraints12.insets = new Insets(10, 10, 10, 10);
        constraints12.gridx = 2;
        constraints12.gridy = 4;

        GridBagConstraints constraints13 = new GridBagConstraints();
        constraints13.anchor = GridBagConstraints.CENTER;
        constraints13.insets = new Insets(10, 10, 10, 10);
        constraints13.gridx = 2;
        constraints13.gridy = 5;

        GridBagConstraints constraints14 = new GridBagConstraints();
        constraints14.anchor = GridBagConstraints.CENTER;
        constraints14.insets = new Insets(10, 10, 10, 10);
        constraints14.gridx = 2;
        constraints14.gridy = 6;

        GridBagConstraints constraints15 = new GridBagConstraints();
        constraints15.anchor = GridBagConstraints.CENTER;
        constraints15.insets = new Insets(10, 10, 10, 10);
        constraints15.gridx = 2;
        constraints15.gridy = 7;

        GridBagConstraints constraints16 = new GridBagConstraints();
        constraints16.anchor = GridBagConstraints.CENTER;
        constraints16.insets = new Insets(10, 10, 10, 10);
        constraints16.gridx = 2;
        constraints16.gridy = 8;

        GridBagConstraints constraints17 = new GridBagConstraints();
        constraints17.anchor = GridBagConstraints.CENTER;
        constraints17.insets = new Insets(10, 10, 10, 10);
        constraints17.gridx = 1;
        constraints17.gridy = 10;

        GridBagConstraints constraints18 = new GridBagConstraints();
        constraints18.anchor = GridBagConstraints.CENTER;
        constraints18.insets = new Insets(10, 10, 10, 10);
        constraints18.gridx = 2;
        constraints18.gridy = 10;


        obj.add(first_name, constraints1);
        obj.add(middle_name, constraints2);
        obj.add(last_name, constraints3);
        obj.add(mob, constraints4);
        obj.add(email, constraints5);
        obj.add(username, constraints6);
        obj.add(password, constraints7);
        obj.add(confirm_password, constraints8);
        obj.add(first_name_T, constraints9);
        obj.add(middle_name_T, constraints10);
        obj.add(last_name_T, constraints11);
        obj.add(mob_T, constraints12);
        obj.add(email_T, constraints13);
        obj.add(username_T, constraints14);
        obj.add(password_T, constraints15);
        obj.add(confirm_password_T, constraints16);
        obj.add(submit, constraints17);
        obj.add(exit, constraints18);

        frame.add(obj);
    }
}




