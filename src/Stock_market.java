import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Check3{
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_amount(String s)
    {
        Pattern p = Pattern.compile("[0-9]*.[0-9]*");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_no_of_shares(String s)
    {
        Pattern p = Pattern.compile("[1-9][0-9]*");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isValid_nav(String s)
    {
        Pattern p = Pattern.compile("[0-9]*.[0-9]*");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    ////////////////////////////////////////////////////////////////////////////

}

public class Stock_market extends JFrame {
    public void Stock_market(String a){
        Stock_market frame = new Stock_market();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ////////////////////////////////////COMBO BOX 1///////////////////////////////////////////////////////////////////////////////////
        String[] stock_name = {"Select --", "Reliance Industries Ltd." , "Tata Consultancy Services Ltd." , "HDFC Bank Ltd." , "Hindustan Unilever Ltd." , "Housing Development Finance Corporation Ltd." , "Infosys Ltd." , "Kotak Mahindra Bank Ltd."};

        JComboBox combo1 = new JComboBox(stock_name);
        add(combo1);
        combo1.setBounds(((screenSize.width*14)/32),((screenSize.height*11)/32),((screenSize.width*4)/32),((screenSize.height*2)/32));
        ///////////////////////////////////COMBO BOX 2//////////////////////////////////////////////////////////////////////////////////////
        String[] scheme_name = {"Equity scheme Dividend", "Liquid fund",
                "Equity scheme Growth",
                "", "","",
                "", "","",
                "", "", "",
                "", "", "",
                "",
                "", ""};

        JComboBox combo2 = new JComboBox(scheme_name);
        add(combo2);
        combo2.setBounds(((screenSize.width*19)/32),((screenSize.height*11)/32),((screenSize.width*4)/32),((screenSize.height*2)/32));
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JLabel l1 = new JLabel("Date");
        JLabel l2 = new JLabel("Stock name");
        JLabel l3 = new JLabel("No of shares");
        JLabel l4 = new JLabel("Rate");
        JLabel l5 = new JLabel("Amount");

        JTextField date = new JTextField(15);
        JTextField no_of_shares = new JTextField(15);
        JTextField nav = new JTextField(15);
        JTextField amount = new JTextField(15);

        JButton submit = new JButton("Submit");
        JButton exit = new JButton("Cancel");
        JButton submit_add_another = new JButton("Submit and add another");

        submit.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*5)/320)));
        submit_add_another.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*5)/320)));
        exit.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*5)/320)));

        l1.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        l2.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        l3.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        l4.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        l5.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));


        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Submit");
                String v= date.getText();
                String w = no_of_shares .getText();
                String x = combo1.getSelectedItem().toString();
                String y = nav.getText();
                String z = amount.getText();

                Check3 c = new Check3();
                if(!(c.isValid_no_of_shares(w))){
                    JOptionPane.showMessageDialog(null,"Invalid num of shares");
                }
                if(!(c.isValid_amount(z))){
                    JOptionPane.showMessageDialog(null,"Invalid Amount");
                }
                if(!(c.isValid_nav(y))){
                    JOptionPane.showMessageDialog(null,"Invalid NAV value");
                }
                if((c.isValid_nav(y))&&(!(x == null))&&(c.isValid_no_of_shares(w))&&(c.isValid_amount(z))) {
                    JOptionPane.showMessageDialog(null,"Your entries are saved succesfully");
                    //490//////////////////////////////////////////////////database///////////////////////////////////////////////////////////////
                    try {
                        String query = " insert into Stockmarket(Usr,Dates,Company,No_of_shares,NAV,Amount) "+"values (?,?,?,?,?,?)";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AD7","root","agarwal777anshul");
                        PreparedStatement q = conn.prepareStatement(query);
                        q.setString(1,a);
                        q.setString(2,date.getText());
                        q.setString(3,(combo1.getSelectedItem()).toString());
                        q.setString(4,no_of_shares .getText());
                        q.setString(5,nav.getText());
                        q.setString(6,amount.getText());
                        q.execute();
                        q.close();

                    } catch (Exception s) {
                        System.out.println(s.getMessage());
                    }
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    Data_option d1 = new Data_option();
                    d1.Data_option(a);
                    frame.setVisible(false);
                }
                Data_option d1 = new Data_option();
                d1.Data_option(a);
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

        submit_add_another.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Submit and add another");
                String v= date.getText();
                String w = no_of_shares .getText();
                String x = combo1.getSelectedItem().toString();
                String y = nav.getText();
                String z = amount.getText();

                Check3 c = new Check3();
                if(!(c.isValid_no_of_shares(w))){
                    JOptionPane.showMessageDialog(null,"Invalid num of shares");
                }
                if(!(c.isValid_amount(z))){
                    JOptionPane.showMessageDialog(null,"Invalid Amount");
                }
                if(!(c.isValid_nav(y))){
                    JOptionPane.showMessageDialog(null,"Invalid NAV value");
                }
                if((c.isValid_nav(y))&&(!(x == null))&&(c.isValid_no_of_shares(w))&&(c.isValid_amount(z))) {
                    JOptionPane.showMessageDialog(null,"Your entries are saved succesfully");
                    //490//////////////////////////////////////////////////database///////////////////////////////////////////////////////////////
                    try {
                        String query = " insert into Stockmarket(Usr,Dates,Company,No_of_shares,NAV,Amount) "+"values (?,?,?,?,?,?)";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AD7","root","agarwal777anshul");
                        PreparedStatement q = conn.prepareStatement(query);
                        q.setString(1,a);
                        q.setString(2,date.getText());
                        q.setString(3,(combo1.getSelectedItem()).toString());
                        q.setString(4,no_of_shares .getText());
                        q.setString(5,nav.getText());
                        q.setString(6,amount.getText());
                        q.execute();
                        q.close();

                    } catch (Exception s) {
                        System.out.println(s.getMessage());
                    }
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    Data_option d1 = new Data_option();
                    d1.Data_option(a);
                    frame.setVisible(false);
                }
                Stock_market s1 = new Stock_market();
                s1.Stock_market(a);
                frame.setVisible(false);
            }
        });

        Design obj = new Design(new GridBagLayout());
        obj.drawing();

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.gridx = 2;
        constraints1.gridy = 0;

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.CENTER;
        constraints2.gridx = 0;
        constraints2.gridy = 1;

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.CENTER;
        constraints3.gridx =2;
        constraints3.gridy = 1;

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.anchor = GridBagConstraints.CENTER;
        constraints4.gridx = 4;
        constraints4.gridy = 1;

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.anchor = GridBagConstraints.CENTER;
        constraints5.gridx = 6;
        constraints5.gridy = 1;

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.anchor = GridBagConstraints.CENTER;
        //constraints6.insets = new Insets(10, 10, 10, 10);
        constraints6.gridx = 8;
        constraints6.gridy = 1;

        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.anchor = GridBagConstraints.CENTER;
        //constraints7.insets = new Insets(10, 10, 10, 10);
        constraints7.gridx = 0;
        constraints7.gridy = 3;

        GridBagConstraints constraints8 = new GridBagConstraints();
        constraints8.anchor = GridBagConstraints.CENTER;
        //constraints8.insets = new Insets(10, 10, 10, 10);
        constraints8.gridx = 2;
        constraints8.gridy = 3;

        GridBagConstraints constraints9 = new GridBagConstraints();
        constraints9.anchor = GridBagConstraints.CENTER;
        //constraints9.insets = new Insets(10, 10, 10, 10);
        constraints9.gridx = 4;
        constraints9.gridy = 3;

        GridBagConstraints constraints10 = new GridBagConstraints();
        constraints10.anchor = GridBagConstraints.CENTER;
        //constraints10.insets = new Insets(10, 10, 10, 10);
        constraints10.gridx = 6;
        constraints10.gridy = 3;

        GridBagConstraints constraints11 = new GridBagConstraints();
        constraints11.anchor = GridBagConstraints.CENTER;
        //constraints11.insets = new Insets(10, 10, 10, 10);
        constraints11.gridx = 8;
        constraints11.gridy = 3;

        GridBagConstraints constraints12 = new GridBagConstraints();
        constraints12.anchor = GridBagConstraints.CENTER;
        //constraints12.insets = new Insets(10, 10, 10, 10);
        constraints12.gridx = 2;
        constraints12.gridy = 5;

        GridBagConstraints constraints13 = new GridBagConstraints();
        constraints13.anchor = GridBagConstraints.CENTER;
        //constraints13.insets = new Insets(10, 10, 10, 10);
        constraints13.gridx = 4;
        constraints13.gridy = 5;

        GridBagConstraints constraints14 = new GridBagConstraints();
        constraints14.anchor = GridBagConstraints.CENTER;
        //constraints14.insets = new Insets(10, 10, 10, 10);
        constraints14.gridx = 6;
        constraints14.gridy = 5;

        //obj.add(L, constraints1);
        obj.add(l1, constraints2);
        obj.add(l2, constraints3);
        obj.add(l3, constraints4);
        obj.add(l4, constraints5);
        obj.add(l5, constraints6);

        obj.add(date, constraints7);
        obj.add(combo1, constraints8);
        obj.add(no_of_shares, constraints9);
        obj.add(nav, constraints10);
        obj.add(amount, constraints11);

        obj.add(submit, constraints12);
        obj.add(submit_add_another, constraints13);
        obj.add(exit, constraints14);

        frame.add(obj);
    }
}








