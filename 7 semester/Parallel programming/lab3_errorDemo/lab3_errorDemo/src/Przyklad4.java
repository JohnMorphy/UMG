import java.util.concurrent.TimeUnit;

public class Przyklad4 {
	private static boolean stopRequested;

	private static synchronized boolean czyKoniec() {
		return stopRequested;
	}

	private static synchronized void ustawKoniec() {
		stopRequested = true;
	}


	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(
			new Runnable() {
				public void run() {
					int i = 0;
					while (!czyKoniec())
						i++;
				}
			}
		);
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		ustawKoniec();
	}
}