package ba.unsa.etf.rpr;

public class Ucenik extends Osoba implements Comparable{
    private int[] ocjene = new int[100];
    private String brojKnjizice = "";

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }

    public int[] getOcjene() {
        return ocjene;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private int vel = 0;

    public Ucenik(String imePrezime){
        super(imePrezime);
    }
    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena{
        if(ocjena < 1 || ocjena > 5) throw new IlegalnaOcjena("Ilegalna ocjena " + ocjena);
        if(vel >= ocjene.length) throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        ocjene[vel++] = ocjena;
    }

    public double prosjek(){
        int suma = 0;
        for(int i = 0; i < vel; i++) suma += ocjene[i];
        return (double) Math.round(((double) suma / vel) * 100) / 100;
    }
    public int dajVel(){
        return vel;
    }

    @Override
    public int compareTo(Object o) {
        Ucenik u = (Ucenik) o;
        if(this.prosjek() > u.prosjek())return -1;
        else if(this.prosjek() < u.prosjek()) return 1;
        else return 0;
    }
}
