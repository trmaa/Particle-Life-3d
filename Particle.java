import java.awt.Color;

public class Particle {
    public vec3 position;
    public Color color;

    public Particle(vec3 point, Color color) {
        this.position = point;
        this.color = color;
    }
}