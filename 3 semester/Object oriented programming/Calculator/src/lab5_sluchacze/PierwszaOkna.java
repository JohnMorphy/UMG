package lab5_sluchacze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PierwszaOkna extends lab5_sluchacze.BazaOkno
{
    static final long serialVersionUID = 20;

    MouseMotionListener sluchacz1 = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            String napis = "ciągniesz x = " + e.getX() + " y = " + e.getY();
            poletekstowe.setText(napis);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            String napis = "przesuwasz x = " + e.getX() + " y = " + e.getY();
            poletekstowe.setText(napis);
        }
    };

    ActionListener sluchacz2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            short x, y, z;
            if(ae.getSource() == przycisk)
                dispose();
        }
    };

    public static void main(String[] args) {
        PierwszaOkna x = new PierwszaOkna();
        x.addMouseMotionListener(x.sluchacz1);
    }
}