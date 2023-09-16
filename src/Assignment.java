public class Assignment extends Assessment{
    private int expectedTime;
    private StudentAssignment[] grades;

    public double grade(int index) {
        return grades[index].getGrade();
    }
}
