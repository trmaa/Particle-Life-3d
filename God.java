public class God {
    public static void move() {
        if (MyKeyListener.LEFT)
            Camara.angle.y += 0.1;
        if (MyKeyListener.RIGHT)
            Camara.angle.y -= 0.1;
        if (MyKeyListener.UP)
            Camara.angle.x += 0.1;
        if (MyKeyListener.DOWN)
            Camara.angle.x -= 0.1;

        if (MyKeyListener.W) {
            Camara.position.x += Math.cos(Camara.angle.y) * 100;
            Camara.position.z += Math.sin(Camara.angle.y) * 100;
        }
        if (MyKeyListener.S) {
            Camara.position.x -= Math.cos(Camara.angle.y) * 100;
            Camara.position.z -= Math.sin(Camara.angle.y) * 100;
        }
        if (MyKeyListener.A) {
            Camara.position.x += Math.cos(Camara.angle.y + Math.PI * 0.5) * 100;
            Camara.position.z += Math.sin(Camara.angle.y + Math.PI * 0.5) * 100;
        }
        if (MyKeyListener.D) {
            Camara.position.x -= Math.cos(Camara.angle.y + Math.PI * 0.5) * 100;
            Camara.position.z -= Math.sin(Camara.angle.y + Math.PI * 0.5) * 100;
        }
        if (MyKeyListener.E)
            Camara.position.y += 100;
        if (MyKeyListener.Q)
            Camara.position.y -= 100;
    }
}
