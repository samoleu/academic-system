public class Student extends Person{

    private String registration;

    public String getRegistration() {
        return registration;
    }

    public Student(String name, String personId, String registration) {
        super(name, personId);
        this.registration = registration;
    }

    @Override
    public String toString() {
        return this.name + "(Matrícula:" + this.registration + ")";
    }
}
