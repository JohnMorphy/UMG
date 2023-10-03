public class Main {
    public static void main(String[] args) {
        Lightbulbs test = new Lightbulbs();

        System.out.println(test.showState());
        test.setSupplyVoltage(100);
        test.dim(50);
        test.dim(50);
        test.lightUp(15);
        System.out.println(test.showState());

        for(int i = 0; i<15; i++){
            new Lightbulbs();
        }

        int i=0;

        for (Lightbulbs b : test.bulbList) {
            if(i == 1 || i == 2 || i == 5)
                b.turnOn();

            if(i == 0 || i == 3 || i == 9 || i == 11)
                b.turnOf();

            i++;
        }

        System.out.println("Number of lit bulbs: " + Lightbulbs.nrOfLitBulbs());

        System.out.println(test.bulbList.get(5));

        for (Lightbulbs b : test.bulbList) {
            b.turnOf();
        }
        System.out.println("\n\n");

        Lightbulb x = new Lightbulbs();

        System.out.println(x.toString());

        System.out.println(x.getClass());

        System.out.println(x.getSupplyVoltage() + " " + x.getSupplyVoltage() + ((Lightbulbs) x).showState() );

    }
}