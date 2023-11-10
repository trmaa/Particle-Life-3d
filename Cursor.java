public class Cursor{
  public static vec3 position = new vec3(0,0,0);
  public static vec3 vertex = new vec3(0,0,0);

  public static void update(){
    Cursor.position = new vec3(
      Camara.position.x+Math.cos(Camara.angle.y)*Math.cos(Camara.angle.x)*1000,
      Camara.position.y+Math.sin(Camara.angle.x)*1000,
      Camara.position.z+Math.sin(Camara.angle.y)*Math.cos(Camara.angle.x)*1000
    );

    Cursor.vertex = new vec3(
      Cursor.position.x+50,
      Cursor.position.y+50,
      Cursor.position.z+50
    );
  }
}
