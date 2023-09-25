public class StudentExam {
    private Student student;
    private double[] grades;

    public StudentExam(Student student, double[] grade) {
        this.student = student;
        this.grades = grade;
    }

    public double totalGrade() {
        double totGrade;
        int i;
        totGrade = 0.0;
        for (i = 0 ; i < grades.length; i++) {
            totGrade += grades[i];
        }
        return totGrade;
    }
}