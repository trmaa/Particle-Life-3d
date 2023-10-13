import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    public static boolean UP = false;
    public static boolean DOWN = false;
    public static boolean LEFT = false;
    public static boolean RIGHT = false;

    public static boolean W = false;
    public static boolean A = false;
    public static boolean S = false;
    public static boolean D = false;

    public static boolean E = false;
    public static boolean Q = false;

    @Override
    public void keyPressed(KeyEvent e) {
        MyKeyListener.UP = e.getKeyCode() == KeyEvent.VK_UP ? true : MyKeyListener.UP;
        MyKeyListener.DOWN = e.getKeyCode() == KeyEvent.VK_DOWN ? true : MyKeyListener.DOWN;
        MyKeyListener.LEFT = e.getKeyCode() == KeyEvent.VK_LEFT ? true : MyKeyListener.LEFT;
        MyKeyListener.RIGHT = e.getKeyCode() == KeyEvent.VK_RIGHT ? true : MyKeyListener.RIGHT;

        MyKeyListener.W = e.getKeyCode() == KeyEvent.VK_W ? true : MyKeyListener.W;
        MyKeyListener.A = e.getKeyCode() == KeyEvent.VK_A ? true : MyKeyListener.A;
        MyKeyListener.S = e.getKeyCode() == KeyEvent.VK_S ? true : MyKeyListener.S;
        MyKeyListener.D = e.getKeyCode() == KeyEvent.VK_D ? true : MyKeyListener.D;

        MyKeyListener.E = e.getKeyCode() == KeyEvent.VK_E ? true : MyKeyListener.E;
        MyKeyListener.Q = e.getKeyCode() == KeyEvent.VK_Q ? true : MyKeyListener.Q;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        MyKeyListener.UP = e.getKeyCode() == KeyEvent.VK_UP ? false : MyKeyListener.UP;
        MyKeyListener.DOWN = e.getKeyCode() == KeyEvent.VK_DOWN ? false : MyKeyListener.DOWN;
        MyKeyListener.LEFT = e.getKeyCode() == KeyEvent.VK_LEFT ? false : MyKeyListener.LEFT;
        MyKeyListener.RIGHT = e.getKeyCode() == KeyEvent.VK_RIGHT ? false : MyKeyListener.RIGHT;

        MyKeyListener.W = e.getKeyCode() == KeyEvent.VK_W ? false : MyKeyListener.W;
        MyKeyListener.A = e.getKeyCode() == KeyEvent.VK_A ? false : MyKeyListener.A;
        MyKeyListener.S = e.getKeyCode() == KeyEvent.VK_S ? false : MyKeyListener.S;
        MyKeyListener.D = e.getKeyCode() == KeyEvent.VK_D ? false : MyKeyListener.D;

        MyKeyListener.E = e.getKeyCode() == KeyEvent.VK_E ? false : MyKeyListener.E;
        MyKeyListener.Q = e.getKeyCode() == KeyEvent.VK_Q ? false : MyKeyListener.Q;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
