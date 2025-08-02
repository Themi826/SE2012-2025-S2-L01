import java.util.*;

public class Marks {
    static Scanner sc = new Scanner(System.in);
    static int n; // number of students
    static int[][] marks; // marks[i][j]: i = studentID - 1, j = 0=Math, 1=Chem, 2=Physics

    public static void main(String[] args) {
        System.out.print("Enter number of students: ");
        n = sc.nextInt();
        marks = new int[n][3]; // initialize 2D array

        String command;
        sc.nextLine(); // consume newline

        while (true) {
            System.out.print("\nEnter command: ");
            command = sc.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "add":
                    addStudentMarks(Integer.parseInt(parts[1]));
                    break;
                case "update":
                    updateStudentMark(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                case "average_s":
                    studentAverage(Integer.parseInt(parts[1]));
                    break;
                case "average":
                    subjectAverage(Integer.parseInt(parts[1]));
                    break;
                case "total":
                    studentTotal(Integer.parseInt(parts[1]));
                    break;
                case "grades":
                    displayGrades();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    static void addStudentMarks(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        System.out.println("Enter marks for Student " + id);
        System.out.print("Mathematics: ");
        marks[id - 1][0] = sc.nextInt();
        System.out.print("Chemistry: ");
        marks[id - 1][1] = sc.nextInt();
        System.out.print("Physics: ");
        marks[id - 1][2] = sc.nextInt();
        sc.nextLine(); // consume newline
    }

    static void updateStudentMark(int id, int subjectId) {
        if (id < 1 || id > n || subjectId < 1 || subjectId > 3) {
            System.out.println("Invalid ID.");
            return;
        }
        System.out.print("Enter new mark: ");
        marks[id - 1][subjectId - 1] = sc.nextInt();
        sc.nextLine();
    }

    static void studentAverage(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        int total = 0;
        for (int j = 0; j < 3; j++) total += marks[id - 1][j];
        System.out.println("Student " + id + " average: " + (total / 3.0));
    }

    static void subjectAverage(int subjectId) {
        if (subjectId < 1 || subjectId > 3) {
            System.out.println("Invalid subject ID.");
            return;
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += marks[i][subjectId - 1];
        }
        System.out.println("Subject " + subjectId + " average: " + (sum / n));
    }

    static void studentTotal(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        int total = 0;
        for (int j = 0; j < 3; j++) total += marks[id - 1][j];
        System.out.println("Student " + id + " total: " + total);
    }

    static void displayGrades() {
        System.out.println("\nGrades Summary:");
        System.out.printf("%-10s%-12s%-12s%-12s\n", "Student", "Math", "Chemistry", "Physics");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s", "Student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.printf("%-12s", getGrade(marks[i][j]));
            }
            System.out.println();
        }
    }

    static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Fail";
    }
}
