import java.io.*;
import java.util.ArrayList;

public class StudentManagement {
    private static StudentManagement instance;
    private ArrayList<Student> students;

    private StudentManagement() {
        students = new ArrayList<>();
    }
    public static StudentManagement getInstance() {
        if (instance == null) {
            instance = new StudentManagement();
        }
        return instance;
    }
    public void addStudent(String id, String name, String grade){
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student already exists");
                return;
            }
        }
        students.add(new Student(id, name, grade));
        System.out.println("Student added");

    }
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
           
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());

                writer.newLine();

            }
            System.out.println("Students saved to file.");
        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }
    public void loadFromFile(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            students.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3){
                    addStudent(parts[0], parts[1], parts[2]);
                }
            }
            System.out.println("Student loaded from file.");
        } catch (IOException e){
            System.out.println("Error while loading file" + e.getMessage());
        }
    }
    public void displayAllStudents(){
        if (students.isEmpty()){
            System.out.println("Nothing to show");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    public void searchStudent(String id){
        for (Student student : students) {
            if (student.getId().equals(id)){
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found");
    }
    public void displayFileContents(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("\n--- Contents of " + filename + " ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}
