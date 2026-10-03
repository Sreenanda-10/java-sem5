interface Printable {
    void print();
}

class Student implements Printable {
    public void print() {
        System.out.println("Student Name: Sreenanda");
        System.out.println("Roll No: 101");
    }
}

class Teacher implements Printable {
    public void print() {
        System.out.println("Teacher Name: Anu");
        System.out.println("Subject: Java");
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Student s = new Student();
        Teacher t = new Teacher();

        s.print();
        t.print();
    }
}
