import java.awt.Color;

public class Main {
    public static Canvas cvs = new Canvas();
    public static Ventana ventana = new Ventana();

    public static Particle center = new Particle(new vec3(10000,10000,10000),new Color(0xff00ff),10);
    public static Particle[] redp = new Particle[200];
    public static Particle[] grnp = new Particle[200];

    public static void main(String[] args) {
        for (int i = 0; i < Main.redp.length; i++) {
            Main.redp[i] = new Particle(
                    new vec3(Math.random() * 2000 - 1000, Math.random() * 2000 - 1000, Math.random() * 2000 - 1000),
                    new Color(255,Utils.redondear(Math.random()*255), 0),0.2);
        }
        for (int i = 0; i < Main.grnp.length; i++) {
            Main.grnp[i] = new Particle(
                    new vec3(Math.random() * 2000*4 - 1000*4, Math.random() * 2000*4 - 1000*4, Math.random() * 2000*4 - 1000*4),
                    new Color(0,255,Utils.redondear(Math.random()*255)),0.2);
        }

        while (true) {
            Main.loop();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loop() {
        Main.cvs.repaint();

        God.move();

        Particle[][] p = {Main.redp,Main.grnp};
        int[] dir = {1,1};
        Particle.force(p,dir);
    }
}
