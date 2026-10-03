import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends Frame implements ActionListener {

    TextField nameField, regField;
    Choice courseChoice;
    Checkbox male, female;
    Button submit, clear;
    Label result;

    StudentRegistration() {

        setTitle("Student Registration Form");
        setSize(500, 400);
        setLayout(new BorderLayout());

        Panel form = new Panel(new GridLayout(5, 2, 10, 10));

        form.add(new Label("Name:"));
        nameField = new TextField();
        form.add(nameField);

        form.add(new Label("Register Number:"));
        regField = new TextField();
        form.add(regField);

        form.add(new Label("Course:"));
        courseChoice = new Choice();
        courseChoice.add("BCA");
        courseChoice.add("BSc Computer Science");
        courseChoice.add("MCA");
        form.add(courseChoice);

        form.add(new Label("Gender:"));
        Panel genderPanel = new Panel();

        male = new Checkbox("Male");
        female = new Checkbox("Female");

        genderPanel.add(male);
        genderPanel.add(female);
        form.add(genderPanel);

        submit = new Button("Submit");
        clear = new Button("Clear");

        form.add(submit);
        form.add(clear);

        add(form, BorderLayout.NORTH);

        result = new Label("Enter details and click Submit");
        add(result, BorderLayout.SOUTH);

        submit.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            String name = nameField.getText();
            String reg = regField.getText();
            String course = courseChoice.getSelectedItem();

            String gender = "";

            if (male.getState())
                gender = "Male";
            else if (female.getState())
                gender = "Female";

            result.setText("Name: " + name +
                    " | Reg No: " + reg +
                    " | Course: " + course +
                    " | Gender: " + gender);
        }

        if (e.getSource() == clear) {
            nameField.setText("");
            regField.setText("");
            result.setText("Enter details and click Submit");
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
