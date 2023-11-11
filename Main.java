import java.awt.Color;

public class Main {
    public static Canvas cvs = new Canvas();
    public static Ventana ventana = new Ventana();

    public static Particle[] redp = new Particle[5000];

    public static void main(String[] args) {
        int r = Utils.redondear(Math.random() * 100 + 155);
        Main.redp[0] = new Particle(
                new vec3(Math.random() * 200 - 100, Math.random() * 200 - 100, Math.random() * 200 - 100),
                new Color(0, 255,100), 0);
        for (int i = 1; i < Main.redp.length; i++) {
            Main.redp[i] = new Particle(
                    new vec3(Math.random() * 2000 - 1000, Math.random() * 2000 - 1000, Math.random() * 2000 - 1000),
                    new Color(r,Utils.redondear(Math.random()*255), 0), 9);
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
    }
}
