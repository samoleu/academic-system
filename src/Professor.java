public class Professor extends Person{
    private double salary;

    public Professor(String name, String personId, double salary) {
        super(name, personId);
        this.salary = salary;
    }
}
