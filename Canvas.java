import javax.swing.*;
import java.awt.*;

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

        for (int i = Main.redp.length-1; i >= 0; i--) {
            this.print(g,
                    Camara.project(Main.redp[i].position).x,
                    Camara.project(Main.redp[i].position).y,
                    (i==0?128:30) * (Camara.far / Camara.distance(Main.redp[i].position) * Camara.near),
                    (i==0?128:30) * (Camara.far / Camara.distance(Main.redp[i].position) * Camara.near),
                    Main.redp[i].color);
	    
  	        vec3 np = new vec3(
                Main.redp[i].position.x + Math.cos(Main.redp[i].angle.y) * Math.cos(Main.redp[i].angle.x) * (-500),
                Main.redp[i].position.y + Math.sin(Main.redp[i].angle.x) * (-500),
                Main.redp[i].position.z + Math.sin(Main.redp[i].angle.y) * Math.cos(Main.redp[i].angle.x) * (-500) 
            );

            this.print(g,
                    Camara.project(np).x,
                    Camara.project(np).y,
                    (i==0?128:30) * (Camara.far / Camara.distance(Main.redp[i].position) * Camara.near)*0.5,
                    (i==0?128:30) * (Camara.far / Camara.distance(Main.redp[i].position) * Camara.near)*0.5,
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
}
