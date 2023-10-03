package lab5_sluchacze;

public class MójWyjątek extends RuntimeException{

    static final long serialVersionUID = 1;

    int suma;
    int roznica;
    long sumad;
    long roznicad;

    public MójWyjątek(short x, short y) {
        super("Przekroczenie zakresu typu short");
        suma = (int)x + (int)y;
        roznica = (int)x - (int)y;
    }

    public MójWyjątek(int x, int y) {
        super("Przekroczenie zakresu typu int");
        sumad = (long)x + (long)y;
        roznicad = (long)x - (long)y;
    }

}
