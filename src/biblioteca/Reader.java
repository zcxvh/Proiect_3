
package biblioteca;

import java.util.ArrayList;
import java.util.*;

public class Reader {    //Clasa Cititor

    private String codInreg;    //atribute al clasei Cititor
    private String nume;
    private String prenume;
    ///private int cnt;

    public Reader(){

    }


    public Reader(String codInreg,String nume,String prenume){
    this.codInreg=codInreg;
    this.nume=nume;
    this.prenume=prenume;
    }

    private  ArrayList<Book>imprList=new ArrayList<Book>();   //Creare lista de carti pentru cititorul selectat


    public String toString()    //metoda de reprezentare sub forma textuala a unui obiect
    {
        return "Aceasta persoana are numele "+this.nume+" "+this.prenume+" si are cod "+this.codInreg;
    }

    public void setcodinreg(String codInreg) {
        this.codInreg=codInreg;
    }

    public void setNume(String nume) {
        this.nume=nume;
    }

    public void setPrenume(String prenume) {
        this.prenume=prenume;
    }


    public String getCodinreg() {
        return codInreg;
    }


    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    //public void setCnt(int cnt) {
      //this.cnt=cnt;

    //}

    //public int getCnt() {
     //return cnt;
    //}




    int i=1;

    //public void abstract imprumut(Book impr);

    public void imprumut (Book impr) {     //metoda de imprumut a cartii
        boolean imprDeja=false;

        for(Book imp:imprList) {
            if(imp.getCod().equals(impr.getCod())) {
                imprDeja=true;
                break;
            }
        }

        if(!imprDeja) {
            //while(impr.getCnt()!= impr.CNT)
            //imprList.add(impr);
            impr.setCnt(i);

            if(impr.getCnt()<=impr.MAX_IMPR)
            {
               // i++;
                //impr.setCnt(i);
                //impr.setCnt(i);
                imprList.add(impr);
                //impr.setCnt(i);
                i++;
                //impr.setCnt(i);
                System.out.println("Cartea "+impr.getTitlu()+" a fost imprumutata cu succes");
               // i++;
            }
            else{
                System.out.println("Nu mai puteti imprumuta. Ati ajuns la limita de carti");

            }

        }
        else {
            System.out.println("Cartea "+impr.getTitlu()+" a mai fost imprumutata");
        }
    }


    public void returnare (Book ret) {   //metoda de returnare a cartii

        boolean retDeja=false;
        for(Book cart:imprList) {

            if(cart.getCod().equals(ret.getCod())) {
                retDeja=true;

                break;
            }
        }
        if(retDeja) {
            //i--;
           // ret.setCnt(i);
            if(ret.getCnt()>=1){
                //ret.setCnt(i);
                imprList.remove(ret);
                System.out.println("Cartea "+ret.getTitlu()+" a fost returnata cu succes");
                i--;
                ret.setCnt(i);
                //ret.setCnt(i--);
                //System.out.println("Cartea "+ret.getTitlu()+" a fost returnata cu succes");
            }
            else{
                System.out.println("Ati returnat toate cartile");
            }
        }
        else {
            System.out.println("Cartea "+ret.getTitlu()+" a mai fost returnata");
        }

    }


    public void showCarti() {    //metoda de interogare a cartilor
        if(imprList.isEmpty()) {
            System.out.println("Nu are carti imprumutate");
        }
        else {
            System.out.println("Cartile imprumutate sunt:");
            for(Book cart:imprList) {
                System.out.println(cart.getCod()+" "+cart.getTitlu());
                System.out.println("Numarul de carti pe care le are imprumutate este "+cart.getCnt());
            }
        }
    }

    public void verificareImpr(int nrI){
        try{
        if(nrI<Book.MAX_IMPR) {

        }
        }catch (Exception e){
            System.out.println("Nu puteti imprumuta mai mult de 2 carti");
            System.out.println("Scrieti numarul de carti pe care doriti sa le imprumutati:");
        }


        }

    public void stergere() {    //stergere lista de carti imprumutate
        imprList.clear();
    }


}
