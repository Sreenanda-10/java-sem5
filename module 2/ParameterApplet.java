
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ParameterApplet extends Applet {
    String message;
    Color backgroundColor;
    Color foregroundColor;

    public void init() {
        message = getParameter("message");
        if (message == null) {
            message = "Welcome";
        }

        String bg = getParameter("background");
        String fg = getParameter("foreground");

        if ("red".equals(bg))
            backgroundColor = Color.RED;
        else if ("blue".equals(bg))
            backgroundColor = Color.BLUE;
        else if ("green".equals(bg))
            backgroundColor = Color.GREEN;
        else
            backgroundColor = Color.WHITE;

        if ("red".equals(fg))
            foregroundColor = Color.RED;
        else if ("blue".equals(fg))
            foregroundColor = Color.BLUE;
        else if ("green".equals(fg))
            foregroundColor = Color.GREEN;
        else if ("white".equals(fg))
            foregroundColor = Color.WHITE;
        else
            foregroundColor = Color.BLACK;

        setBackground(backgroundColor);
        setForeground(foregroundColor);
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 100);
    }
}
