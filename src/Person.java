public class Person {
    protected String name;
    protected String personId;

    public Person(String name, String personId) {
        this.name = name;
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + "(CPF:" + this.personId + ")";
    }
}
