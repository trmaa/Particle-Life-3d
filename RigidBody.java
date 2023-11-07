public class RigidBody {
	public void force(Particle o, Particle obj) {
		vec3 dif = new vec3(o.position.x - obj.position.x, o.position.y - obj.position.y,
				o.position.z - obj.position.z);
		vec2 angle = new vec2(
				Math.atan2(dif.y, Math.sqrt(Math.pow(dif.x, 2) + Math.pow(dif.z, 2))),
				Math.atan2(dif.z, dif.x));

		// o.speed = -obj.g * 1 / dif.magnitude();
		o.speed = -obj.g*Camara.far*0.3/dif.magnitude();

		o.velocity.add(new vec3(
				Math.cos(angle.y) * Math.cos(angle.x) * o.speed,
				Math.sin(angle.x) * o.speed,
				Math.sin(angle.y) * Math.cos(angle.x) * o.speed));

		o.angle = new vec2(angle.x,angle.y);
	}
}
