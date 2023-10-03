package lab5_sluchacze;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BazaOkno extends JFrame
{
    static final long serialVersionUID = 0;
    int szerokosc = 400;
    int wysokosc = 400;
    int poczp = 60; //lewy górny róg
    int szerokoscK = szerokosc/2;
    int wysokoscK = wysokosc/2;
    int szerK = szerokoscK/3;
    int wysK = wysokoscK/12;
    //et - etykieta, szerK - szerokosc klawiatury
    JButton przycisk;
    JLabel et;
    JTextField poletekstowe;
    public BazaOkno()
    {
        Font czcionka = new Font("Serif", Font.BOLD, 20);
        przycisk = new JButton("KONIEC");
        przycisk.setBounds(szerokoscK-szerK, poczp+wysK/2, szerK*2, wysK);
        przycisk.setFont(czcionka);
        ImageIcon obrazek = new ImageIcon("C:\\inne\\kalkulator.jpg");
        et = new JLabel(obrazek);
        et.setBounds(szerokoscK-szerK, poczp+2*wysK, szerK*2, obrazek.getIconHeight());
        et.setIcon(obrazek);
        poletekstowe = new JTextField("Witam w UMG");
        poletekstowe.setBounds(szerokoscK-szerK, poczp-wysK/2, szerK*2, wysK);
        poletekstowe.setFont(czcionka);

        add(przycisk);
        add(poletekstowe);
        add(et);

        this.setSize(szerokosc, wysokosc);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BazaOkno o1 = new BazaOkno();
        lab5_sluchacze.Klawiatura k1 = new lab5_sluchacze.Klawiatura();
    }
}