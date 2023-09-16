public class Exam extends Assessment{
    private int quantityQuestions;
    private StudentExam[] grades;

    public double grade(int index) {
        return grades[index].totalGrade();
    }

}
