import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Canvas extends JPanel {
    public MyKeyListener kl = new MyKeyListener();

    public Canvas() {
        this.addKeyListener(this.kl);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.cls(g, new Color(0x000000));

        // this.print(g, Camara.position.x, Camara.position.z, 10, 10, new
        // Color(0xffffff));
        // this.print(g, Camara.position.x + Math.cos(Camara.angle.y) * 25,
        // Camara.position.z + Math.sin(Camara.angle.y) * 25, 5, 5, new
        // Color(0xffffff));
        // for (int i = 0; i < Obj.points.length; i++) {
        // this.print(g, Obj.points[i].x, Obj.points[i].z, 10, 10, new Color(0xffff00));
        // }

        for (int i = 0; i < Main.obj.points.length; i++) {
            this.print(g,
                    Camara.project(Main.obj.points[i]).x,
                    Camara.project(Main.obj.points[i]).y,
                    30 * (Camara.far / Camara.distance(Main.obj.points[i]) * Camara.near),
                    30 * (Camara.far / Camara.distance(Main.obj.points[i]) * Camara.near),
                    new Color(0xffffff));
        }
    }

    public void cls(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(0, 0, Main.ventana.getWidth(), Main.ventana.getHeight());
    }

    public void print(Graphics g, double x, double y, double w, double h, Color c) {
        g.setColor(c);
        g.fillRect(Utils.redondear(Main.ventana.getWidth() * 0.5 + x),
                Utils.redondear(Main.ventana.getHeight() * 0.5 + y), Utils.redondear(w), Utils.redondear(h));
    }

    public void printext(Graphics g, String msg, int x, int y, String fnt, int d, Color c) {
        g.setColor(c);
        g.setFont(new Font(fnt, Font.BOLD, d));
        g.drawString(msg, x, y);
    }
}