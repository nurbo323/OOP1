import models.School;
import models.Student;
import models.Teacher;
import java.io.*;
import java.util.*;

public class Main {
    public static List<Student> readStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean isMale = parts[3].equalsIgnoreCase("Male");
                Student student = new Student(name, surname, age, isMale);
                for (int i = 4; i < parts.length; i++) {
                    student.addGrade(Integer.parseInt(parts[i]));
                }
                students.add(student);
            }
        }
        return students;
    }

    public static List<Teacher> readTeachers(String filePath) throws IOException {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean isMale = parts[3].equalsIgnoreCase("Male");
                String subject = parts[4];
                int experience = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);
                Teacher teacher = new Teacher(name, surname, age, isMale, subject, experience, salary);
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    public static void main(String[] args) {
        try {
            School school = new School();


            List<Student> students = readStudents("students.txt");
            List<Teacher> teachers = readTeachers("teachers.txt");


            for (Student student : students) {
                school.addMember(student);
            }
            for (Teacher teacher : teachers) {
                school.addMember(teacher);
            }


            System.out.println("School members:");
            System.out.println(school);

            System.out.println("\nTeacher salary adjustments:");
            for (Teacher teacher : teachers) {
                if (teacher.yearsOfExperience > 10) {
                    teacher.giveRaise(10);
                    System.out.println(teacher + " New salary: " + teacher.getSalary());
                }
            }
            System.out.println("\nStudent GPAs:");
            for (Student student : students) {
                System.out.printf("%s's GPA: %.2f%n", student, student.calculateGPA());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
