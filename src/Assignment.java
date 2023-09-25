public class Assignment extends Assessment{
    private int expectedTime;
    private StudentAssignment[] grades;

    public Assignment(String name, Date dateAplication, double maximumGrade, int expectedTime, StudentAssignment[] grades) {
        super(name, dateAplication, maximumGrade);
        this.expectedTime = expectedTime;
        this.grades = grades;
    }

    public double grade(int index) {

        Date deadline = getDateAplication();

        return grades[index].totalGrade(deadline, this.expectedTime , maximumGrade);
    }

}
