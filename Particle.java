import java.awt.Color;
import java.util.Arrays;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(0,0,0);
    public vec2 angle = new vec2(Math.random() * Math.PI * 0.5, Math.random() * Math.PI * 0.5);
    public double speed = 10;
    public double g = 0.01;
    public Color color;

    public RigidBody rb = new RigidBody();

    public Particle(vec3 point, Color color, double g) {
        this.position = point;
        this.color = color;
        this.g = g;
    }

    public void move() {
        this.position.add(this.velocity);

        // if(this.position.x > 10000)
        //     this.position.x = 10000;
        // if(this.position.x < -10000)
        //     this.position.x = -10000;
        // if(this.position.y > 10000)
        //     this.position.y = 10000;
        // if(this.position.y < -10000)
        //     this.position.y = -10000;
        // if(this.position.z > 10000)
        //     this.position.z = 10000;
        // if(this.position.z < -10000)
        //     this.position.z = -10000;
    }

    public static void force(Particle[][] particles,int[] dir){
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
