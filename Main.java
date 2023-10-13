import java.awt.Color;

public class Main {
    public static Canvas cvs = new Canvas();
    public static Ventana ventana = new Ventana();

    public static Particle[] redp = {
            new Particle(new vec3(0, 0, 0), new Color(0xff0000)),
            new Particle(new vec3(0, 1000, 0), new Color(0xff0000)),
            new Particle(new vec3(1000, 1000, 0), new Color(0xff0000)),
            new Particle(new vec3(1000, 0, 0), new Color(0xff0000)),
            new Particle(new vec3(0, 0, 1000), new Color(0xff0000)),
            new Particle(new vec3(0, 1000, 1000), new Color(0xff0000)),
            new Particle(new vec3(1000, 1000, 1000), new Color(0xff0000)),
            new Particle(new vec3(1000, 0, 1000), new Color(0xff0000))
    };

    public static void main(String[] args) {
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