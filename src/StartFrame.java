import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame  extends JFrame{
    private static JFrame frameStart;

    StartFrame(){
        frameStart=new JFrame("BIBLIOTECA");
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setSize(300, 150);
        JPanel panelStart=new JPanel();

        JLabel labelStart=new JLabel("BINE ATI VENIT LA BIBLIOTECA");
        labelStart.setHorizontalAlignment(SwingConstants.CENTER);

        JButton buttonStart=new JButton("START");


        panelStart.add(labelStart);
        panelStart.add(buttonStart);

        frameStart.add(panelStart, BorderLayout.CENTER);

        frameStart.setVisible(true);
        frameStart.setLocationRelativeTo(null);  //asta face sa il puna pe mijlocul ecranului

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int answer=JOptionPane.showConfirmDialog(null,"Sunteti utilizator nou?","Titlu",
                        JOptionPane.YES_NO_OPTION);
                if(answer==0){  //daca raspunsul este "DA"
                    frameStart.setVisible(false);
                   // PersNouFrame pers=new PersNouFrame();
                    PersNouFrame persNou=new PersNouFrame();

                    persNou.showFrame();

                }
                else{
                    frameStart.setVisible(false);
                    //framePrincipal.setVisible(true);
                }
            }
        });

    }
    public void showFrame(){
        frameStart.setVisible(true);
    }

}
