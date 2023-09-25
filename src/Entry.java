import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Entry {
    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scane vai ler da entrada padrão (teclado)
     */
    public Entry() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar Student:\n" +
                "3) Cadastrar StudentClass:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Professor e cadastra-o no AcademicSystem.
     * @param s: Um objeto da classe AcademicSystem
     */
    public void cadProf(AcademicSystem s) {
        s.listProfessor();

        String nome = this.lerLinha("Digite o nome do professor: ");
        String personID = this.lerLinha("Digite o personID do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$");

        if (s.findProfessor(personID) == null) { // Garantindo que o não personID esteja duplicado.
            Professor p = new Professor(nome, personID, salario);
            s.newProfessor(p);
        }
        else {
            System.out.println("Erro: personID duplicado. Professor não adicionado.");
        }
    }

    /**
     * Lê os dados de um novo Student e cadastra-o no AcademicSystem.
     * @param s: Um objeto da classe AcademicSystem
     */
    public void cadStudent(AcademicSystem s) {
        s.listStudent();

        String nome = this.lerLinha("Digite o nome do Student: ");
        String personID = this.lerLinha("Digite o personID do Student: ");
        String registration = this.lerLinha("Digite a matrícula do Student: ");

        if (s.findStudent(registration) == null) { // Garantindo que a matrícula não esteja duplicada.
            Student a = new Student(nome, personID, registration);
            s.newStudent(a);
        }
        else {
            System.out.println("Erro: matrícula duplicada. Student não adicionado.");
        }
    }

    /**
     * Lê o personID de um professor e localiza-o no AcademicSystem.
     * @param s: Um objeto da classe AcademicSystem
     * @return Um objeto da classe Professor.
     */
    private Professor lerProf(AcademicSystem s) {
        s.listProfessor();

        String personID = this.lerLinha("Digite o personID do professor: ");
        Professor p = s.findProfessor(personID);

        while (p == null) {
            personID = this.lerLinha("personID inválido. Digite outro: ");
            p = s.findProfessor(personID);
        }

        return p;
    }

    /**
     * Lê um número de Students, depois a matrícula de cada Student e localiza-os no AcademicSystem.
     * @param s: Um objeto da classe AcademicSystem
     * @return Um array contendo todos os objetos da classe Student cujas matrículas foram digitadas.
     */
    private Student[] lerStudents(AcademicSystem s) {
        int nStudents = this.lerInteiro("Digite a quantidade de Students na disciplina: ");
        Student[] Students = new Student[nStudents];

        for(int i=0; i<nStudents; i++) {
            s.listStudent();

            String registration = this.lerLinha("Digite a matrícula do Student: ");
            Student a = s.findStudent(registration);

            while (a == null) {
                registration = this.lerLinha("matrícula inválida. Digite outra: ");
                a = s.findStudent(registration);
            }

            Students[i] = a;
        }

        return Students;
    }

    /**
     * Lê as notas de um Student em uma Exam.
     * @param s: Um objeto da classe AcademicSystem
     * @param a: Um objeto da classe Student
     * @param nQuestoes: Inteiro com o número de questões nesta Exam
     * @return Um objeto da classe StudentExam, com as respectivas as notas do Student em cada questão da Exam.
     */
    private StudentExam lerStudentExam(AcademicSystem s, Student a, int nQuestoes) {
        double[] notas = new double[nQuestoes];

        for (int i=0; i<nQuestoes; i++) {
            notas[i] = lerDouble("Nota de " + a.getName() + " na questão " + (i+1) + ": ");
        }

        return new StudentExam(a, notas);
    }

    /**
     * Lê os dados de uma Exam.
     * @param s: Um objeto da classe AcademicSystem
     * @param Students: Um array com todos os Students que fizeram esta Exam.
     * @return Um novo objeto da classe Exam com todos os dados que foram lidos.
     */
    private Exam lerExam(AcademicSystem s, Student[] Students) {
        String nome = this.lerLinha("Informe o nome desta Exam: ");

        int dia = this.lerInteiro("Digite o dia da Exam: ");
        int mes = this.lerInteiro("Digite o mês da Exam: ");
        int ano = this.lerInteiro("Digite o ano da Exam: ");
        Date aplic = new Date(dia, mes, ano);

        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int nQuestoes = this.lerInteiro("Digite o número de questões: ");

        StudentExam[] notas = new StudentExam[Students.length];
        for (int i = 0; i< Students.length; i++) {
            notas[i] = this.lerStudentExam(s, Students[i], nQuestoes);
        }

        return new Exam(nome, aplic, valor, nQuestoes, notas);
    }

    /**
     * Lê a avaliação que o professor fez de um Student em um Assignment.
     * @param s: Um objeto da classe AcademicSystem
     * @param a: Um objeto da classe Student
     * @return Um objeto da classe StudentAssignment com as informações lidas sobre o Student neste Assignment.
     */
    private StudentAssignment lerStudentAssignment(AcademicSystem s, Student a) {
        double nota = this.lerDouble("Nota do " + a.getName() + " no Assignment: ");

        int dia = this.lerInteiro("Digite o dia de entrega do Assignment: ");
        int mes = this.lerInteiro("Digite o mês de entrega do Assignment: ");
        int ano = this.lerInteiro("Digite o ano de entrega do Assignment: ");
        Date entrega = new Date(dia, mes, ano);

        int tempoExec = this.lerInteiro("Informe o tempo de processamento: ");

        return new StudentAssignment(a, nota, entrega, tempoExec);
    }

    /**
     * Lê os dados de um Assignment.
     * @param s: Um objeto da classe AcademicSystem
     * @param Students: Um array com todos os Students que fizeram esta Exam.
     * @return Um novo objeto da classe Assignment com todos os dados que foram lidos.
     */
    private Assignment lerAssignment(AcademicSystem s, Student[] Students) {
        String nome = this.lerLinha("Informe o nome desta avaliação: ");

        int dia = this.lerInteiro("Digite o dia do Assignment: ");
        int mes = this.lerInteiro("Digite o mês do Assignment: ");
        int ano = this.lerInteiro("Digite o ano do Assignment: ");
        Date aplic = new Date(dia, mes, ano);

        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int tempoEsp = this.lerInteiro("Digite o tempo esperado pelo professor: ");

        StudentAssignment[] notas = new StudentAssignment[Students.length];
        for (int i=0; i<Students.length; i++) {
            notas[i] = this.lerStudentAssignment(s, Students[i]);
        }

        return new Assignment(nome, aplic, valor, tempoEsp, notas);
    }

    /**
     * Lê as avaliações de uma certa disciplina.
     * @param s: Um objeto da classe AcademicSystem
     * @param Students: Um array com todos os Students que fizeram esta Exam.
     * @return Um array com todas as avaliações da disciplina.
     */
    private Assessment[] lerAvaliacoes(AcademicSystem s, Student[] Students) {
        int nAvaliacoes = this.lerInteiro("Digite a quantidade de avaliações na disciplina: ");
        Assessment[] avs = new Assessment[nAvaliacoes];

        for (int i=0; i<nAvaliacoes; i++) {
            int op = this.lerInteiro("Escolha um tipo de avaliação:\n1) Exam\n2) Assignment");

            while (op != 1 && op != 2) {
                op = this.lerInteiro("Tipo de avaliação inválida. Tente novamente: ");
            }

            if (op == 1) avs[i] = this.lerExam(s, Students);
            else avs[i] = this.lerAssignment(s, Students);
        }

        return avs;
    }

    /**
     * Lê os dados de uma StudentClass.
     * @param s: Um objeto da classe AcademicSystem
     * @return Um novo objeto da classe StudentClass com todos os dados desta StudentClass.
     */
    public StudentClass cadStudentClass(AcademicSystem s) {
        String disciplina = this.lerLinha("Digite o nome da disciplina: ");
        int ano = this.lerInteiro("Digite o ano da disciplina: ");
        int sem = this.lerInteiro("Digite o semestre da disciplina: ");

        Professor p = this.lerProf(s);
        Student[] Students = this.lerStudents(s);
        Assessment[] avs = this.lerAvaliacoes(s, Students);

        return new StudentClass(disciplina, ano, sem, p, Students, avs);

    }
}