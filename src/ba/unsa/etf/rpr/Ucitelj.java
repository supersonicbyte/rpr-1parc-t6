package ba.unsa.etf.rpr;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Ucitelj extends Nastavnik implements Slavljenik{
    public Ucitelj(String imePrezime){
        super(imePrezime);
    }

    @Override
    public String toString() {
        return "Učitelj " + super.getImePrezime();
    }

    public String rodjendan(LocalDate l){
        if(l.getMonth() == now().getMonth() && l.getDayOfMonth() == now().getDayOfMonth()) return "Sretan rodjendan!";
        return "";
    }
}
