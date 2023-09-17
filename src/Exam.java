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

    public double grade(String registerStudent) {
        for (StudentExam grade : grades) {
            if (grade.getRegistration().equals(registerStudent)) {
                return grade.totalGrade();

            }
        }
        System.out.println("Aluno não encontrado!");
        return 0.0;
    }
}