package ba.unsa.etf.rpr;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Srednjoskolac extends Ucenik implements Slavljenik{
    private int ocjeneSrednja[] = new int[100];
    private int velSrednja;

    public Srednjoskolac(String imePrezime){
        super(imePrezime);
    }

    public void dodajOcjenuSrednja(int ocjena) throws IlegalnaOcjena{
        if(ocjena < 1 || ocjena > 5) throw new IlegalnaOcjena("Ilegalna ocjena " + ocjena);
        if(velSrednja >= ocjeneSrednja.length) throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        ocjeneSrednja[velSrednja++] = ocjena;
    }
    public double prosjekSrednja(){
        int suma = 0;
        for(int i = 0; i < velSrednja; i++) suma += ocjeneSrednja[i];
        return (double) Math.round(((double) suma / velSrednja) * 10) / 10;
    }

    @Override
    public double prosjek() {
        int[] ocjene = super.getOcjene();
        int vel = super.dajVel();
        int suma = 0;
        for(int i = 0; i < vel; i++) suma += ocjene[i];
        for(int i = 0; i < velSrednja; i++) suma += ocjeneSrednja[i];
        return (double) Math.round(((double) suma / (vel + velSrednja)) * 100) / 100;
    }

    @Override
    public String toString() {
        double pr =   (double) ((int)((this.prosjek() * 10) + 0.5)) / 10;
        return "Učenik srednje škole " + super.toString()  + " ("
        + super.getBrojKnjizice() + "), prosjek ocjena: " + pr;
    }
    public String rodjendan(LocalDate l){
        if(l.getMonth() == now().getMonth() && l.getDayOfMonth() == now().getDayOfMonth()) return "Sretan rodjendan!";
        return "";
    }
}
