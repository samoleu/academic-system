
public class Main {
    public static void main(String[] args) {

        Professor hilario = new Professor("Hilario Fernandes", "7658", 2555.5);

        Student[] alunos = new Student[4];

        alunos[0] = new Student("Filipe Suhett", "1025", "20221BSI8594");
        alunos[1] = new Student("jhonata polito", "3568", "20221BSI3097");
        alunos[2] = new Student("Samuel Ferreira", "2974", "20221BSI1025");
        alunos[3] = new Student("Erick Komati", "2574", "20121BSI1825");

        // **************************************************************************

        StudentAssignment[] notaTrabalho1 = new StudentAssignment[4];

        notaTrabalho1[0] = new StudentAssignment(alunos[0], 30.0, new Date(6,8,2009), 12);
        notaTrabalho1[1] = new StudentAssignment(alunos[1], 24.0, new Date(5,8,2009), 16);
        notaTrabalho1[2] = new StudentAssignment(alunos[2], 30.0, new Date(2,8,2009), 15);
        notaTrabalho1[3] = new StudentAssignment(alunos[3], 25.0, new Date(2,8,2009), 15);

        StudentAssignment[] notaTrabalho2 = new StudentAssignment[4];

        notaTrabalho2[0] = new StudentAssignment(alunos[0], 32.0, new Date(6,8,2009), 12);
        notaTrabalho2[1] = new StudentAssignment(alunos[1], 40.0, new Date(5,8,2009), 16);
        notaTrabalho2[2] = new StudentAssignment(alunos[2], 42.0, new Date(2,8,2009), 15);
        notaTrabalho2[3] = new StudentAssignment(alunos[3], 30.0, new Date(2,8,2009), 15);

        StudentAssignment[] notaTrabalho3 = new StudentAssignment[4];

        notaTrabalho3[0] = new StudentAssignment(alunos[0], 0.0, new Date(6,8,2009), 12);
        notaTrabalho3[1] = new StudentAssignment(alunos[1], 3.0, new Date(5,8,2009), 16);
        notaTrabalho3[2] = new StudentAssignment(alunos[2], 30.0, new Date(2,8,2009), 15);
        notaTrabalho3[3] = new StudentAssignment(alunos[2], 9.0, new Date(2,8,2009), 15);


        // **************************************************************************

        Assessment[] avaliacoes = new Assessment[3];

        avaliacoes[0] = new Assignment("Trabalho 1", new Date(5,8,2009), 30.0, 15, notaTrabalho1);
        avaliacoes[1] = new Assignment("Trabalho 1", new Date(8,8,2009), 42.0, 15, notaTrabalho2);
        avaliacoes[2] = new Assignment("Trabalho 1", new Date(12,8,2009), 20.0, 15, notaTrabalho3);

        // **************************************************************************

        StudentClass javaPOO = new StudentClass("JavaPOO", 2009,2, hilario, alunos, avaliacoes);

        javaPOO.mean();

    }
}