
public class Main {
    public static void main(String[] args) {
        Entry io = new Entry();
        AcademicSystem s = new AcademicSystem();

        int op = io.menu1();

        while (op != 0) {
            if (op == 1) {
                System.out.println("Entrei no cadastro do professor. Apague isso aqui depois!");
                io.cadProf(s);
            }
            if (op == 2) {
                System.out.println("Entrei no cadastro do aluno.");
                io.cadStudent(s);
            }
            if (op == 3) {
                System.out.println("Entrei no cadastro da turma.");
                StudentClass t = io.cadStudentClass(s);
                t.mean();
            }
            op = io.menu1();
        }
    }
}