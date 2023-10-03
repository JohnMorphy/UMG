package lab5_sluchacze;

public class MójWyjątekzm extends RuntimeException {

    static final  long serialVersionUID = 10;

    double iloraz;

    public MójWyjątekzm(float x, float y) {
        super("Przekroczenie zakresu wartości zmiennopozycyjnych");
        if(y == 0.0) {
            iloraz = Double.MAX_VALUE;
        } else {
            iloraz = (double)x/(double)y;
        }
    }
}
