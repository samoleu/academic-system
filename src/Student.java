public class Student extends Person{
    private String registration;

    @Override
    public String toString() {
        return this.name + "(Person ID:" + this.registration + ")";
    }
}
