package project3b;

//mostly taken from the example runner class

public class Client {

	public static void main(String[] args) {
        EducationPlatformFacade platform = new EducationPlatformFacade();
        
        System.out.println("Creating a course:\n");
        
        String courseInfo = "Java Programming";
        String content = "Course content for Java Programming";
        System.out.println("Client: Publishing new course...");
        platform.publishCourse(courseInfo, content);

        System.out.println("Adding a student to a course:\n");
        
        String courseID = "CPS420";
        String studentCredentials = "SmithJ1 : password1";
        String paymentDetails = "1234-567-890";
        System.out.println("Client: Enrolling student in course...");
        platform.enrollInCourse(courseID, studentCredentials, paymentDetails);
    }
}
