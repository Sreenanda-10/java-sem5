import java.awt.*;
import java.awt.event.*;

public class StudentPerformance extends Frame implements ActionListener {

    TextField nameField, mark1Field, mark2Field, mark3Field;
    Button totalButton, averageButton, clearButton;
    TextArea result;

    StudentPerformance() {

        setTitle("Student Performance Management");
        setSize(500, 400);
        setLayout(new BorderLayout(10, 10));

        Panel form = new Panel(new GridLayout(4, 2, 10, 10));

        form.add(new Label("Student Name:"));
        nameField = new TextField();
        form.add(nameField);

        form.add(new Label("Mark 1:"));
        mark1Field = new TextField();
        form.add(mark1Field);

        form.add(new Label("Mark 2:"));
        mark2Field = new TextField();
        form.add(mark2Field);

        form.add(new Label("Mark 3:"));
        mark3Field = new TextField();
        form.add(mark3Field);

        Panel buttons = new Panel();

        totalButton = new Button("Calculate Total");
        averageButton = new Button("Calculate Average");
        clearButton = new Button("Clear");

        buttons.add(totalButton);
        buttons.add(averageButton);
        buttons.add(clearButton);

        result = new TextArea();
        result.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
        add(result, BorderLayout.SOUTH);

        totalButton.addActionListener(this);
        averageButton.addActionListener(this);
        clearButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == totalButton ||
            e.getSource() == averageButton) {

            try {
                String name = nameField.getText();

                double mark1 =
                    Double.parseDouble(mark1Field.getText());

                double mark2 =
                    Double.parseDouble(mark2Field.getText());

                double mark3 =
                    Double.parseDouble(mark3Field.getText());

                double total = mark1 + mark2 + mark3;
                double average = total / 3;

                if (e.getSource() == totalButton) {
                    result.setText(
                        "Student Name: " + name +
                        "\nTotal Marks: " + total
                    );
                }

                else {
                    result.setText(
                        "Student Name: " + name +
                        "\nAverage Marks: " + average
                    );
                }

            } catch (NumberFormatException ex) {
                result.setText("Please enter valid marks.");
            }
        }

        else if (e.getSource() == clearButton) {

            nameField.setText("");
            mark1Field.setText("");
            mark2Field.setText("");
            mark3Field.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}
