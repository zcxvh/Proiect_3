package biblioteca;

import java.util.*;


public class Book {
    public static final int MAX_IMPR=2;
    private String cod;
    private String titlu;
    private int cnt;


    public void setCod(String cod) {
        this.cod=cod;
    }

    public void setTitlu(String titlu) {
        this.titlu=titlu;
    }


    public void setCnt(int cnt) {
        this.cnt=cnt;

    }


    public String getCod() {
        return cod;
    }

    public String getTitlu() {
        return titlu;
    }


    public int getCnt() {
        return cnt;
    }



    public String toString()
    {
        return "Cartea are ID "+this.cod+" "+" si are denumirea "+this.titlu;
    }


}

