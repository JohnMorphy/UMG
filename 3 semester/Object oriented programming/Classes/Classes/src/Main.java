public class Main {
    public static void main(String[] args) {

        TestOb object = new TestOb(10);
        TestOb secondObject = new TestOb();
        TestOb thirdObject = new TestOb(1);

        Pasture fourthObject = new Pasture(14);

        System.out.println(object + "\n");
        System.out.println(object.equals(secondObject));
        System.out.println(secondObject.equals(thirdObject));

        // Aliasing - we are using a pointer to change a value of an object

        TestOb pointer = thirdObject;
        pointer.aaa = 20;
        System.out.println(thirdObject);

        System.out.println(secondObject.equals(fourthObject));

        MyP fifthObject = new MyP();
        MyP sixthObject = new MyP();
        System.out.println(fifthObject);

        System.out.println(MyP.getNumberOfInstances());

        fifthObject.setXB(150);

    }
}