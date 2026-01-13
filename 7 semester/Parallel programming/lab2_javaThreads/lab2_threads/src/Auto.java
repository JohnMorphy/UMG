import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Auto extends Thread implements Comparator<Auto> {
    private CarState state;
    private String name;
    private Double finishTime;

    private void publishState() {
        this.state = CarState.nextState(state);
        System.out.println("The " + name + " is " + state);
    }

    private void slipped() {
        System.out.println("The " + name + " has slipped! Still " + state);
    }

    private void tireExplosion() throws InterruptedException {
        System.out.println("The " + name + " has an exploded tire!! The maintainance team is changing it quickly! Still " + state);
        Thread.sleep(5000);
    }

    @Override
    public void run() {

        Random random = new Random();
        long start = System.nanoTime();
        while(!state.equals(CarState.FINISH_LINE)) {
            try {
                Thread.sleep(1000);
                if(random.nextFloat() < 0.05) {
                    tireExplosion();
                } else if (random.nextFloat() < 0.2) {
                    slipped();
                } else {
                    publishState();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        finishTime = (end-start)/1000000.0;
    }

    public Auto (String name) {
        this.state = CarState.STARTING;
        this.name = name;
        this.finishTime = -1.0;
    }

    public CarState getCarState() {
        return state;
    }

    public String getCarName() {
        return name;
    }

    public double getFinishTime() {
        return finishTime;
    }

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.finishTime.compareTo(o2.finishTime);
    }

    public static void main(String[] args) throws InterruptedException {
        int carCount = 5;

        ArrayList<Auto> startingList = new ArrayList<>();
        for (int i = 0; i<carCount; i++) {
            Auto auto = new Auto("car" + (i+1));
            startingList.add(auto);
            auto.start();
        }


        for (Auto auto : startingList) {
            auto.join();
            System.out.println(auto.getCarName() + " finish time: " + auto.getFinishTime() + "s");
        }
    }
}

enum CarState {
    STARTING(0),
    ACCELARATING(1),
    TURN_1(2),
    TURN_2(3),
    TURN_3(4),
    TURN_4(5),
    TURN_5(6),
    LAST_LINE(7),
    FINISH_LINE(8);

    private final int phase;

    CarState(int phase) {
        this.phase = phase;
    }

    public static CarState nextState(CarState currentState) {
        int nextValue = currentState.getValue() + 1;
        for (CarState state : values()) {
            if (state.getValue() == nextValue) {
                return state;
            }
        }
        return FINISH_LINE;
    }

    public int getValue() {
        return phase;
    }
}