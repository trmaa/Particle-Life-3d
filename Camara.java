public class Camara {
    public static vec3 position = new vec3(0, 0, -25000);
    public static vec2 angle = new vec2(0, Math.PI * 0.5);

    public static int far = 12800;
    public static float near = 0.1f;

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

        double h = (point.z - Camara.position.z) / Math.cos(a);

        // para angulo x (y)
        double d = Math.atan2(h, point.y - Camara.position.y);
        double e = (180 - (d * 180 / Math.PI) - 90) * Math.PI / 180;
        double f = (Camara.angle.x - Math.PI * 0.5) - e;

        double i = (point.y - Camara.position.y) / Math.cos(d);

        return new vec3(
                Math.cos(c) * h,
                Math.cos(f) * i,
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