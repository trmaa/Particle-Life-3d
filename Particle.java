import java.awt.Color;

public class Particle {
    public vec3 position;
    public vec3 velocity = new vec3(0, 0, 0);
    public vec2 angle = new vec2(Math.random() * Math.PI * 2, Math.random() * Math.PI * 2);
    public double speed = Math.random() * 10;
    public Color color;

    public double[] inputs = new double[6];
    public Network brain = new Network(6, 5, 5);

    public Particle(vec3 point, Color color) {
        this.position = point;
        this.color = color;
    }

    public void move() {
        this.inputs[0] = this.position.x;
        this.inputs[1] = this.position.y;
        this.inputs[2] = this.position.z;
        this.inputs[3] = this.angle.x;
        this.inputs[4] = this.angle.y;
        this.inputs[5] = this.speed;

        double[] predict = this.brain.predict(this.inputs);

        this.angle.x += predict[0] > predict[1] ? 0.1 : -0.1;
        this.angle.y += predict[2] > predict[3] ? 0.1 : -0.1;
        this.speed = predict[4] * 500 - 250;

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