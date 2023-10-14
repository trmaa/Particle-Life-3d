public class Utils {
    public static int redondear(double n) {
        int res = 0;
        while (n >= 1 || n <= -1) {
            n += n > 0 ? -1 : 1;
            res += n < 0 ? -1 : 1;
        }
        res += n > 0.5 ? 1 : 0;
        return res;
    }
}

class vec3 {
    double x;
    double y;
    double z;

    vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    void add(vec3 vector) {
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
    }
}

class vec2 {
    double x;
    double y;

    vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    void add(vec2 vector) {
        this.x += vector.x;
        this.y += vector.y;
    }
}