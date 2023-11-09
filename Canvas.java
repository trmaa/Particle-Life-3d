import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

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
        //super.paintComponent(g);

        this.cls(g, new Color(0,0,0,255));

        this.println(g,
            new vec2(-Main.ventana.getWidth()*0.5,Math.sin(Camara.angle.x)*Main.ventana.getHeight()),
            new vec2(Main.ventana.getWidth()*0.5,Math.sin(Camara.angle.x)*Main.ventana.getHeight()),
            2,new Color(0xffffff)
        );
	
        this.print(g,
                Camara.project(Particle.obj.position).x,
                Camara.project(Particle.obj.position).y,
                256 * (Camara.far / Camara.distance(Particle.obj.position) * Camara.near),
                256 * (Camara.far / Camara.distance(Particle.obj.position) * Camara.near),
                new Color(0x00ffff));
        
        this.print(g,
                Camara.project(Particle.obj2.position).x,
                Camara.project(Particle.obj2.position).y,
                256 * (Camara.far / Camara.distance(Particle.obj2.position) * Camara.near),
                256 * (Camara.far / Camara.distance(Particle.obj2.position) * Camara.near),
                new Color(0x00ff00));

        Arrays.sort(Main.redp, (a, b) -> Double.compare(
            Camara.distance(b.position), Camara.distance(a.position)));

        for (int i = 0; i < Main.redp.length; i++) {
            vec3 np = new vec3(
                Main.redp[i].position.x + Math.cos(Main.redp[i].angle.y) * Math.cos(Main.redp[i].angle.x) * (-500),
                Main.redp[i].position.y + Math.sin(Main.redp[i].angle.x) * (-500),
                Main.redp[i].position.z + Math.sin(Main.redp[i].angle.y) * Math.cos(Main.redp[i].angle.x) * (-500)
            );

            // this.print(g,
            //     Camara.project(np).x,
            //     Camara.project(np).y,
            //     32*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near) * 0.5,
            //     32*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near) * 0.5,
            //     new Color(0x000000));
            
            this.print(g,
                Camara.project(Main.redp[i].position).x,
                Camara.project(Main.redp[i].position).y,
                64*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near),
                64*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near),
                Main.redp[i].color);

            Main.redp[i].move();
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
    public void println(Graphics g, vec2 pointo, vec2 pointf, int thich, Color color) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thich)); // Establecer el grosor de la línea

        g2.drawLine(
            Utils.redondear(Main.ventana.getWidth() * 0.5 + pointo.x),
            Utils.redondear(Main.ventana.getHeight() * 0.5 + pointo.y),
            Utils.redondear(Main.ventana.getWidth() * 0.5 + pointf.x),
            Utils.redondear(Main.ventana.getHeight() * 0.5 + pointf.y)
        );
    }
}
