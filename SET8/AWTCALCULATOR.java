import java.awt.*;
import java.awt.event.*;

public class AWTCALCULATOR extends Frame implements ActionListener {

    TextField num1, num2, result;
    Button add, sub, mul, div;

    AWTCALCULATOR() {

        setTitle("AWT Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new Label("First Number:"));
        num1 = new TextField();
        add(num1);

        add(new Label("Second Number:"));
        num2 = new TextField();
        add(num2);

        add = new Button("Addition");
        sub = new Button("Subtraction");
        mul = new Button("Multiplication");
        div = new Button("Division");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double answer = 0;

            if (e.getSource() == add)
                answer = a + b;

            else if (e.getSource() == sub)
                answer = a - b;

            else if (e.getSource() == mul)
                answer = a * b;

            else if (e.getSource() == div) {

                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }

                answer = a / b;
            }

            result.setText(String.valueOf(answer));

        } catch (NumberFormatException ex) {
            result.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new AWTCALCULATOR();
    }
}
