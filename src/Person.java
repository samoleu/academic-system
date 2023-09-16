public class Person {
    protected String name;
    protected String personId;

    public String toString() {
        return this.name + "(CPF:" + this.personId + ")";
    }
}
