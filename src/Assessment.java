public class Assessment {
    protected String name;
    protected Date dateAplication;
    protected double maximumGrade;

    public Date getDateAplication() {
        return this.dateAplication;
    }

    public Assessment(String name, Date dateAplication, double maximumGrade) {
        this.name = name;
        this.dateAplication = dateAplication;
        this.maximumGrade = maximumGrade;
    }

    public double grade(int index) {
        return 0.0;
    }

}
