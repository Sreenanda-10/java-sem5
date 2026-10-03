interface Sports {

    void showSports();
}

interface Academics {

    void showAcademics();
}

class Student implements Sports, Academics {

    public void showSports() {
        System.out.println("Sports: Football");
    }

    public void showAcademics() {
        System.out.println("Academics: Computer Science");
    }

    public static void main(String[] args) {

        Student s = new Student();

        s.showAcademics();
        s.showSports();
    }
}
