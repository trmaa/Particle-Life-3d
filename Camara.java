public class Camara {
    public static vec3 position = new vec3(25, 25, -400);
    public static vec2 angle = new vec2(Math.PI * 0.5, Math.PI * 0.5);

    public static int far = 10000;
    public static float near = 0.1f;

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
            Camara.position.x += Math.cos(Camara.angle.y) * 40;
            Camara.position.z += Math.sin(Camara.angle.y) * 40;
        }
        if (MyKeyListener.S) {
            Camara.position.x -= Math.cos(Camara.angle.y) * 40;
            Camara.position.z -= Math.sin(Camara.angle.y) * 40;
        }
        if (MyKeyListener.A) {
            Camara.position.x += Math.cos(Camara.angle.y + Math.PI * 0.5) * 40;
            Camara.position.z += Math.sin(Camara.angle.y + Math.PI * 0.5) * 40;
        }
        if (MyKeyListener.D) {
            Camara.position.x -= Math.cos(Camara.angle.y + Math.PI * 0.5) * 40;
            Camara.position.z -= Math.sin(Camara.angle.y + Math.PI * 0.5) * 40;
        }
    }

    public static double distance(vec3 point) {
        return Math.sqrt(
                Math.pow(point.x - Camara.position.x, 2) +
                        Math.pow(point.y - Camara.position.y, 2) +
                        Math.pow(point.z - Camara.position.z, 2));
    }

    public static vec3 translete(vec3 point) {
        // para angulo y (x,z)
        double a = Math.atan2(point.x - Camara.position.x, point.z - Camara.position.z);
        double b = (180 - (a * 180 / Math.PI) - 90) * Math.PI / 180;
        double c = (Camara.angle.y - Math.PI * 0.5) - b;

        double h = Math.sqrt(Math.pow(point.x - Camara.position.x, 2) + Math.pow(point.z - Camara.position.z, 2));

        // para angulo x (y)
        double d = Math.atan2(point.x - Camara.position.x, point.y - Camara.position.y);
        double e = (180 - (d * 180 / Math.PI) - 90) * Math.PI / 180;
        double f = (Camara.angle.x - Math.PI * 0.5) - e;

        double i = Math.sqrt(Math.pow(point.x - Camara.position.x, 2) + Math.pow(point.y - Camara.position.y, 2));

        return new vec3(
                Math.cos(c) * h,
                Math.sin(f) * i,
                Math.sin(c) * h);
    }

    public static vec2 project(vec3 point) {
        vec3 p = Camara.translete(point);
        if (p.z <= 0)
            return new vec2(
                    p.x * (Camara.far / Camara.distance(point) * Camara.near),
                    p.y * (Camara.far / Camara.distance(point) * Camara.near));
        else
            return new vec2(1000, 1000);
    }
}

class Obj {
    vec3[] points = new vec3[1000];

    Obj() {
        for (int i = 0; i < 1000; i++) {
            this.points[i] = new vec3(Math.random() * 10000 - 5000, Math.random() * 10000 - 5000,
                    Math.random() * 10000 - 5000);
        }
    }
}