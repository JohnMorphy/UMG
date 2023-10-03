public class Lightbulb {
    private double supplyVoltage = 0;

    private double maxVoltage = 230;


    public double getSupplyVoltage() {
        return supplyVoltage;
    }

    public double getMaxVoltage() {
        return maxVoltage;
    }

    public void setSupplyVoltage(double supplyVoltage) {
        this.supplyVoltage = supplyVoltage;
    }

    public void setMaxVoltage(double maxVoltage) {
        this.maxVoltage = maxVoltage;
    }
    public Lightbulb() { }
    public Lightbulb(int supplyVoltage, int maxVoltage){
        this.supplyVoltage = supplyVoltage;
        this.maxVoltage = maxVoltage;
    }

    @Override
    public String toString() {
        return supplyVoltage + " " + maxVoltage + " ";
    }

    void turnOn(){
        this.supplyVoltage = maxVoltage;
    }

    void turnOf(){
        this.supplyVoltage = 0;
    }

}
