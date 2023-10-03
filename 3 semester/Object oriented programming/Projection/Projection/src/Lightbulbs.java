import java.util.ArrayList;

public class Lightbulbs extends Lightbulb {
    private String owner = "No name";
    private String typeBulb = "lightbulb";

    public static ArrayList<Lightbulbs> bulbList = new ArrayList<>();
    public Lightbulbs() {bulbList.add(this);}

    public Lightbulbs (String owner, String typeBulb, int supplyVoltage, int maxVoltage)
    {
        super(supplyVoltage, maxVoltage);
        this.owner = owner;
        this.typeBulb = typeBulb;
        bulbList.add(this);
    }

    @Override
    public String toString() {
        return (super.toString() +owner + " " + typeBulb);
    }

    public String showState() {return super.toString();}

    public static int nrOfLitBulbs() {
        int sum=0;
        for (Lightbulbs b : bulbList) {
            if(b.getMaxVoltage() == b.getSupplyVoltage())
                sum++;
        }
        return sum;
    }
    void dim(double percentage) {
        double check = this.getSupplyVoltage()*(1-(percentage/100));
        if(check < 0)
            this.setSupplyVoltage(0);
        else if(check > this.getMaxVoltage())
            this.setSupplyVoltage(getMaxVoltage());
        else
            this.setSupplyVoltage(check);
    }

    void lightUp(double percentage) {
        double check = this.getSupplyVoltage()*(1+(percentage/100));
        if(check < 0)
            this.setSupplyVoltage(0);
        else if(check > this.getMaxVoltage())
            this.setSupplyVoltage(getMaxVoltage());
        else
            this.setSupplyVoltage(check);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTypeBulb() {
        return typeBulb;
    }

    public void setTypeBulb(String typeBulb) {
        this.typeBulb = typeBulb;
    }
}

