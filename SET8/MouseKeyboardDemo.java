import java.awt.*;
import java.awt.event.*;

public class MouseKeyboardDemo extends Frame {

    Label positionLabel;
    Panel panel;

    MouseKeyboardDemo() {

        setTitle("Mouse and Keyboard Events");
        setSize(500, 300);
        setLayout(new BorderLayout());

        positionLabel = new Label("Move or click the mouse. Press a key.");

        panel = new Panel();
        panel.setBackground(Color.WHITE);

        add(positionLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                positionLabel.setText(
                    "Mouse Position: X = " + e.getX()
                    + ", Y = " + e.getY()
                );
            }
        });

       
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                positionLabel.setText(
                    "Mouse Clicked at X = " + e.getX()
                    + ", Y = " + e.getY()
                );
            }
        });

        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                positionLabel.setText(
                    "Key Pressed: " + e.getKeyChar()
                );
            }
        });

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setFocusable(true);
        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args) {
        new MouseKeyboardDemo();
    }
}
