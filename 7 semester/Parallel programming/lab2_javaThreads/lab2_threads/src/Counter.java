import java.util.Random;

public class Counter extends Thread {
    private int lifeTime;
    private String name;

    public Counter(int lifeTime, String name) {
        super();
        this.lifeTime = lifeTime;
        this.name = name;
    }

    public void publishState() {
        this.lifeTime--;
        System.out.println(name + " will stop working in " + lifeTime + "s");
    }

    @Override
    public void run() {
        
        while (this.lifeTime > 0) {
            try {
                Thread.sleep(1000);
                publishState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("THE END");
    }
    
    public static void main(String[] args) {

        int counterCount = 5;

        for (int i = 0; i<counterCount; i++) {
            Random random = new Random();
            int randomValue = random.nextInt(20) + 10; // random value from 10 to 30
            Counter counter = new Counter(randomValue, "obiekt" + (i+1));
            counter.start();
        }
    }
}
