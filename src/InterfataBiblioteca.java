import biblioteca.Book;
import biblioteca.Reader;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

//import static sun.tools.jconsole.inspector.XDataViewer.dispose;


public class InterfataBiblioteca {
    //private ArrayList<Reader>Slist=new ArrayList<Reader>();
    //private ArrayList<Book>Clist=new ArrayList<Book>();

    private Singleton singleton;

    private static JFrame framePrincipal;
    private static JFrame framePersoana;
    private static JFrame frameStart;

    private static JFrame imprFrame;
    private static JFrame retFrame;

    private static JFrame  persNouFrame;

    private static JFrame interFrame;



    //private Singleton singleton;
    private static CardLayout cardLayout;
    private Singleton AfisData;


    private ArrayList<StudentReader> Slist = new ArrayList<StudentReader>();
    private ArrayList<StudentReader> listaCititor() {
        // ArrayList<Reader> Slist = new ArrayList<Reader>();  //LISTA PENTRU CITITOR    CREARE LISTA DE CITITORI
        String[] codInreg = {"123", "345", "567", "789"};
        String[] nume = {"Georgescu", "Grigorescu", "Marin", "Micu"};
        String[] initTata = {"S", "I", "M", "L"};
        String[] prenume = {"Ioana", "Maria", "Gheorghe", "Ana"};
        String[] facultate = {"UTCN", "UBB", "UVT", "UniTBv"};
        String[] judet = {"Cluj", "Cluj", "Timisoara", "Brasov"};

        for (int i = 0; i < codInreg.length; i++) {
            StudentReader student = new StudentReader();
            student.setcodinreg(codInreg[i]);
            student.setNume(nume[i]);
            student.setInitTata(initTata[i]);
            student.setPrenume(prenume[i]);
            student.setFacultate(facultate[i]);
            student.setJudF(judet[i]);
        Slist.add(student);
    }

            return Slist;
    }


    private ArrayList<Book> Clist = new ArrayList<Book>();

    public ArrayList<Book> listaCarti() {
        //ArrayList<Book> Clist = new ArrayList<Book>();   // LISTA PENTRU CARTE        CREARE LISTA DE CARTI

        String a[] = new String[100];
        String b[] = new String[100];
        String d[] = new String[100];

        {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src\\Carti.txt"));    //CITIREA DIN FISIER
                //System.out.println(new File("").getAbsolutePath());
                //FileInputStream filestream= new FileInputStream("Carti.txt");
                int i = 0;

                while (reader.ready()) {

                    Clist.add(new Book());
                    a[i] = reader.readLine();
                    b[i] = new StringBuffer(a[i].substring(0, 3)).toString();
                    b[i] = a[i].substring(0, 3);
                    Clist.get(i).setCod(b[i]);
                    d[i] = new StringBuffer(a[i].substring(4)).toString();
                    Clist.get(i).setTitlu(d[i]);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("VERIFICARE LISTA: "+Clist);
        return Clist;
    }


    public boolean validarePers(String cod) {
        //listaCititor();
        for(Reader cit:listaCititor()){
            if(cit.getCodinreg().equals(cod)){



                cititor=cit.toString();

                return true;
            }
        }
        return false;
        //return n;
    }

    //LISTA DE CARTI
    ArrayList<Book> carti = listaCarti();
    int cnt=1;
    int cntRet=1;
    public String cititor;

    private  void setupGUI(){



        //CREARE CONTAINER PENTRU A FACE SWITCH INTRE FERESTRE
       // Container cardContainer=new Container();
        //CardLayout cardLayout=new CardLayout();
        //cardContainer.setLayout(cardLayout);

        //FRAME INCEPUT

        frameStart=new JFrame("BIBLIOTECA");
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setSize(300, 150);

        //ImageIcon biblio=new ImageIcon(this.getClass().getResource("/biblioteca.png"));
        //JLabel labelImagine=new JLabel(biblio);
        //labelImagine.setSize(1,1);

        JPanel panelStart=new JPanel();
        //panelStart.setLayout(new BoxLayout(panelStart,BoxLayout.Y_AXIS));
        //panelStart.setLayout(new BoxLayout(panelStart,BoxLayout.X_AXIS));


        //labelImagine.setIcon(biblio);
        JLabel labelStart=new JLabel("BINE ATI VENIT LA BIBLIOTECA");
        labelStart.setHorizontalAlignment(SwingConstants.CENTER);

        JButton buttonStart=new JButton("START");


        //panelStart.add(labelImagine);
        panelStart.add(labelStart);
        //labelStart.setHorizontalAlignment(SwingConstants.CENTER);
        panelStart.add(buttonStart);

        frameStart.add(panelStart,BorderLayout.CENTER);


        //FEREASTRA PENTRU O NOUA PERSOANA
        persNouFrame=new JFrame("Utilizator nou");
        persNouFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //persNouFrame.setSize(300,150);

        JPanel panelPersnou=new JPanel();
        panelPersnou.setLayout(new BoxLayout(panelPersnou,BoxLayout.Y_AXIS));
        JLabel labelPersnouID=new JLabel("Introduceti ID-ul:");    //o sa mai fie un buton gen ingo pentru ai spune
                                                                    // despre ce ID- este vorba
        JTextField textPersnouID=new JTextField(15);
        //textPersnouID.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel labelPersnouNume=new JLabel("Introduceti nume:");
        JTextField textPersnouNume=new JTextField(15);

        JLabel labelInittata=new JLabel("Introduceti intiala tatalui");
        JTextField textInittata=new JTextField(15);

        JLabel labelPersnoPrenume=new JLabel("Introduceti prenume:");
        JTextField textPersnouPrenume=new JTextField(15);

        JLabel labelUniv=new JLabel("Introduceti universitatea:");
        JTextField textUninv=new JTextField(15);

        JLabel labelJud=new JLabel("Judet:");
        JTextField textJud= new JTextField(15);


        JButton buttonLogare=new JButton("Logare");

        JButton buttonInfo=new JButton("INFO");
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
        panelPersnou.add(labelJud);
        panelPersnou.add(textJud);
        panelPersnou.add(buttonLogare);
        panelPersnou.add(buttonInfo);
        persNouFrame.add(panelPersnou);
        persNouFrame.pack();



        // Frame Principal pentru validarea ID-ului de persoană
        framePrincipal = new JFrame("BIBLIOTECA - Validare Persoană");

        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(300, 150);

        JPanel panelPrincip = new JPanel();
        JLabel labelPrincip = new JLabel("Introduceti ID persoana:");
        JTextField textPers = new JTextField(15);
        JButton buttonPersoana = new JButton("Validare persoana");

        panelPrincip.add(labelPrincip);
        panelPrincip.add(textPers);
        panelPrincip.add(buttonPersoana);

        framePrincipal.add(panelPrincip);
        //framePrincipal.setVisible(true);

        // Frame pentru bibliotecă
        framePersoana = new JFrame("BIBLIO");
        framePersoana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton imprumutaButton = new JButton("Împrumută carte");
        JButton returneazaButton = new JButton("Returnează carte");
        JButton interogareButton = new JButton("Interogare cărți");
        JButton iesireButton = new JButton("Ieșire");

        JPanel panel = new JPanel();

        panel.add(imprumutaButton);
        panel.add(returneazaButton);
        panel.add(interogareButton);
        panel.add(iesireButton);

        framePersoana.add(panel);
        framePersoana.pack();

        //FRAME PENTRU IMPRUMUT

        imprFrame=new JFrame();
        imprFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nrCartilabel=new JLabel("Scrieti numarul de carti pe care le doriti sa le imprumutati:");
        JTextField nrCartitext=new JTextField(15);
        JLabel idCartelabel=new JLabel("Scrieti ID-ul cartii:");
        JTextField idCartitext=new JTextField(15);
        JButton persImprbutton = new JButton("Împrumută");
        JButton returnFramePers = new JButton("Revenire la meniu");
        JList listImpr=new JList<>();
        JTextArea textImpr=new JTextArea();

        //nrCartitext.getText();

        JPanel panelImpr = new JPanel();

        panelImpr.add(nrCartilabel);
        panelImpr.add(nrCartitext);
        panelImpr.add(idCartelabel);
        panelImpr.add(idCartitext);
        panelImpr.add(persImprbutton);
        panelImpr.add(returnFramePers);
        panelImpr.add(textImpr);

        //imprFrame.setSize(150,200);
        imprFrame.add(panelImpr);
        imprFrame.pack();


        //FRAME PENTRU RETURNARE

        retFrame=new JFrame();
        retFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nrCartilabelRet=new JLabel("Scrieti numarul de carti pe care le doriti sa le returnati:");
        JTextField nrCartitextRet=new JTextField(15);
        JLabel idCartelabelRet=new JLabel("Scrieti ID-ul cartii:");
        JTextField idCartitextRet=new JTextField(15);
        JButton retCartebutton = new JButton("Returneaza");
        JButton returnFrameReturnare = new JButton("Revenire la meniu");
        JTextArea textRet=new JTextArea();

        //nrCartitext.getText();

        JPanel panelRet = new JPanel();

        panelRet.add(nrCartilabelRet);
        panelRet.add(nrCartitextRet);
        panelRet.add(idCartelabelRet);
        panelRet.add(idCartitextRet);
        panelRet.add(retCartebutton);
        panelRet.add(returnFrameReturnare);
        panelRet.add(textRet);

        retFrame.add(panelRet);
        retFrame.pack();


        //FEREASTRA PENTRU INTEROGARE
        interFrame=new JFrame();
        interFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interFrame.setSize(400, 150);

        //JList interList=new JList();
        JPanel panelInter=new JPanel();
        //panelInter.setLayout(new BoxLayout(panelPersnou,BoxLayout.Y_AXIS));
        //JLabel labelInter=new JLabel();
        JTextArea textInter=new JTextArea();

        interFrame.add(panelInter);
        //interFrame.add(labelInter);
        interFrame.add(textInter);


            frameStart.setVisible(true);
            frameStart.setLocationRelativeTo(null);  //asta face sa il puna pe mijlocul ecranului

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int answer=JOptionPane.showConfirmDialog(null,"Sunteti utilizator nou?","Titlu",
                        JOptionPane.YES_NO_OPTION);
                if(answer==0){  //daca raspunsul este "DA"
                    frameStart.setVisible(false);

                    //dispose(frameStart);

                    persNouFrame.setVisible(true);
                }
                else{
                    frameStart.setVisible(false);
                    framePrincipal.setVisible(true);
                }
            }
        });

        ArrayList<StudentReader> citReader=listaCititor();

        buttonLogare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID=textPersnouID.getText();
                String numePers=textPersnouNume.getText();
                String initTata=textInittata.getText();
                String prenumePers=textPersnouPrenume.getText();
                String univPers=textUninv.getText();
                String judPers=textJud.getText();
                boolean camp=!ID.isEmpty()||!numePers.isEmpty()||!prenumePers.isEmpty()||!univPers.isEmpty()||!judPers.isEmpty();
                boolean id = ID.matches("\\d+");
                boolean nume = numePers.matches("^[a-zA-Z]+$");
                boolean prenume = prenumePers.matches("^[a-zA-Z]+$");
                boolean iTata = initTata.matches("^[a-zA-Z]+$");
                boolean universitate = univPers.matches("^[a-zA-Z]+$");
                boolean judet = judPers.matches("^[a-zA-Z]+$");

                if (!camp) {
                    JOptionPane.showMessageDialog(null, "Trebuie completate toate campurile");
                }

                if (!id) {
                    JOptionPane.showMessageDialog(null, "Id nu este corect");
                }

                if (!nume) {
                    JOptionPane.showMessageDialog(null, "Numele contine cel putin un caracter numeric");
                }
                if (!prenume) {
                    JOptionPane.showMessageDialog(null, "Prenumele contine cel putin un caracter numeric");
                }
               // if (!iTata) {
                 //   JOptionPane.showMessageDialog(null, "Initiala contine cel putin un caracter numeric");
                //}
                if (!universitate) {
                    JOptionPane.showMessageDialog(null, "Campul pentru universitate contine cel putin un caracter numeric");
                }
                if (!judet) {
                    JOptionPane.showMessageDialog(null, "Campul pentru judet contine cel putin un caracter numeric");
                }
                //boolean id=false;
                //boolean date=false;
                //boolean nume=false;
                //boolean prenume=false;
                //boolean iTata=false;
                //boolean universitate=false;
                //boolean judet=false;
                //boolean camp=false;


                for(StudentReader r:citReader){
                    if(!(r.getCodinreg().equals(ID))){
                        if(camp && initTata.isEmpty()){
                            System.out.println("VERIFICARE 1");
                            r=new StudentReader(ID,numePers,prenumePers,univPers,judPers);
                            citReader.add(r);
                            //citReader.add(r);
                            System.out.println("Cititor nou:"+r);
                            System.out.println(citReader);
                        }
                        else{
                            System.out.println("VERIFICARE 2");
                            r=new StudentReader(ID,numePers,initTata,prenumePers,univPers,judPers);
                            //citReader.add(r);
                            System.out.println("Cititor nou:"+r);
                            citReader.add(r);

                            System.out.println(citReader);
                        }

                        break;
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Exista acest cititor ", "Atenție",
                                JOptionPane.WARNING_MESSAGE);

                        //persNouFrame.setVisible(false);
                        //frameStart.setVisible(true);
                        //REVENIRE LA PAGINA "BINE ATI VENIT LA BIBLIOTECA";
                    }
                }
                int answer=JOptionPane.showConfirmDialog(null,"Doriti sa fiti redirectionat " +
                                "pe pagina de logare?","Titlu",
                        JOptionPane.YES_NO_OPTION);
                if(answer==0){
                    persNouFrame.setVisible(false);
                    framePrincipal.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Veti fi redirectionat spre pagina de start");
                    persNouFrame.setVisible(false);
                    textPersnouID.setText("");
                    textPersnouNume.setText("");
                    textInittata.setText("");
                    textPersnouPrenume.setText("");
                    textUninv.setText("");
                    textJud.setText("");

                    frameStart.setVisible(true);
                }

            }
        });

        //framePrincipal.setVisible(true);
        framePrincipal.add(panelPrincip);
        buttonPersoana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod=textPers.getText();
                boolean valid=validarePers(cod);
                ///framePrincipal.setVisible(true);
                //framePrincipal.add(panelPrincip);
                if(valid){
                    JOptionPane.showMessageDialog(null, "ID-ul " + cod + " este corect");
                    framePrincipal.setVisible(false);
                    framePersoana.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "ID-ul " + cod + " este incorect");
                }
                //JOptionPane.showMessageDialog(null,"Ai apăsat butonul. Textul introdus este: ");
            }
        });
        //framePrincipal.setVisible(true);
        //framePrincipal.add(panelPrincip);
        //framePrincipal.setVisible(true);

        ArrayList<Book> cartiPers=new ArrayList<Book>();

        imprumutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePersoana.setVisible(false);
                imprFrame.setVisible(true);
            }
        });

        /*

        returneazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
         */

        singleton = Singleton.getInstance();
        persImprbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                singleton.dataCurenta();
                try (FileWriter writer = new FileWriter("Afisare data", true)) {
                    writer.write(singleton.getUltimaAcesare() + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }



        //singleton=Singleton.getInstance();
        //Singleton singleton=Singleton.getInstance();
        //singleton.dataCurenta();
        persImprbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Singleton singleton


                    int nrCartiimpr;
                    String idCarte=idCartitext.getText();
                    //String nrCarte=nrCartitext.getText();

                    String nrCarti=nrCartitext.getText();
                    boolean asteapta=false;
                    System.out.println("Nr carti "+nrCarti);


                    if(!nrCarti.isEmpty())
                    {
                        System.out.println("CONTOR:"+cnt);
                        boolean valid=false;
                        boolean gasit=false;
                        //try{
                        //System.out.println("CONTOR:"+cnt);
                        if(cnt<=Book.MAX_IMPR){
                            nrCartiimpr=Integer.parseInt(nrCarti);
                            //System.out.println("VERIFICARE 1");
                            //try{
                                System.out.println("INTRA IN TRY");
                                if(nrCartiimpr>Book.MAX_IMPR){
                                    JOptionPane.showMessageDialog(null, "Ati introdus mai multe "
                                            + "carti decat limita");
                                        nrCartitext.setText("");
                                }
                                else{
                                    System.out.println("MERGE");
                                  //  System.out.println("VERIFICARE 2");
                                    //System.out.println("CARTI: "+Clist);

                                    for(Book bk:carti){
                                        System.out.println("VERIFICARE 3");
                                        if (bk.getCod().equals(idCarte)) {

                                            valid=true;
                                            System.out.println("VERIFICARE 4");
                                            System.out.println("Cartea gasita este: "+bk);
                                            if(!cartiPers.contains(bk)){
                                                cnt++;
                                                gasit=true;
                                        //        System.out.println("Carti "+bk+"\n");
                                                cartiPers.add(bk);

                                                System.out.println("Cartile imprumutate: "+cartiPers);
                                                textImpr.append(bk.toString());
                                                //listImpr.add(bk.toString(),listImpr);
                                                JOptionPane.showMessageDialog(null,"Cartea a " +
                                                        "fost imprumutata cu succes");
                                                    idCartitext.setText("");
                                                    idCarte=idCartitext.getText();

                                                    //SINGLETON  -l-am pus aici pentru a limita scrierea in fisier

                                                singleton.dataCurenta();
                                                try (FileWriter writer = new FileWriter("Afisare data", true)) {
                                                    writer.write(cititor+"\n");
                                                    writer.write(bk+"\n");
                                                    writer.write(singleton.getUltimaAccesare() + "\n");
                                                } catch (IOException ex) {
                                                    ex.printStackTrace();
                                                    System.out.println("Eroare la scrierea in fisier");
                                                }

                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Nu puteti " +
                                                                "introduce acceasi carte.", "Atenție",
                                                        JOptionPane.WARNING_MESSAGE);
                                                idCartitext.setText("");
                                                idCarte=idCartitext.getText();
                                            }

                                        }

                                    }
                                    //AICI

                                    if(valid==false){
                                        JOptionPane.showMessageDialog(null, "Cod carte invalid."
                                                        +"Reintroduceti cod", "Atenție",
                                                JOptionPane.WARNING_MESSAGE);
                                        idCartitext.setText("");
                                        idCarte=idCartitext.getText();
                                    }
                                }

                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ati ajuns la limita de carti " +
                                    "pe care le puteti imprumuta");
                        }

                    }
            }


        });


        returneazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePersoana.setVisible(false);
                retFrame.setVisible(true);
            }
        });

        retCartebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePersoana.setVisible(false);
                retFrame.setVisible(true);


                int nrCartiret;
                String idCarte=idCartitextRet.getText();
                //String nrCarte=nrCartitext.getText();

                String nrCarti=nrCartitextRet.getText();
                boolean asteapta=false;
                System.out.println("Nr carti "+nrCarti);

                if(cartiPers.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nu aveti carti imprumutate","Averizare"
                            ,JOptionPane.WARNING_MESSAGE);

                    JOptionPane.showMessageDialog(null, "Veti fi redirectionat pe pagina " +
                                    "anterioara","Important"
                            ,JOptionPane.WARNING_MESSAGE);
                    retFrame.setVisible(false);
                    framePersoana.setVisible(true);


                }
                else {

                    if (!nrCarti.isEmpty()) {
                        System.out.println("CONTOR:" + cntRet);
                        boolean valid = false;
                        boolean gasit = false;
                        //try{
                        //System.out.println("CONTOR:"+cnt);
                        if (cntRet <= Book.MAX_IMPR) {
                            nrCartiret = Integer.parseInt(nrCarti);
                            System.out.println("VERIFICARE 1");
                            //try{
                            System.out.println("INTRA IN TRY");
                            if (nrCartiret > Book.MAX_IMPR) {
                                JOptionPane.showMessageDialog(null, "Ati introdus mai multe "
                                        + "carti decat puteti returna");
                                nrCartitextRet.setText("");
                            } else {
                                System.out.println("MERGE");
                                //  System.out.println("VERIFICARE 2");
                                //System.out.println("CARTI: "+Clist);

                                for (Book bk : cartiPers) {
                                    System.out.println("VERIFICARE 3");
                                    if (bk.getCod().equals(idCarte)) {

                                        valid = true;
                                        System.out.println("VERIFICARE 4");
                                        System.out.println("Cartea gasita este: " + bk);
                                        if (cartiPers.contains(bk)) {
                                            cntRet++;
                                            gasit = true;
                                            //        System.out.println("Carti "+bk+"\n");
                                            cartiPers.remove(bk);

                                            System.out.println("Carti returnate: " + cartiPers);
                                            textRet.append(bk.toString());
                                            //listImpr.add(bk.toString(),listImpr);
                                            JOptionPane.showMessageDialog(null, "Cartea a " +
                                                    "fost returnata cu succes");
                                            idCartitextRet.setText("");
                                            idCarte = idCartitextRet.getText();

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Nu puteti " +
                                                            "introduce acceasi carte.", "Atenție",
                                                    JOptionPane.WARNING_MESSAGE);
                                            idCartitextRet.setText("");
                                            idCarte = idCartitextRet.getText();
                                        }

                                    }

                                }
                                //AICI

                                if (valid == false) {
                                    JOptionPane.showMessageDialog(null, "Cod carte invalid."
                                                    + "Reintroduceti cod", "Atenție",
                                            JOptionPane.WARNING_MESSAGE);
                                    idCartitextRet.setText("");
                                    idCarte = idCartitextRet.getText();
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Ati ajuns la limita de carti " +
                                    "pe care le puteti returna","Aertizare",JOptionPane.WARNING_MESSAGE);
                        }

                    }
                }
            }


        });

        returnFramePers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePersoana.setVisible(true);
                imprFrame.setVisible(false);
            }
        });

        returnFrameReturnare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePersoana.setVisible(true);
                retFrame.setVisible(false);
            }
        });

        interogareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                framePersoana.setVisible(false);
                interFrame.setVisible(true);
                //StringBuffer s=new StringBuffer("");

                for(Book bk : cartiPers){
                    System.out.println(bk);
                    //s.append("\n");
                    StringBuilder s=new StringBuilder();  // Creeaza un nou sir pentru fiecare carte
                    s.append(bk.toString());   //adauga reprezentarea sub forma de sir de caractere a obiectului bk
                    textInter.append(s.toString());
                    textInter.append(System.lineSeparator());
                }
            }
        });

    }

    public static void main(String[] args){

        InterfataBiblioteca biblioteca=new InterfataBiblioteca();
        biblioteca.setupGUI();
    }


}




