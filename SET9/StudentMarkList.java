import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarkList extends JFrame implements ActionListener {

    JTextField nameField, regField, mark1Field, mark2Field, mark3Field;
    JButton calculate, clear, exit;
    JTextArea result;

    StudentMarkList() {

        setTitle("Student Mark List");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

        form.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Register Number:"));
        regField = new JTextField();
        form.add(regField);

        form.add(new JLabel("Mark 1:"));
        mark1Field = new JTextField();
        form.add(mark1Field);

        form.add(new JLabel("Mark 2:"));
        mark2Field = new JTextField();
        form.add(mark2Field);

        form.add(new JLabel("Mark 3:"));
        mark3Field = new JTextField();
        form.add(mark3Field);

        JPanel buttons = new JPanel();

        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        buttons.add(calculate);
        buttons.add(clear);
        buttons.add(exit);

        result = new JTextArea(8, 30);
        result.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
        add(new JScrollPane(result), BorderLayout.SOUTH);

        calculate.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            try {
                double mark1 =
                    Double.parseDouble(mark1Field.getText());

                double mark2 =
                    Double.parseDouble(mark2Field.getText());

                double mark3 =
                    Double.parseDouble(mark3Field.getText());

                if (mark1 < 0 || mark1 > 100 ||
                    mark2 < 0 || mark2 > 100 ||
                    mark3 < 0 || mark3 > 100) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Marks must be between 0 and 100."
                    );
                    return;
                }

                String name = nameField.getText();
                String regNo = regField.getText();

                double total = mark1 + mark2 + mark3;
                double average = total / 3;

                String grade;

                if (average >= 90)
                    grade = "A+";
                else if (average >= 80)
                    grade = "A";
                else if (average >= 70)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 50)
                    grade = "D";
                else
                    grade = "F";

                result.setText(
                    "Student Name: " + name +
                    "\nRegister Number: " + regNo +
                    "\nTotal Marks: " + total +
                    "\nAverage: " + average +
                    "\nGrade: " + grade
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid marks."
                );
            }
        }

        else if (e.getSource() == clear) {

            nameField.setText("");
            regField.setText("");
            mark1Field.setText("");
            mark2Field.setText("");
            mark3Field.setText("");
            result.setText("");
        }

        else if (e.getSource() == exit) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new StudentMarkList();
    }
}
