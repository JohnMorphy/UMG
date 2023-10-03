import java.text.Collator;
import java.util.Locale;

public class MojaKlasa implements Comparable<MojaKlasa> {
    private String firstText;
    private String secondText;

    public MojaKlasa(String firstText, String secondText) {
        this.firstText = firstText;
        this.secondText = secondText;
    }

    @Override
    public String toString() {
        return firstText+secondText;
    }

    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }

    public String biggerAttribute(){
        if(firstText.compareTo(secondText)>=0)
            return firstText;
        else
            return secondText;
    }

    Collator c = Collator.getInstance(new Locale("pl", "PL"));

    @Override
    public int compareTo(MojaKlasa o) {
        return c.compare(this.getFirstText(), o.getFirstText());
    }
}
