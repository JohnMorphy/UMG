public class MyP extends  MyPB{
    int x = 234;
    public void setXB(int a) {super.x=a;}
    public void setX(int a) {this.x=a;}
    public int getSum() {return this.x+super.x;}

    private static int numberOfInstances = 0;

    public MyP(){
        incrementNumOfInstances();
    }

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    public static void incrementNumOfInstances() {
        numberOfInstances++;
    }

    @Override
    public String toString() {
        return super.toString() + "derived class " + this.getClass().getName();
    }
}
