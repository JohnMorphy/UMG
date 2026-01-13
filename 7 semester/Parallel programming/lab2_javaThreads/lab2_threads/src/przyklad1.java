import java.util.Scanner;

public class przyklad1 {

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int liczba = 0;
		System.out.print("Podaj liczb� (10-30): ");
		liczba = s.nextInt();
		while(liczba < 10 || liczba > 30) {
			System.out.println("Z�y zakres, podaj jeszcze raz liczb� z zakresu 10-30: ");
			liczba = s.nextInt();
		}
		try {
			System.out.println("Program sko�czy dzia�a� za... ");
			//P�tla, jeden przebieg p�tli - 1s
			for(int i = liczba; i >= 1; i--) {
				System.out.print(i + "...");
				Thread.sleep(1000);
			}
			System.out.print("KONIEC!");
		} catch(Exception e) {
			System.out.println(e);
		}
		s.close();
	} //main

}


