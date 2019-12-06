package ba.unsa.etf.rpr;

public class Osnovac extends Ucenik {
    public Osnovac(String imePrezime){
        super(imePrezime);
    }
    @Override
    public String toString() {
        double pr =   (double) ((int)((this.prosjek() * 10) + 0.5)) / 10;
        return "Učenik osnovne škole " + super.toString() + " (" + super.getBrojKnjizice()
                + "), prosjek ocjena: " + pr;

    }
}
