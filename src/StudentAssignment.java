public class StudentAssignment {
    private Student student;
    private double grade;
    private Date deliveryTime;
    private int runTime;

    public double totalGrade(Date deadline, int expectedTime, double maximumGrade) {
        if (deliveryTime.posterior(deadline)) {
            grade = maximumGrade * 0.8;
        } else {
            if (grade == maximumGrade && runTime <= expectedTime) {
                grade += 2;
            }
        }
        return maximumGrade;
    }

}
