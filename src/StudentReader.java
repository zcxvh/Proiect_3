import biblioteca.Reader;

public class StudentReader extends Reader {
    private String initTata;
    private String facultate;
    private String judetF;

    StudentReader(){

    }

    StudentReader(String codInreg,String nume,
                  String prenume,String facultate,String judetF){
        super(codInreg,nume,prenume);
        this.facultate=facultate;
        this.judetF=judetF;

    }
    StudentReader (String codInreg,String nume,
                              String prenume,String initTata,String facultate,String judetF){

        super(codInreg,nume,prenume);
        this.initTata=initTata;
        this.facultate=facultate;
        this.judetF=judetF;

    }


    public String getFacultate(){
        return facultate;
    }
    public void setFacultate(String facultate){
        this.facultate=facultate;
    }

    public String getJudF(){
        return judetF;
    }
    public void setJudF(String judetF){
        this.judetF=judetF;
    }

    public String getInitTata() {
        return initTata;
    }
    public void setInitTata(String initTata){
        this.initTata=initTata;
    }

    @Override
    public String getNume() {
        return super.getNume(); // Păstrează funcționalitatea din clasa de bază
    }

    @Override
    public void setNume(String nume) {
        super.setNume(nume); // Păstrează funcționalitatea din clasa de bază
    }

    @Override
    public String getPrenume() {
        return super.getPrenume(); // Păstrează funcționalitatea din clasa de bază
    }

    @Override
    public void setPrenume(String prenume) {
        super.setPrenume(prenume); // Păstrează funcționalitatea din clasa de bază
    }

    @Override
    public String toString(){
        return "Studentul " + getNume() + " "+getInitTata()+". " + getPrenume() + " are codul " + getCodinreg() +
                " și este la " + getFacultate()+ " in judetul "+getJudF();
    }
}

