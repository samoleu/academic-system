public class StudentClass {
    private String name;
    private int year;
    private int semester;
    private Professor professor;
    private Student[] students;
    private Assessment[] assessments;

    public void mean() {
        System.out.println("Médias da Turma" + name + "(" + year + "/" + semester + "):");

    /*    for(int i=0; i < students.length; i++) {
            System.out.println(students[i].toString() + ": ");
        }*/
    }
}
