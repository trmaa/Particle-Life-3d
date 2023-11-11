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
            new vec2(-Main.ventana.getWidth()*0.5,Math.sin(Camara.angle.x)*Main.ventana.getHeight()*2/*+Camara.position.y*0.01*/),
            new vec2(Main.ventana.getWidth()*0.5,Math.sin(Camara.angle.x)*Main.ventana.getHeight()*2/*+Camara.position.y*0.01*/),
            2,new Color(0x555555)
        );
        this.print(g,
            -Main.ventana.getWidth()*0.5,Math.sin(Camara.angle.x)*Main.ventana.getHeight()*2/*+Camara.position.y*0.01*/,
            Main.ventana.getWidth(),10000,new Color(0x111111)
        );
	
        // this.print(g,
        //     Camara.project(Main.center.position).x,
        //     Camara.project(Main.center.position).y,
        //     256*(Camara.far / Camara.distance(Main.center.position) * Camara.near),
        //     256*(Camara.far / Camara.distance(Main.center.position) * Camara.near),
        //     Main.center.color);

        Particle[] tempp = Main.redp;
        Arrays.sort(tempp, (a, b) -> Double.compare(
            Camara.distance(b.position), Camara.distance(a.position)));

        for (int i = 0; i < tempp.length; i++) {
            vec3 np = new vec3(
                tempp[i].position.x + Math.cos(tempp[i].angle.y) * Math.cos(tempp[i].angle.x) * (-500),
                tempp[i].position.y + Math.sin(tempp[i].angle.x) * (-500),
                tempp[i].position.z + Math.sin(tempp[i].angle.y) * Math.cos(tempp[i].angle.x) * (-500)
            );

            // this.print(g,
            //     Camara.project(np).x,
            //     Camara.project(np).y,
            //     32*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near) * 0.5,
            //     32*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near) * 0.5,
            //     new Color(0x000000));
            
            this.print(g,
                Camara.project(tempp[i].position).x,
                Camara.project(tempp[i].position).y,
                64*(Camara.far / Camara.distance(tempp[i].position) * Camara.near),
                64*(Camara.far / Camara.distance(tempp[i].position) * Camara.near),
                tempp[i].color);
        }

        Particle[] tempp2 = Main.grnp;
        Arrays.sort(tempp2, (a, b) -> Double.compare(
            Camara.distance(b.position), Camara.distance(a.position)));

        for (int i = 0; i < tempp2.length; i++) {
            vec3 np = new vec3(
                tempp2[i].position.x + Math.cos(tempp2[i].angle.y) * Math.cos(tempp2[i].angle.x) * (-500),
                tempp2[i].position.y + Math.sin(tempp2[i].angle.x) * (-500),
                tempp2[i].position.z + Math.sin(tempp2[i].angle.y) * Math.cos(tempp2[i].angle.x) * (-500)
            );

            // this.print(g,
            //     Camara.project(np).x,
            //     Camara.project(np).y,
            //     32*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near) * 0.5,
            //     32*(Camara.far / Camara.distance(Main.redp[i].position) * Camara.near) * 0.5,
            //     new Color(0x000000));
            
            this.print(g,
                Camara.project(tempp2[i].position).x,
                Camara.project(tempp2[i].position).y,
                64*(Camara.far / Camara.distance(tempp2[i].position) * Camara.near),
                64*(Camara.far / Camara.distance(tempp2[i].position) * Camara.near),
                tempp2[i].color);
        }

        Cursor.update();
        this.println(g,
            Camara.project(Cursor.position).add(new vec2(Main.ventana.getWidth()*0.5-100,100-Main.ventana.getHeight()*0.5)),
            Camara.project(new vec3(Cursor.position.x,Cursor.position.y,Cursor.vertex.z)).add(new vec2(Main.ventana.getWidth()*0.5-100,100-Main.ventana.getHeight()*0.5)),
            3,new Color(0x0000ff)
        );
        this.println(g,
            Camara.project(Cursor.position).add(new vec2(Main.ventana.getWidth()*0.5-100,100-Main.ventana.getHeight()*0.5)),
            Camara.project(new vec3(Cursor.vertex.x,Cursor.position.y,Cursor.position.z)).add(new vec2(Main.ventana.getWidth()*0.5-100,100-Main.ventana.getHeight()*0.5)),
            3,new Color(0x00ff00)
        );
        this.println(g,
            Camara.project(Cursor.position).add(new vec2(Main.ventana.getWidth()*0.5-100,100-Main.ventana.getHeight()*0.5)),
            Camara.project(new vec3(Cursor.position.x,Cursor.vertex.y,Cursor.position.z)).add(new vec2(Main.ventana.getWidth()*0.5-100,100-Main.ventana.getHeight()*0.5)),
            3,new Color(0xff0000)
        );
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
