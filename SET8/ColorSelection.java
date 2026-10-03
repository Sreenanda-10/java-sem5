import java.awt.*;
import java.awt.event.*;

public class ColorSelection extends Frame implements ActionListener {

    Button redButton, greenButton, blueButton;
    Panel colorPanel;

    ColorSelection() {

        setTitle("Color Selection");
        setSize(500, 300);
        setLayout(new BorderLayout());

        colorPanel = new Panel();
        colorPanel.setLayout(new FlowLayout());

        redButton = new Button("Red");
        greenButton = new Button("Green");
        blueButton = new Button("Blue");

        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(blueButton);

        add(colorPanel, BorderLayout.NORTH);

        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == redButton) {
            colorPanel.setBackground(Color.RED);
        }
        else if (e.getSource() == greenButton) {
            colorPanel.setBackground(Color.GREEN);
        }
        else if (e.getSource() == blueButton) {
            colorPanel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new ColorSelection();
    }
}
