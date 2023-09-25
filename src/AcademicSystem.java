public class AcademicSystem {

    private int quantityProfessor = 0;
    private int quantityStudents = 0;
    private Professor[] professors = new Professor[100];
    private Student[] students = new Student[1000];

    void newProfessor(Professor professor) {
        professors[this.quantityProfessor] = professor;
        quantityProfessor += 1;
    }

    void newStudent(Student student) {
        students[this.quantityStudents] = student;
        quantityStudents += 1;
    }

    Professor findProfessor(String registration) {
        if (quantityProfessor == 0) {
            return null;
        }
        for (int i=0; i < quantityProfessor; i++) {
            if (professors[i].getPersonId().equals(registration)) {
                return professors[i];
            }
        }
        return null;
    }

    Student findStudent(String registration) {
        if (quantityStudents == 0) {
            return null;
        }
        for (int i = 0; i < quantityStudents; i++) {
            if (students[i].getRegistration().equals(registration)) {
                return students[i];
            }
        }
        return null;
    }

    void listProfessor() {
        if (quantityProfessor == 0) {
            System.out.println("There are no professors registered");
            return;
        } else {
            for (int i=0; i < quantityProfessor; i++) {
                System.out.println(professors[i].toString());
            }
        }
    }

    void listStudent() {
        if (quantityStudents == 0) {
            System.out.println("There are no students registered");
            return;
        } else {
            for (int i=0; i < quantityStudents; i++) {
                System.out.println(students[i].toString());
            }
        }
    }

}
