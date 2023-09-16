public class Student extends Person{
    private String registration;

    @Override
    public String toString() {
        return this.name + "(Matrícula:" + this.registration + ")";
    }
}
