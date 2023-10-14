import java.awt.Color;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(Math.random() * 5 - 2.5, Math.random() * 5 - 2.5, Math.random() * 5 - 2.5);
    public Color color;

    public Particle(vec3 point, Color color) {
        this.position = point;
        this.color = color;
    }

    public void move() {
        this.velocity.add(new vec3(Math.random() * 5 - 2.5, Math.random() * 5 - 2.5, Math.random() * 5 - 2.5));
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