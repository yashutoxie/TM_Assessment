import java.util.*;

class Course implements Comparable<Course> {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public int compareTo(Course other) {
        return this.courseName.compareToIgnoreCase(other.courseName);
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}

public class D5_Q4_CourseEnrollment{
    private LinkedList<Course> courseList = new LinkedList<>();

    public void enrollCourse(Course course) {
        courseList.add(course);
        System.out.println("Enrolled in course: " + course);
    }

    public void displayCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No Courses enrolled.");
            return;
        }
        System.out.println("Enrolled Courses: ");
        for (Course course : courseList) {
            System.out.print(course);
        }
    }

    public void dropCourse(String courseCode) {
        Iterator<Course> iterator = courseList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                iterator.remove();
                System.out.println("Dropped course: " + course);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Course not found: " + courseCode);
        }
    }

    public void navigateCourses() {
        ListIterator<Course> iterator = courseList.listIterator();

        System.out.println("\nForward Navigation: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nBackward Navigation: ");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public void sortCourses() {
        Collections.sort(courseList);
        System.out.println("\nCourses Sorted Alphabetically: ");
        displayCourses();
    }

    public static void main(String[] args) {
        D5_Q4_CourseEnrollment es = new D5_Q4_CourseEnrollment();
        es.enrollCourse(new Course("CS101", "Introduction to Programming"));
        es.enrollCourse(new Course("MA202", "Linear Algebra"));
        es.enrollCourse(new Course("PH301", "Quantum Physics"));
        es.enrollCourse(new Course("CS102", "Data Structures"));

        System.out.println("\nInitial Course List:");
        es.displayCourses();

        System.out.println("\nDropping Course: CS101");
        es.dropCourse("s101");

        es.displayCourses();
        es.navigateCourses();
        es.sortCourses();
    }
}
