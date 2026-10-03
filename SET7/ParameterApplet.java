import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ParameterApplet extends Applet {

    String message;
    Color backgroundColor;
    Color foregroundColor;

    public void init() {

        message = getParameter("message");

        String bg = getParameter("background");
        String fg = getParameter("foreground");

        if (bg.equalsIgnoreCase("red"))
            backgroundColor = Color.RED;
        else if (bg.equalsIgnoreCase("green"))
            backgroundColor = Color.GREEN;
        else
            backgroundColor = Color.WHITE;

        if (fg.equalsIgnoreCase("blue"))
            foregroundColor = Color.BLUE;
        else if (fg.equalsIgnoreCase("black"))
            foregroundColor = Color.BLACK;
        else
            foregroundColor = Color.BLACK;

        setBackground(backgroundColor);
        setForeground(foregroundColor);
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 80);
    }
}
