import java.util.ArrayList;

public class Bank {
    
    private static ArrayList<KontoBankowe> konta = new ArrayList<KontoBankowe>();

    public static synchronized KontoBankowe getKontoBankowe(int nrKonto) {
        return konta.get(nrKonto);
    }

    public static int noweKonto(String nazwisko) {
        KontoBankowe noweKonto = new KontoBankowe(konta.size(), 0, nazwisko);
        konta.add(noweKonto);
        return noweKonto.getNumerKonta();
    }

    public static double wyplata(int numerKonta, double kwota) {
        return konta.get(numerKonta).wyplata(kwota);
    }
    
    public static double wplata(int numerKonta, double kwota) {
        return konta.get(numerKonta).wplata(kwota);
    }
    
    public static double stanKonta(int numerKonta) {
        return konta.get(numerKonta).getKwota();
    }
}
