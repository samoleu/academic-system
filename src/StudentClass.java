public class StudentClass {
    private String name;
    private int year;
    private int semester;
    private Professor professor;
    private Student[] students;
    private Assessment[] assessments;

    public StudentClass(String name, int year, int semester, Professor professor, Student[] students, Assessment[] assessments) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.professor = professor;
        this.students = students;
        this.assessments = assessments;
    }

    // sum grades of all assessments
    private double sumGrade(double[] gradesStudent) {
        double mean = 0.0;
        for (double score : gradesStudent) {
            mean += score;
        }
        if (mean <= 100) { return mean; }
        else return 100;
    }

    public void mean() {

        double meanClass = 0.0; // receive and save grades of a student
        System.out.println("Médias da Turma" + name + "(" + year + "/" + semester + "):");

        for (Student student : students) {
            double[] gradeStudent = new double[assessments.length]; // list of grade of a student
            System.out.print(student.toString() + ": ");

            for (int e = 0; e < assessments.length; e++) {
                gradeStudent[e] = assessments[e].grade(student.getRegistration());
                System.out.print(gradeStudent[e] + " ");
            }

            double sumGrade = sumGrade(gradeStudent);
            System.out.println("= " + sumGrade);
            meanClass += sumGrade;
        }
        System.out.printf("Média da turma: %.1f", meanClass/students.length);
    }
}