public class Person {
    protected String name;
    protected String personId;

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public Person(String name, String personId) {
        this.name = name;
        this.personId = personId;
    }

    public String toString() {
        return this.name + "(CPF:" + this.personId + ")";
    }
}
