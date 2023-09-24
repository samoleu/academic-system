public class Exam extends Assessment {
    private int quantityQuestions;
    private StudentExam[] grades;

    public Exam(String name, Date dateAplication, double maximumGrade, int quantityQuestions, StudentExam[] grades) {
        super(name, dateAplication, maximumGrade);
        this.quantityQuestions = quantityQuestions;
        this.grades = grades;
    }

    public double grade(int index) {
        return grades[index].totalGrade();
    }

}