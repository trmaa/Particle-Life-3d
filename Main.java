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

        for(int i = 0;i < Main.redp.length;i++){
            // Main.redp[i].rb.force(Main.redp[i],Main.center);
            // Main.grnp[i].rb.force(Main.grnp[i],Main.center);
            for(int j = 0;j < Main.redp.length;j++){
                if(Main.redp[i].position != Main.redp[j].position){
                    Main.redp[i].g = 0.1; 
                    Main.grnp[i].g = -0.5; 
                    Main.redp[i].rb.force(Main.redp[i],Main.grnp[j]); 
                    Main.grnp[i].rb.force(Main.grnp[i],Main.redp[j]);
                    Main.redp[i].g = 0; 
                    Main.grnp[i].g = 0.05; 
                    Main.redp[i].rb.force(Main.redp[i],Main.redp[j]); 
                    Main.grnp[i].rb.force(Main.grnp[i],Main.grnp[j]); 
                }else 
                    continue;
            }
            //System.out.println(Main.redp[0].velocity.x);
            Main.redp[i].move();
            Main.grnp[i].move();
        }
    }
}
