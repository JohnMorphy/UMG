public class Cars extends Vehicles{

    private String type = "combustion";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void audit(){
        System.out.println("\nCar specifications");
        System.out.println("====================");
        System.out.println(this.type);
    }

    @Override
    public String toString() {
        return "Cars{}";
    }
}
