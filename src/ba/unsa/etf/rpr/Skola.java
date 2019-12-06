package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import static java.time.LocalDate.now;

public class Skola {
    private ArrayList<Osoba> osobe = new ArrayList<>();

    public void dodajOsobu(Osoba o){
        osobe.add(o);
    }

    @Override
    public String toString() {
        String s = "";
        for(Osoba o: osobe) s += o.toString() + "\n";
        return s;
    }

    public Set<Ucenik> ucenici(){
     TreeSet<Ucenik> ucenici = new TreeSet<>();
     for(Osoba o: osobe){
         if(o instanceof Ucenik) ucenici.add((Ucenik)o);
     }
     return ucenici;
    }

    public List<Osoba> filtriraj(Function<Osoba,Boolean> l){
        List<Osoba> os = new ArrayList<Osoba>();
        for(Osoba o: osobe) if(l.apply(o)) os.add(o);
        return os;
    }
    public List<Osnovac> topOsnovac(){
        List osnovci = this.filtriraj((o) -> {if(o instanceof Osnovac){
                if(((Osnovac) o).prosjek() >= 4) return true;
                else return false;
            }
            else return false;
        });
        return (List<Osnovac>) osnovci;
    }
    public List<Slavljenik> slavljenici(){
        List lista = this.filtriraj((o) ->{
            if(o instanceof Ucitelj){
                if(((Ucitelj) o).rodjendan(now()) != null) return true;
                else return false;
            }
            else if(o instanceof Srednjoskolac){
                if(((Srednjoskolac) o).rodjendan(now()) != null) return true;
                return false;
            }
            return false;
        });
        return (List<Slavljenik>) lista;
    }

}
