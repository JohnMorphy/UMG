import java.util.Random;

public class Osoba extends Thread{
    
    private String nazwisko;
    private int nrKonto;
    static Random r = new Random();

    public Osoba(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void noweKonto(int numerKonta) {
        this.nrKonto = numerKonta;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getNrKonto() {
        return nrKonto;
    }

    @Override
    public void run() {
        while(true) {
            int losowaKwota = r.nextInt(10);
            KontoBankowe konto = Bank.getKontoBankowe(this.nrKonto);

            synchronized (konto) {
                System.out.println(this.nazwisko + ":" + "Wpłata: " + Bank.wplata(this.nrKonto, losowaKwota) + "; po wyplacie: " + Bank.wyplata(this.nrKonto, losowaKwota));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
