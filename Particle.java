import java.awt.Color;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(0, 0, 0);
    public vec2 angle = new vec2(0, 0);
    public double speed = Math.random() * 10;
    public double friction = 2;
    public Color color;

    public Particle(vec3 point, Color color) {
        this.position = point;
        this.color = color;
    }

    public void move() {
        this.angle.add(new vec2(Math.random() * Math.PI * 2, Math.random() * Math.PI * 2));
        this.velocity.add(new vec3(
                Math.cos(this.angle.y) * Math.cos(this.angle.x) * this.speed,
                Math.sin(this.angle.y) * Math.cos(this.angle.x) * this.speed,
                Math.sin(this.angle.x) * this.speed));
        this.position.add(this.velocity);

        if (this.position.x > 5000)
            this.position.x = 5000;
        if (this.position.x < -5000)
            this.position.x = -5000;
        if (this.position.y > 5000)
            this.position.y = 5000;
        if (this.position.y < -5000)
            this.position.y = -5000;
        if (this.position.z > 5000)
            this.position.z = 5000;
        if (this.position.z < -5000)
            this.position.z = -5000;
    }
}