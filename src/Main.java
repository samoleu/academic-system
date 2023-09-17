
public class Main {
    public static void main(String[] args) {

        Professor hilario = new Professor("Hilario Fernandes", "7658", 2555.5);

        Student[] alunos = new Student[3];

        alunos[0] = new Student("Filipe Suhett", "1025", "20221BSI8594");
        alunos[1] = new Student("jhonata polito", "3568", "20221BSI3097");
        alunos[2] = new Student("Samuel Ferreira", "2974", "20221BSI1025");

        // **************************************************************************

        StudentAssignment[] notaTrabalho1 = new StudentAssignment[3];

        notaTrabalho1[0] = new StudentAssignment(alunos[0], 15.0, new Date(6,8,2009), 12);
        notaTrabalho1[1] = new StudentAssignment(alunos[1], 18.0, new Date(5,8,2009), 16);
        notaTrabalho1[2] = new StudentAssignment(alunos[2], 19.0, new Date(2,8,2009), 15);

        // **************************************************************************

        StudentExam[] notaProva1 = new StudentExam[3];

        notaProva1[0] = new StudentExam(alunos[0], new double[]{12.0, 28.0, 32.0, 8.0});
        notaProva1[1] = new StudentExam(alunos[1], new double[]{12.0, 23.0, 28.0, 12.0});
        notaProva1[2] = new StudentExam(alunos[2], new double[]{1.0, 21.0, 19.0, 11.0});


        // **************************************************************************

        Assessment[] avaliacoes = new Assessment[2];

        avaliacoes[0] = new Assignment("Trabalho 1", new Date(5,8,2009), 20.0, 15, notaTrabalho1);
        avaliacoes[1] = new Exam("Prova 1", new Date(9,9,2009), 80.0, 4, notaProva1);

        // **************************************************************************

        StudentClass javaPOO = new StudentClass("JavaPOO", 2009,2, hilario, alunos, avaliacoes);

        javaPOO.mean();

    }
}