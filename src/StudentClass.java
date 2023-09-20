public class StudentClass {
    private String name;
    private int year;
    private int semester;
    private Professor professor;
    private Student[] students;
    private Assessment[] assessments;

    public StudentClass(String name, int year, int semester, Professor professor, Student[] students, Assessment[] assessments) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.professor = professor;
        this.students = students;
        this.assessments = assessments;
    }

    // sum grades of all assessments
    private double sumGrade(double[] gradesStudent) {
        double mean = 0.0;
        for (double score : gradesStudent) {
            mean += score;
        }
        if (mean <= 100) { return mean; }
        else return 100;
    }

    public void mean() {
        double meanClass = 0.0; // receive and save grades of a student
        System.out.println("Médias da Turma" + name + "(" + year + "/" + semester + "):");

        for(int indexStudent=0; indexStudent< students.length; indexStudent++) {

            System.out.print(students[indexStudent].toString() + ": ");
            double sumGradeStudent = 0.0;

            for(int indexAssessment=0; indexAssessment < assessments.length; indexAssessment++) {
                double gradeStudent = assessments[indexAssessment].grade(indexStudent);

                System.out.print(" " + gradeStudent);
                sumGradeStudent += gradeStudent;
            }
            if (sumGradeStudent <= 100) {
                System.out.println(" = " + sumGradeStudent);
                meanClass += sumGradeStudent;
            }
            else {
                System.out.println(" = " + 100);
                meanClass += 100;
            }
        }
        System.out.printf("Média da turma: %.2f", meanClass/students.length);
    }





    /*public void mean() {

        double meanClass = 0.0; // receive and save grades of a student
        System.out.println("Médias da Turma" + name + "(" + year + "/" + semester + "):");

        for (Student student : students) {
            double[] gradeStudent = new double[assessments.length]; // list of grade of a student
            System.out.print(student.toString() + ": ");

            for (int e = 0; e < assessments.length; e++) {
                gradeStudent[e] = assessments[e].grade(student.getRegistration());
                System.out.print(gradeStudent[e] + " ");
            }

            double sumGrade = sumGrade(gradeStudent);
            System.out.println("= " + sumGrade);
            meanClass += sumGrade;
        }
        System.out.printf("Média da turma: %.1f", meanClass/students.length);
    }*/
}