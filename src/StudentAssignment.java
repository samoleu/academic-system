public class StudentAssignment {
    private Student student;
    private double grade;
    private Date deliveryTime;
    private int runTime;

    public StudentAssignment(Student student, double grade, Date deliveryTime, int runTime) {
        this.student = student;
        this.grade = grade;
        this.deliveryTime = deliveryTime;
        this.runTime = runTime;
    }

    public double getGrade() {
        return this.grade;
    }

    public double totalGrade(Date deadline, int expectedTime, double maximumGrade) {
        if (this.deliveryTime.posterior(deadline)) {
            this.grade = this.grade * 0.8;
            return this.grade;
        } else {
            if (this.grade == maximumGrade && this.runTime <= expectedTime) {
                this.grade += 2;
                return this.grade;
            }
        }
        return grade;
    }
}
