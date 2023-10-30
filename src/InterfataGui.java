import biblioteca.Book;
import biblioteca.Reader;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;

public class InterfataGui extends JFrame {
    private JPanel panelMain;
    private JTextField textField1;
    private JList list1;
    private JButton btnValid;
    private JLabel labelID;
    private JTextArea textArea1;
    private JButton btnRetragere;
    private JButton btnAdaugare;
    private JTextField textField2;
    private JLabel labelImprRet;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton btnInterogare;
    private JTextField textField3;
    private JLabel LabelNrcartiImpr;
    private JTextField textField4;
    private JLabel LabelNrcartiRet;
    private JTextArea textArea4;
    private JOptionPane OptionPane;


    JFrame frame = new JFrame();

    public ArrayList<Reader> listaCititor() {
        ArrayList<Reader> Slist = new ArrayList<Reader>();  //LISTA PENTRU CITITOR    CREARE LISTA DE CITITORI
        Slist.add(new Reader());
        Slist.get(0).setcodinreg("123");
        Slist.get(0).setNume("Baciu");
        Slist.get(0).setPrenume("Bogdan");

        Slist.add(new Reader());
        Slist.get(1).setcodinreg("345");
        Slist.get(1).setNume("Grigorescu");
        Slist.get(1).setPrenume("Maria");


        Slist.add(new Reader());
        Slist.get(2).setcodinreg("567");
        Slist.get(2).setNume("Moldovan");
        Slist.get(2).setPrenume("Ioana");

        return Slist;
    }


    public ArrayList<Book> listaCarti() {
        ArrayList<Book> Clist = new ArrayList<Book>();   // LISTA PENTRU CARTE        CREARE LISTA DE CARTI

        String a[] = new String[100];
        String b[] = new String[100];
        String d[] = new String[100];

        {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Carti.txt"));    //CITIREA DIN FISIER
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
        return Clist;
    }


    public void afisCarti() {
        DefaultListModel<Book> listModel = new DefaultListModel<>();

        for (Book b : listaCarti()) {
            listModel.addElement(b);
        }
        list1.setModel(listModel);
    }




    /*

     */

    public void curatareField(){
        textField2.setText(null);
    }
    public boolean validarePers(String cod) {
        //listaCititor();
        for(Reader cit:listaCititor()){
            if(cit.getCodinreg().equals(cod)){
                JOptionPane.showMessageDialog(btnValid, "ID-ul " + textField1.getText() + " este corect");
                return true;
            }
        }
        JOptionPane.showMessageDialog(btnValid, "ID-ul " + textField1.getText() + " este incorect");
        return false;
        //return n;
    }

    // ArrayList<Reader> cititori = listaCititor();
    ArrayList<Book> cartiImprumutate = new ArrayList<>();
    ArrayList<Reader> cititori = listaCititor();
    ArrayList<Book> carti = listaCarti();
    //JFrame frame2=new JFrame();
    int cnt = 1;



    public ArrayList imprCarte() {
        //VALIDARE PERSOANA
        //ArrayList<Reader>cititori=listaCititor();

        if (!validarePers(textField1.getText())) {
            JOptionPane.showMessageDialog(frame, "Cititor inexistent");
            //JOptionPane.showMessageDialog(btnValid, "Cititor inexistent");
            return cartiImprumutate;
        }

        int nrCartiimpr=Integer.parseInt(textField3.getText());
        if (nrCartiimpr > 2) {
            JOptionPane.showMessageDialog(frame, "Ati introdus mai mult decat limita de carti", "Atenție",
                    JOptionPane.WARNING_MESSAGE);
            return cartiImprumutate;  //returneaza o lista goala
            //JOptionPane.showMessageDialog(btnAdaugare,"Ati introdus mai mult decat limita de carti");
        }
        boolean gasit = false;
        String cod = textField2.getText();
        boolean carteImprumutata = false; //variabila pentru a tine minte
        //daca cartea a mai fost imprumutata sau nu

        //PROCES DE PARCURGERE A LISTEI DE CARTI
        if (cnt <= nrCartiimpr) {
            //for(int i=0;i<nrCartiimpr;i++){
            while (!gasit) {
                if (!(cod.isEmpty())) {
                    boolean carteGasita = false;
                    for (Book carte : carti) {
                        if (carte.getCod().equals(cod)) {
                            //cartiImprumutate.add(carte);
                            if (!cartiImprumutate.contains(carte)) {
                                //System.out.println(cartiImprumutate.contains(carte));
                                //if( cnt<= carte.MAX_IMPR){
                                cartiImprumutate.add(carte);
                                carteGasita = true;
                                //System.out.println("Contorul este " + cnt);
                                //System.out.println("For:"+i);
                                cnt++;
                                //System.out.println(cartiImprumutate);
                                //System.out.println(cartiImprumutate.size());
                                textArea2.append(carte.toString() + "\n");
                                gasit = true;

                                break;
                            } else {
                                carteImprumutata = true;
                                //f(!carteImprumutata){
                                JOptionPane.showMessageDialog(frame, "Nu puteți împrumuta aceeași carte",
                                        "Avertisment", JOptionPane.WARNING_MESSAGE);
                                //carteImprumutata=true;
                                //}
                            }

                        }
                    }
                    //if (!carteGasita) {
                      //  JOptionPane.showMessageDialog(frame, "Codul introdus nu corespunde nici o carte din " +
                        //        "listă.", "Avertisment", JOptionPane.WARNING_MESSAGE);
                    //}
                }
                //cod=textField2.getText();   //locul unde are loc scrierea codului cartii

                if (!gasit) {
                    JOptionPane.showMessageDialog(frame, "Codul introdus nu este valid. Introduceți alt cod.",
                            "Eroare", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        curatareField();
        return cartiImprumutate;
    }


    public void afisCart() {
        System.out.println("CARTI DISPONIBILE:");
        for (Book cart : listaCarti()) {
            //System.out.println(cart);
            //System.out.println("CARTI DISPONIBILE:");
            System.out.println(cart.getCod() + " " + cart.getTitlu());
        }
    }

    public void afisImprumut() {
        //ArrayList<Reader> cititori = listaCititor();
        //ArrayList<Book>carti=imprCarte();
        //for(Book b:carti){
        //  textArea2.append(b.toString());
        //}
    }

    ArrayList<Book> ListBook = imprCarte();


    public ArrayList<Book> retCarte() {
        //ArrayList<Reader> cititori = listaCititor();
        if (!validarePers(textField1.getText())) {
            JOptionPane.showMessageDialog(btnRetragere, "Cititor inexistent");
            //return;
        }
        //RETURNARE
        int carteRet = Integer.parseInt(textField4.getText());

        //ArrayList<String> coduriAdaugate = new ArrayList<>();
        int nrCartiret = Integer.parseInt(textField4.getText());

        if (nrCartiret > 2) {
            //URMEAZA//JOptionPane.showMessageDialog();
            return ListBook;
        }

        boolean gasit = false;
        String codRet = textField2.getText();
        boolean cartiReturnate = false;
        int cnt = 1;
        //textField3.remove(textField3);

        //PROCES DE PARCURGERE A LISTEI DE CARTI PENTRU RETURNARE
        if (cnt <= nrCartiret) {
            System.out.println(ListBook);
            while (!gasit) {
                if (!codRet.isEmpty()) {
                    boolean carteGasita = false;
                    for (Book bk : ListBook) {   //Procesul de parcurgere a listei de carti
                        if (bk.getCod().equals(codRet)) {
                            if (ListBook.contains(bk)) {
                                ListBook.remove(bk);
                                System.out.println("Dupa remove:"+ListBook);
                                carteGasita = true;
                                cnt++;
                                textArea3.append(bk.toString() + "\n");
                                gasit = true;
                                break;
                            }
                        } else {
                            cartiReturnate = true;
                            //JOption
                        }
                    }
                    if (!carteGasita) {
                        //JOptionPane
                    }
                }
                if (!gasit) {
                    //JOptionPane
                    break;
                }
            }
        }
        return ListBook;
    }

    public void interogareCarte() {
        for(Book bk:ListBook){
            System.out.println("LISTA CARTI: "+bk);
            textArea4.append(bk.toString() + "\n");
        }
    }

    public InterfataGui() {
        //list1 = new JList<Book>();   //initializare lista
        JScrollPane scrollPane = new JScrollPane(list1);
        labelID.setText("Introduceti ID:");
        btnValid.setText("Validare ID");

        btnValid.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { //metoda pentru a gestiona evenimente
                //este apelata pentru a trata acel eveniment
                String cod;
                cod = textField1.getText();
                if (!(cod.isEmpty())) {
                    validarePers(cod);
                }
                //textArea1.insert("bla bla bla", 0);
                //textArea1.insert("192 Anatomia omului ", 0);
                //textArea1.insert("283 Desen tehnic",1);
                //textArea1.insert("384 Mecanisme",2);
                //textArea1.insert("475 Organe de masini",3);
                //adaugareLista();
            }
            //textArea1.insert("bla bla bla", 0);

        });
        //afisCarti();
        textArea1.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
                //textArea1=new JTextArea();

            }
        });
        textArea1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                StringBuilder textToAdd=new StringBuilder();
                textToAdd.append("CARTI:\n");
                textToAdd.append("192 Anatomia omulu\n ");
                textToAdd.append("283 Desen tehnic\n ");
                textToAdd.append("384 Mecanisme\n ");
                textToAdd.append("475 Organe de masini \n");
                textArea1.setText(textToAdd.toString());
                //super.componentResized(e);

            }
        });

        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    imprCarte();
            }
        });
        btnRetragere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retCarte();
            }
        });
        btnInterogare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interogareCarte();
                //retCarte();
            }
        });
    }

    public static void main(String[] args) {
        InterfataGui h = new InterfataGui();  //s-a creat obiectul h ce apartine clasei InterfaceGui
        h.setContentPane(h.panelMain);
        h.setTitle("Biblioteca");
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h.setLocationRelativeTo(null);  //centrare pe mijlocul ecranului
        //h.setBounds(600,200,200,200);
        h.setSize(800, 600);
        h.setResizable(true);
        h.setVisible(true);
        //afisare();
    }
}


//IMPRUMUTUL
//String TextCartiimpr=textField3.getText();
//if(!TextCartiimpr.isEmpty()){
//  int nrCartiimpr = Integer.parseInt(TextCartiimpr); // Convertire la număr
//}

/*

 */
//String TextCartiimpr=textField3.getText();


//String cod=textField2.getText();   //scrierea codului cartii
//int cnt=1;

        /*if(cnt<=nrCartiimpr){
            for(Book carte:listaCarti){
                if(carte.getCod().equals(cod)){
                    if(!cartiImprumutate.contains(carte)){
                        cnt++;
                        carteaExista1=true;
                        cartiImprumutate.add(carte);
                    }
                }
                break;
            }
        }
        if(cnt<=nrCartiimpr){
            textField2.remove(textField2);
            cod=textField2.getText();
            for(Book carte:listaCarti){
                if(carte.getCod().equals(cod)){
                    if(!cartiImprumutate.contains(carte)){
                        cnt++;
                        carteaExista2=true;
                        cartiImprumutate.add(carte);
                    }
                }
                break;
            }
        }*/


//int nrCartiimpr = Integer.parseInt(textField3.getText());  //nr de carti ce se dorsc imprumutate
//transformat in Integer pentru ca textField ia doar String
