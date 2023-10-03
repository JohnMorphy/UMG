public class TestOb {
    public int aaa;

    public TestOb(int value){
        this.aaa = value;
    }
    public TestOb(){
        this.aaa = 0;
    }

    @Override
    public String toString() {
        return "Value of aaa equals: " + aaa;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pasture) {
            return this.aaa == ((Pasture)obj).cow;
        }
        return this.aaa == ((TestOb)obj).aaa;
    }
    public boolean equals(TestOb obj){
        return this.aaa == obj.aaa;
    }
}

