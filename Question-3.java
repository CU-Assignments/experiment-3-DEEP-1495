
//Deep sinha 22BCS12580
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollmentSystem {
    private static final int MAX_ENROLLMENT = 2;
    private static int enrolledStudents = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();
            
            System.out.print("Have you completed Core Java? (true/false): ");
            boolean prerequisiteCompleted = scanner.nextBoolean();
            
            if (!prerequisiteCompleted) {
                throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete Core Java before enrolling in " + course + ".");
            }

            if (enrolledStudents >= MAX_ENROLLMENT) {
                throw new CourseFullException("Error: CourseFullException - Enrollment limit reached for " + course + ".");
            }
            
            enrolledStudents++;
            System.out.println("Enrollment successful for " + course + "!");
        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid details.");
        } finally {
            System.out.println("Total Enrolled Students: " + enrolledStudents);
            scanner.close();
        }
    }
}
