import java.awt.Color;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(0, 0, 0);
    public vec2 angle = new vec2(Math.random() * Math.PI * 2, Math.random() * Math.PI * 2);
    public double speed = Math.random() * 10;
    public Color color;

    public double[] inputs = new double[3];
    public Network brain = new Network(3, 3, 3);

    public Particle(vec3 point, Color color) {
        this.position = point;
        this.color = color;
    }

    public void move() {
        this.inputs[0] = this.angle.x;
        this.inputs[1] = this.angle.y;
        this.inputs[2] = this.speed;

        double[] predict = this.brain.predict(this.inputs);

        this.angle.x += predict[0] * 2 - 1;
        this.angle.y += predict[1] * 2 - 1;
        this.speed += predict[2] * 2 - 1;

        this.speed = this.speed<0?0:this.speed;

        this.velocity = (new vec3(
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