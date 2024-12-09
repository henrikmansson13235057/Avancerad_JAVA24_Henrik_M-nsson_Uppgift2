import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement sms = StudentManagement.getInstance();
        String filename = "students.txt";

        while(true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Save to file");
            System.out.println("3. Load from file");
            System.out.println("4. Search for student ID");
            System.out.println("5. Display all students");
            System.out.println("6. display file contents");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 -> {
                    System.out.println("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.println("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter student grade: ");
                    String grade = sc.nextLine();
                    sms.addStudent(id, name, grade);
                }
                case 2 -> sms.saveToFile(filename);
                case 3 -> sms.loadFromFile(filename);
                case 4 -> {
                    System.out.println("Enter student ID to search: ");
                    String id = sc.nextLine();
                    sms.searchStudent(id);
                }
                case 5 -> sms.displayAllStudents();
                case 6 -> sms.displayFileContents(filename);
                case 7 -> {
                    System.out.println("Exiting program... ");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }

        }
    }
}