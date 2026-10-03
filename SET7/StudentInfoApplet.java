import java.applet.Applet;
import java.awt.Graphics;

public class StudentInfoApplet extends Applet {

    String name;
    String registerNo;
    String course;
    String semester;

    public void init() {
        name = getParameter("name");
        registerNo = getParameter("registerNo");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    public void paint(Graphics g) {
        g.drawString("Student Information", 50, 50);
        g.drawString("Name: " + name, 50, 80);
        g.drawString("Register Number: " + registerNo, 50, 110);
        g.drawString("Course: " + course, 50, 140);
        g.drawString("Semester: " + semester, 50, 170);
    }
}
