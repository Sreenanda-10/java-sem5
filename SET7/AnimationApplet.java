import java.applet.Applet;
import java.awt.Graphics;

public class AnimationApplet extends Applet implements Runnable {

    int x = 0;
    Thread animationThread;
    boolean running = false;

    public void init() {
        x = 0;
    }

    public void start() {
        if (animationThread == null) {
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void run() {
        while (running) {
            x = x + 5;

            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void stop() {
        running = false;
        animationThread = null;
    }

    public void paint(Graphics g) {
        g.drawString("Moving Circle", 50, 50);
        g.drawOval(x, 100, 50, 50);
    }
}
