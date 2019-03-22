import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Data_feed extends JFrame {

    public void Data_feed(String a){
        Data_feed frame = new Data_feed();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton r1 = new JRadioButton();
        JRadioButton r2 = new JRadioButton();
        JRadioButton r3 = new JRadioButton();
        JRadioButton r4 = new JRadioButton();
        JRadioButton r5 = new JRadioButton();

        r1.setBackground(Color.white);
        r2.setBackground(Color.white);
        r3.setBackground(Color.white);
        r4.setBackground(Color.white);
        r5.setBackground(Color.white);

        JButton ok = new JButton("Done");
        JButton exit = new JButton("Cancel");

        r1.setText("Stock Market");
        r2.setText("Mutual Funds");
        r3.setText("Bit coins");
        r4.setText("x");
        r5.setText("y");

        ButtonGroup b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);
        b1.add(r4);
        b1.add(r5);

        r1.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));
        r2.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));
        r3.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));
        r4.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));
        r5.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*6)/320)));
        ok.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));
        exit.setFont(new Font("Serif", Font.PLAIN, ((screenSize.width*7)/320)));

        ok.setFont(new Font("Serif", Font.PLAIN, 20));
        exit.setFont(new Font("Serif", Font.PLAIN, 20));

        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You Selected Stock market");
                    Stock_market d1 = new Stock_market();
                    d1.Stock_market(a);
                    frame.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You have not Selected any option");
                }
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
                    Data_option s = new Data_option();
                    s.Data_option(a);
                    frame.setVisible(false);
                }
            }
        });

        Design obj = new Design(new GridBagLayout());
        obj.drawing();

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.gridx = 1;
        constraints1.gridy = 0;

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.WEST;
        constraints2.gridx = 1;
        constraints2.gridy = 1;

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.WEST;
        constraints3.gridx = 1;
        constraints3.gridy = 2;

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.anchor = GridBagConstraints.WEST;
        constraints4.gridx = 1;
        constraints4.gridy = 3;

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.anchor = GridBagConstraints.WEST;
        constraints5.gridx = 1;
        constraints5.gridy = 4;

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.anchor = GridBagConstraints.WEST;
        constraints6.insets = new Insets(10, 10, 10, 10);
        constraints6.gridx = 0;
        constraints6.gridy = 5;

        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.anchor = GridBagConstraints.WEST;
        constraints7.insets = new Insets(10, 10, 10, 10);
        constraints7.gridx = 2;
        constraints7.gridy = 5;


        obj.add(r1, constraints1);
        obj.add(r2, constraints2);
        obj.add(r3, constraints3);
        obj.add(r4, constraints4);
        obj.add(r5, constraints5);
        obj.add(ok, constraints6);
        obj.add(exit, constraints7);

        frame.add(obj);
    }
}





