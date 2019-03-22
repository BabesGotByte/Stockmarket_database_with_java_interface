import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Data_option extends JFrame {

    public void Data_option(String a){
        Data_option frame = new Data_option();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton dataf = new JButton("Data_feed");
        JButton datad = new JButton("Data_display");
        JButton exit = new JButton("Exit");

        dataf.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        datad.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        exit.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));


        dataf.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Data_feed f3 = new Data_feed();
                f3.Data_feed(a);
                frame.setVisible(false);
            }
        });
        datad.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Data_display f3 = new Data_display();
                f3.Data_display(a);
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

        Design obj = new Design(new GridBagLayout());
        obj.drawing();

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(10, 10, 10, 10);
        constraints1.gridx = 0;
        constraints1.gridy = 0;

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.WEST;
        constraints2.insets = new Insets(10, 10, 10, 10);
        constraints2.gridx = 1;
        constraints2.gridy = 0;

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.WEST;
        constraints3.insets = new Insets(10, 10, 10, 10);
        constraints3.gridx = 2;
        constraints3.gridy = 0;

        obj.add(dataf, constraints1);
        obj.add(datad, constraints2);
        obj.add(exit, constraints3);

        frame.add(obj);
    }
}




