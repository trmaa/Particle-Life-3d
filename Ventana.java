import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Universo | trmaa");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ico = new ImageIcon("icono.jpg");
        setIconImage(ico.getImage());

        add(Main.cvs);

        setVisible(true);
    }
}
