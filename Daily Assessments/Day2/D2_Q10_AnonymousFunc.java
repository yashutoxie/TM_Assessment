/* Implementing an Anonymous Class for Sorting
Scenario:
You need to sort a list of students based on marks, but without creating a separate comparator class.
Use an anonymous inner class to implement Comparator<Student>.
Example Usage:
List<Student> students = Arrays.asList(
    new Student("Alice", 85),
    new Student("Bob", 90),
    new Student("Charlie", 78)
);
Collections.sort(students, /* Use Anonymous Class for sorting ); */
import java.util.*;

class Student {
    private String name;
    private int marks;
 
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
 
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
 
    public void display() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }
}
 
public class Main {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 90),
                new Student("Charlie", 78)
        );
 
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getMarks(), s2.getMarks());  //for descending order s2, s1.
            }
        }); 
        
        System.out.println("Students sorted by marks:");
        for (Student s : students) {
            s.display();
        }
    }
}
