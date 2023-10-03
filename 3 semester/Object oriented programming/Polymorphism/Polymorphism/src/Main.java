public class Main {
    public static void main(String[] args) {

        Vehicles example = new Vehicles();

        Cars car = new Cars();
        Chariot chariot = new Chariot();
        Vehicles mobile = new Cars();
        Cars p1 = ((Cars)mobile); // access to all elements - those covered up too

        System.out.println(mobile.getClass());
        ((Cars) mobile).setType("electrical");

        car.doIt();
        chariot.doIt();
        mobile.doIt();
        p1.doIt();

    }
}