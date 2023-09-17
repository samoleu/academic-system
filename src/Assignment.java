public class Assignment extends Assessment{
    private int expectedTime;
    private StudentAssignment[] grades;

    public Assignment(String name, Date dateAplication, double maximumGrade, int expectedTime, StudentAssignment[] grades) {
        super(name, dateAplication, maximumGrade);
        this.expectedTime = expectedTime;
        this.grades = grades;
    }

    public double grade(int index) {
        return grades[index].getGrade();
    }

    public double grade(String registerStudent) {
        for (StudentAssignment grade : grades) {
            if (grade.getRegistration().equals(registerStudent)) {
                return grade.getGrade();

            }
        }
        System.out.println("Aluno não encontrado!");
        return 0.0;
    }

}
