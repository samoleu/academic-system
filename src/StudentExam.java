public class StudentExam {
    private Student student;
    private double[] grade;

    public StudentExam(Student student, double[] grade) {
        this.student = student;
        this.grade = grade;
    }

    public double totalGrade() {
        double totGrade;
        int i;
        totGrade = 0.0;
        for (i = 0 ; i < grade.length; i++) {
            totGrade += grade[i];
        }
        return totGrade;
    }
}