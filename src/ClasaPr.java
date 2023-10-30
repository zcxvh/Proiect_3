import biblioteca.Reader;
import biblioteca.Book;

import java.io.BufferedReader;
import java.util .*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ClasaPr {
    public static void main(String[] args) {
        ArrayList<Reader>Slist=new ArrayList<Reader>();  //LISTA PENTRU CITITOR    CREARE LISTA DE CITITORI
        ArrayList<Book>Clist=new ArrayList<Book>();   // LISTA PENTRU CARTE        CREARE LISTA DE CARTI

        String a[]=new String[100];
        String b[]=new String[100];
        String d[]=new String[100];

        {
            try {
                BufferedReader reader=new BufferedReader(new FileReader("Carti.txt"));    //CITIREA DIN FISIER

                //AFISAREA LINIILOR CITITE
                //System.out.println(reader.readLine());

                int i=0;


                //Citirea liniilor din fiser si crearea obiectelor Carte
                while(reader.ready()) {
                    //StringBuffer sb=new StringBuffer();
                    //sb.append(new Reader());
                    //a[i]=reader.readLine();
                    //b[i]=a[i].substring(0,3);
                    //sb.append(i).
                    /*
                    Clist.add(new Book());
                    a[i]=reader.readLine();
                    b[i]=a[i].substring(0, 3);
                    Clist.get(i).setCod(b[i]);
                    d[i]=a[i].substring(4,a[i].length());
                    Clist.get(i).setTitlu(d[i]);

                    i++;
                     */
                   //clasă care reprezintă un șir de caractere modificabil
                    // este o structură de date folosită pentru manipularea și construirea
                    // de șiruri de caractere

                    Clist.add(new Book());
                    a[i]=reader.readLine();
                    b[i]=new StringBuffer(a[i].substring(0,3)).toString();  //creare nou obiect de tip String Buffer si
                                                                            // ii atribuie o sectiune de caractere
                    //b[i]=a[i].substring(0, 3);
                    Clist.get(i).setCod(b[i]);
                    d[i]=new StringBuffer(a[i].substring(4)).toString();
                    //d[i]=a[i].substring(4,a[i].length());
                    Clist.get(i).setTitlu(d[i]);
                    i++;


                }

            }catch(IOException e) {
                e.printStackTrace();
            }
        }

        /*


        String codInreg;
        private static Reader getPersoanacodInreg(codInreg) {
            for(Reader r: Slist){
                if(r.getCodinreg().equals(codInreg)){    cart.getCod().equals(id))
                    return r;
                }
            }
            //return null;
        } */


        String cd;
        String num;
        String pr;
        Scanner sc=new Scanner(System.in);
        System.out.println("Scrieti codul cititorului:");
        cd=sc.next();
        System.out.println("Scrieti numele cititorului:");
        num=sc.next();
        System.out.println("Scrieti prenumele cititorului:");
        pr=sc.next();
        //Adaugarea cititorilor in lista Slist

        //StringBuffer sb=new StringBuffer();
        //sb.append(new Reader());
        //sb.substring()

        String[] codInreg={"123","345","567","789"};
        String [] nume={"Georgescu","Grigorescu","Marin","Micu"};
        String[] initTata={"S","I","M","L"};
        String[] prenume={"Ioana","Maria","Gheorghe","Ana"};
        String[] facultate={"UTCN","UBB","UVT","UniTBv"};
        String[] judet={"Cluj","Cluj","Timisoara","Brasov"};

        for(int i=0;i< codInreg.length;i++){
            StudentReader student=new StudentReader();
            student.setcodinreg(codInreg[i]);
            student.setNume(nume[i]);
            student.setInitTata(initTata[i]);
            student.setPrenume(prenume[i]);
            student.setFacultate(facultate[i]);
            student.setJudF(judet[i]);

            Slist.add(student);
        }


        //Slist.add(new Reader());
        ///Slist.add(new StudentReader());
        //Slist.get(0).setcodinreg(cd);
        //Slist.get(0).setNume(num);
        //Slist.get(0).setPrenume(pr);

        /*
        Slist.add(new Reader());
        Slist.get(1).setcodinreg("345");
        Slist.get(1).setNume("Grigorescu");
        Slist.get(1).setPrenume("Maria");


        Slist.add(new Reader());
        Slist.get(2).setcodinreg("567");
        Slist.get(2).setNume("Moldovan");
        Slist.get(2).setPrenume("Ioana");

        Slist.add(new Reader("789","Molnar","Iulia"));
        Slist.get(3).setcodinreg("567");
        Slist.get(3).setNume("Moldovan");
        Slist.get(3).setPrenume("Ioana");
         */



        //AFISARE CITITORI
        System.out.println("CITITORI:");
        for(Reader str:Slist) {
            System.out.println(str.toString());
        }

        //AFISARE CARTI
        System.out.println("CARTI:");
        for(Book cart:Clist) {
            System.out.println(cart.toString());
            //System.out.println(cart.getCod()+" "+cart.getTitlu());
        }


        //Scanner sc=new Scanner(System.in);
        int nr=0;
        String id;
        int cnt1;
        int cnt2;
        int opt=0;
        int nrI;


		/*
			//PARCURGERE LISTA DE CARTI+AFISARE
			System.out.println("CARTI DISPONIBILE:");
			for(Carte cart:Clist) {
				//System.out.println(cart);
				//System.out.println("CARTI DISPONIBILE:");
				System.out.println(cart.getCod()+" "+cart.getTitlu());
			}*/

        System.out.println("Introduceti ID-ul cititorului:");
        String cod;
        cod=sc.next();
        for(Reader cit:Slist) {   //Procesul de parcurgere a listei de cititori
            if(cit.getCodinreg().equals(cod)) {
                System.out.println("S-a gasit codul corespunzator studentului");
                //AFISARE CITITOR
                System.out.println(cit.getCodinreg()+" "+cit.getNume()+" "+cit.getPrenume());

                while(true) {
                    System.out.println("OPTIUNI:");
                    System.out.println("1.Imprumutati o carte");
                    System.out.println("2.Returnati o carte");
                    System.out.println("3.Interogare carti");
                    System.out.println("4.Reintroducere alta persona+revenire la meniul principal");
                    System.out.println("5.Sfarsit program");

                    System.out.println("Scrieti obtiunea: ");
                    opt=sc.nextInt();

                    if(opt==1) {
                        System.out.println("Ati selectat obtiunea de imprumut");
                        System.out.println("Scrieti nr de carti pe care doriti sa le imprumutati");
                        nrI = sc.nextInt();
                        try {
                            if (nrI > Book.MAX_IMPR) {
                                throw new PreaMulteCartiException("Ati dorit sa imprumutati mai mult decat limita de "
                                        +Book.MAX_IMPR+" carti");
                                //"Carti curente 1. Carti max 2"
                                //System.out.println("Nu puteti imprumuta mai mult de 2 carti");
                                //am nevoie de o exceptie
                                //break;
                            }
                        }catch(Exception PreaMulteCartiException){
                            System.out.println("!!!!Nu puteti imprumuta mai mult de 2 carti");
                            System.out.println("Scrieti numarul de carti pe care doriti sa le imprumutati:");
                            nrI=sc.nextInt();
                        }
                        cnt1=0;
                        while(cnt1<=nrI){
                            cnt1=cnt1+1;
                            System.out.println("Scrieti ID-ul cartii: ");
                            id=sc.next();
                            System.out.println(id);
                            for(Book cart:Clist) {
                                if(cart.getCod().equals(id)) {
                                    System.out.println("S-a gasit Id-ul corespunzator cartii");
                                    cit.imprumut(cart);
                                }
                            }
                            cnt1=cnt1+1;
                        }
                    }

                    else if (opt==2) {
                        System.out.println("Ati selectat obtiunea de returnare a cartii");
                        System.out.println("Cate carti doriti sa returnati:");
                        int nrR=sc.nextInt();
                        try {
                            if (nrR > Book.MAX_IMPR) {
                                throw new PreaMulteCartiException("Ati dorit sa returnati mai multe carti decat aveti " +
                                        "imprumutate ");

                                //"Carti curente 1. Carti max 2"
                                //System.out.println("Nu puteti imprumuta mai mult de 2 carti");
                                //am nevoie de o exceptie
                                //break;
                            }
                        }catch(Exception PreaMulteCartiException){
                            System.out.println("!!!!Nu puteti returna mai mult de 2 carti");
                            System.out.println("Scrieti numarul de carti pe care doriti sa le returnati:");
                            nrR=sc.nextInt();
                        }

                        cnt2=0;
                        while(cnt2<=nrR) {
                            cnt2=cnt2+1;
                            System.out.println("Scrieti ID-ul cartii: ");

                            id=sc.next();
                            System.out.println(id);
                            for(Book cart:Clist) {
                                if(cart.getCod().equals(id)) {
                                    System.out.println("S-a gasit Id-ul corespunzator cartii");
                                    cit.returnare(cart);
                                }
                            }
                            cnt2=cnt2+1;
                        }
                    }

                    else if(opt==3) {
                        for(Reader citi:Slist) {

                            if(citi.getCodinreg().equals(cod)) {
                                //cit.setcodinreg(cod);
                                System.out.println("Ati selectat obtiunea de interogare a cartilor:");
                                System.out.println("Studentul "+citi.getNume()+"  "+citi.getPrenume()+" "+
                                        "cu ID-ul "+citi.getCodinreg()+" are imprumutate urmatoarele carti:");
                                cit.showCarti();
                            }
                        }
                    }
                    else if(opt==4) {
                        cit.stergere();
                        System.out.println("Introduceti ID-ul  cititorului:");
                        cod=sc.next();
                        for(Reader ci:Slist) {
                            if(ci.getCodinreg().equals(cod)) {
                                System.out.println("S-a gasit codul corespunzator studentului");
                                //AFISARE CITITOR
                                System.out.println(ci.getCodinreg()+ci.getNume()+ci.getPrenume());
                            }
                        }
                    }

                    else if(opt==5) {
                        break;
                    }
                }
            }

        }
    }
}


