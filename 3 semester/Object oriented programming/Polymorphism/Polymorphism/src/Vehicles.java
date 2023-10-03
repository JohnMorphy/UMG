public class Vehicles {

    public void audit(){
        System.out.println("Audit of a vehicle:");
    }

    // Instance method
    public void doIt() {
        this.audit();

        String a = this.getClass().getGenericSuperclass().getTypeName();
        System.out.println("\nsuper: " + a);
        String aa = this.getClass().getTypeName();
        System.out.println("class: " + aa);
        String aaa = this.toString();
    }

    // Static method
    static void doIt(Vehicles p) {
        p.audit();

        String a = p.getClass().getGenericSuperclass().getTypeName();
        System.out.println("\n super: " + a);
        String aa = p.getClass().getTypeName();
        System.out.println("class: " + aa);
        String aaa = p.toString();
    }
}
