import java.awt.Color;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(Math.random() * 50 - 25, Math.random() * 50 - 25, Math.random() * 50 - 25);
    public Color color;

    public Particle(vec3 point, Color color) {
        this.position = point;
        this.color = color;
    }

    public void move() {
        this.velocity.add(new vec3(Math.random() * 50 - 25, Math.random() * 50 - 25, Math.random() * 50 - 25));
        this.position.add(this.velocity);

        if (this.position.x > 1000)
            this.position.x = 1000;
        if (this.position.x < -1000)
            this.position.x = -1000;
        if (this.position.y > 1000)
            this.position.y = 1000;
        if (this.position.y < -1000)
            this.position.y = -1000;
        if (this.position.z > 1000)
            this.position.z = 1000;
        if (this.position.z < -1000)
            this.position.z = -1000;
    }
}