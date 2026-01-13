import java.util.ArrayList;

public class KontoBankowe {
    
    private int numerKonta;
    private double kwota;
    private String nazwiskoWlasciciela;

    private ArrayList<Tranzakcja> historiaTranzakcji = new ArrayList<>();
    
    public KontoBankowe(int numerKonta, double kwota, String nazwiskoWlasciciela) {
        this.numerKonta = numerKonta;
        this.kwota = kwota;
        this.nazwiskoWlasciciela = nazwiskoWlasciciela;
    }

    public int getNumerKonta() {
        return numerKonta;
    }

    public double getKwota() {
        return kwota;
    }

    public String getNazwiskoWlasciciela() {
        return nazwiskoWlasciciela;
    }

    public synchronized double wyplata(double kwotaWyplaty) {
        
        if(kwota < kwotaWyplaty) {
            System.out.println("Insuficcent funds");
            return kwota;
        } else {
            historiaTranzakcji.add(new Tranzakcja(this.kwota, this.kwota - kwotaWyplaty));
            this.kwota = this.kwota - kwotaWyplaty;
        }

        if(historiaTranzakcji.size()%10 == 0) {
            System.out.println(this.historiaTranzakcji);
        }

        return kwota;
    }

    public synchronized double wplata(double kwotaWplaty) {

        historiaTranzakcji.add(new Tranzakcja(this.kwota, this.kwota + kwotaWplaty));
        this.kwota = this.kwota + kwotaWplaty;

        if(historiaTranzakcji.size()%10 == 0) {
            System.out.println(this.historiaTranzakcji);
        }

        return kwota;
    }

    @Override
    public String toString() {
        return nazwiskoWlasciciela + " " + String.valueOf( (int)kwota);
    }

}

class Tranzakcja {
    private double stanPoczatkowy;
    private double stanKoncowy;

    public Tranzakcja(double stanPoczatkowy, double stanKoncowy) {
        this.stanPoczatkowy = stanPoczatkowy;
        this.stanKoncowy = stanKoncowy;
    }

    @Override
    public String toString() {
        return "stanPoczatkowy=" + stanPoczatkowy + ", stanKoncowy=" + stanKoncowy;
    }

    
}