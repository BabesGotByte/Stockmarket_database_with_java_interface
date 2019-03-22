import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Data_display extends JFrame {

    public void Data_display(String a){
        Data_display frame = new Data_display();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JButton exit = new JButton("Cancel");
        exit.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*5)/320)));
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(
                        null,"Would you like EXIT",
                        "Question",
                        JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                    Startpage s = new Startpage();
                    s.setBounds(0,0,screenSize.width, screenSize.height);
                    s.setVisible(true);
                    dispose();
                }
            }
        });

        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/AD7";
        String userName = "root";
        String password = "agarwal777anshul";
        String[] columnNames = {"Usr","Dates","Company","No_of_shares","NAV","Amount"};

            DefaultTableModel model;
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            JTable table = new JTable();
            table.setModel(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            String Usr= "";
            String Dates= "";
            String Company= "";
            String NO_of_shares = "";
            String NAV = "";
            String Amount = "";
            try
            {
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, userName, password);
                String sql = "select * from Stockmarket";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int i =0;
                String user,dates,company,no_of_shares,nav,amount;
                while(rs.next())
                {
                    if((rs.getString("Usr").equals(a))) {
                        user = rs.getString("Usr");
                        dates = rs.getString("Dates");
                        company = rs.getString("Company");
                        no_of_shares = rs.getString("No_of_shares");
                        nav = rs.getString("NAV");
                        amount = rs.getString("Amount");
                        model.addRow(new Object[]{user,dates, company, no_of_shares, nav, amount});
                        i++;
                    }
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            frame.add(scroll);
            frame.setVisible(true);



        Design obj = new Design(new GridBagLayout());
        obj.drawing();
        frame.add(obj);
    }
}






