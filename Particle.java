import java.awt.Color;

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
}
