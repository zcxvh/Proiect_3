import biblioteca.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersNouFrame {

    private  static JFrame persNouFrame;
    private static StartFrame startFrame;  //am adaugat un memebru la referinta StartFrame

   //PersNouFrame(StartFrame startFrame) {}
    PersNouFrame(){
       //instance=this;

       //PersNouFrame(){

       persNouFrame = new JFrame("Utilizator nou");
       persNouFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //persNouFrame.setSize(300,150);

       JPanel panelPersnou = new JPanel();
       panelPersnou.setLayout(new BoxLayout(panelPersnou, BoxLayout.Y_AXIS));
       JLabel labelPersnouID = new JLabel("Introduceti ID-ul:");    //o sa mai fie un buton gen ingo pentru ai spune
       // despre ce ID- este vorba
       JTextField textPersnouID = new JTextField(15);
       //textPersnouID.setAlignmentX(Component.LEFT_ALIGNMENT);

       JLabel labelPersnouNume = new JLabel("Introduceti nume:");
       JTextField textPersnouNume = new JTextField(15);

       JLabel labelInittata = new JLabel("Introduceti intiala tatalui");
       JTextField textInittata = new JTextField(15);

       JLabel labelPersnoPrenume = new JLabel("Introduceti prenume:");
       JTextField textPersnouPrenume = new JTextField(15);

       JLabel labelUniv = new JLabel("Introduceti universitatea:");
       JTextField textUninv = new JTextField(15);

       JLabel labelJud = new JLabel("Judet:");
       JTextField textJud = new JTextField(15);

       JButton buttonLogare = new JButton("Logare");

       JButton buttonInfo = new JButton("INFO");
       //JLabel label

       panelPersnou.add(labelPersnouID);
       panelPersnou.add(textPersnouID);

       panelPersnou.add(labelPersnouNume);
       panelPersnou.add(textPersnouNume);
       panelPersnou.add(labelInittata);
       panelPersnou.add(textInittata);
       panelPersnou.add(labelPersnoPrenume);
       panelPersnou.add(textPersnouPrenume);
       panelPersnou.add(labelUniv);
       panelPersnou.add(textUninv);
       panelPersnou.add(buttonLogare);
       panelPersnou.add(buttonInfo);
       persNouFrame.add(panelPersnou);
       persNouFrame.pack();


       buttonLogare.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String ID = textPersnouID.getText();
               String numePers = textPersnouNume.getText();
               String initTata = textInittata.getText();
               String prenumePers = textPersnouPrenume.getText();
               String univPers = textUninv.getText();
               String judPers = textJud.getText();
               boolean id = false;
               //boolean date=false;
               boolean nume = false;
               boolean prenume = false;
               boolean iTata = false;
               boolean universitate = false;
               boolean judet = false;
               boolean camp = false;

               if (!ID.isEmpty() || !numePers.isEmpty() || !prenumePers.isEmpty() || !univPers.isEmpty() || !judPers.isEmpty()) {
                   camp = true;
                   if (ID.matches("\\d+")) {    //"\\D+"
                       id = true;

                       //JOptionPane.showMessageDialog(null,"Id contine doar date numerice");
                   }
                   if (numePers.matches("^[a-zA-Z]+$")) {
                       nume = true;
                   }

                   if (prenumePers.matches("^[a-zA-Z]+$")) {
                       prenume = true;
                   }
                   if (initTata.matches("^[a-zA-Z]+$")) {
                       iTata = true;
                   }

                   if (univPers.matches("^[a-zA-Z]+$")) {
                       universitate = true;
                   }

                   if (judPers.matches("^[a-zA-Z]+$")) {
                       judet = true;
                   }
                   // for (Book bk : cartiPers) {
                   //   System.out.println("VERIFICARE 3");
                   // if (bk.getCod().equals(idCarte)) {

               } else {
                   JOptionPane.showMessageDialog(null, "Trebuie completate toate campurile");
               }

               if (id == false) {
                   JOptionPane.showMessageDialog(null, "Id nu este corect");
               }

               if (nume = false) {
                   JOptionPane.showMessageDialog(null, "Numele contine cel putin un caracter numeric");
               }
               if (prenume = false) {
                   JOptionPane.showMessageDialog(null, "Prenumele contine cel putin un caracter numeric");
               }
               if (iTata = false) {
                   JOptionPane.showMessageDialog(null, "Initiala contine cel putin un caracter numeric");
               }
               if (universitate = false) {
                   JOptionPane.showMessageDialog(null, "Campul pentru universitate" +
                           " contine cel putin un caracter numeric");
               }
               if (judet = false) {
                   JOptionPane.showMessageDialog(null, "Campul pentru judet contine " +
                           "cel putin un caracter numeric");
               }

               //for(Reader r:citReader){
               // if(!(r.getCodinreg().equals(ID))){
               // citReader.add(r);
               //  break;
               //}

               else {
                   JOptionPane.showMessageDialog(null, "Exista acest cititor ", "Atenție",
                           JOptionPane.WARNING_MESSAGE);

                   //persNouFrame.setVisible(false);
                   //frameStart.setVisible(true);
                   //REVENIRE LA PAGINA "BINE ATI VENIT LA BIBLIOTECA";
               }
               //}
               int answer = JOptionPane.showConfirmDialog(null, "Doriti sa fiti redirectionat " +
                               "pe pagina de logare?", "Titlu",
                       JOptionPane.YES_NO_OPTION);
               if (answer == 0) {
                   persNouFrame.setVisible(false);

                   //framePrincipal.setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null, "Veti fi redirectionat spre pagina de start");

                   //PersNouFrame persNou = new PersNouFrame(startFrame);
                   //persNou.showFrame();
                   // frameStart.setVisible(true);
               }

           }
       });
   }
    //}
    public void showFrame(){
        persNouFrame.setVisible(true);
    }




}
