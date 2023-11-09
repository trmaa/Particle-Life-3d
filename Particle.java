import java.awt.Color;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(0, 100, Math.random()*200-100);
    public vec2 angle = new vec2(Math.random() * Math.PI * 0.5, Math.random() * Math.PI * 0.5);
    public double speed = 10;
    public float g = 1;
    public Color color;

    public RigidBody rb = new RigidBody();

    public static Particle obj = new Particle(new vec3(3000, 3000, -3000), new Color(0xff0000), -5.81f);
    public static Particle obj2 = new Particle(new vec3(4000, 4000, -4000), new Color(0xffff00), 15.81f);

    public Particle(vec3 point, Color color, float g) {
        this.position = point;
        this.color = color;
        this.g = g;
    }

    public void move() {
        this.rb.force(this, Particle.obj);
        this.rb.force(this, Particle.obj2);

        this.position.add(this.velocity);
    }
}
