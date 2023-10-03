public class Chariot extends Vehicles{

    private String type = "two horse";

    public void audit(){
        System.out.println("\nChariot specifications");
        System.out.println("====================");
        System.out.println(this.type);
    }
}
