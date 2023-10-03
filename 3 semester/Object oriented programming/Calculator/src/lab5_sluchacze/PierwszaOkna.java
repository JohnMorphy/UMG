import java.awt.event.*;

public class PierwszaOkna extends WindowView {
    private static final long serialVersionUID = 20;

    MouseMotionListener słuchacz_1 = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            String napis = "ciągniesz x=" + e.getX() + " y= " + e.getY();
            textField.setText(napis);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            String napis = "przesuwasz x=" + e.getX() + " y= " + e.getY();
            textField.setText(napis);
        }
    };

    ActionListener słuchacz_2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            short x,y,z;
            if(ae.getSource() == przycisk)
                dispose();
        }
    };

    public static void main(String[] args) {
        PierwszaOkna x = new PierwszaOkna();
        x.addMouseMotionListener(x.słuchacz_1);
    }

}
