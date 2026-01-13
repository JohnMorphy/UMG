import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        StopByEnter stopByEnter = new StopByEnter();
        stopByEnter.start();

        ArrayList<Osoba> ludzie = new ArrayList<>();

        int konto = Bank.noweKonto( "UMG");
        for( int i=0; i<1000; i++) {
            Osoba o = new Osoba("osoba" + i);
            ludzie.add(o);
            o.noweKonto(konto);
            o.start();
        }   
    }
    
}

class StopByEnter extends Thread {

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            System.out.println("Exiting application...");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}