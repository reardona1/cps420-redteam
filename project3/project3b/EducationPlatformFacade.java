package project3b;

public class EducationPlatformFacade {
	
	//method prototypes
    private AuthenticationSystem authSystem;
    private PaymentSystem paymentSystem;
    private CourseManagementSystem courseManagementSystem;
    private ContentDeliverySystem contentDeliverySystem;
    
    //Constructor
    public EducationPlatformFacade() {
        authSystem = new AuthenticationSystem();
        paymentSystem = new PaymentSystem();
        courseManagementSystem = new CourseManagementSystem();
        contentDeliverySystem = new ContentDeliverySystem();
    }

    //Creates a course and uploads provided content
    public void publishCourse(String courseInfo, String content) {

        courseManagementSystem.createCourse(courseInfo);
        
        contentDeliverySystem.uploadContent(content);
        
        System.out.println("Course published: " + courseInfo);
        System.out.println();
    }
    
    // Creates a student from given information and applies the student to the given course
    public void enrollInCourse(String courseID, String studentCredentials, String paymentDetails) {
    	
        String[] credentials = studentCredentials.split(" : ");
        String username = credentials[0];
        String password = credentials[1];
        
        authSystem.login(username, password);
        
        paymentSystem.processPayment(paymentDetails);
        
        String studentID = username;
        courseManagementSystem.enrollStudent(courseID, studentID);
        
        System.out.println("Student enrollment successful");
        System.out.println();
    }
}

//Authentication methods
class AuthenticationSystem {
    
    void login(String username, String password) {
        System.out.println("Student " + username + " logged in successfully.");
    }

    void logout(String userID) {
        System.out.println("Student " + userID + " logged out.");
    }

    void registerUser(String userInfo) {
        System.out.println("User " + userInfo + " registered successfully.");
    }
}

//Payment system methods
class PaymentSystem {
    
    void processPayment(String paymentDetails) {
        System.out.println("Payment processed: " + paymentDetails);
    }

    void refundPayment(String transactionID) {
        System.out.println("Payment refunded for transaction: " + transactionID);
    }
}

//Course management system methods
class CourseManagementSystem {

    void createCourse(String courseInfo) {
        System.out.println("Course created: " + courseInfo);
    }

    void updateCourse(String courseID, String courseInfo) {
        System.out.println("Course updated: " + courseID + " with info: " + courseInfo);
    }

    void deleteCourse(String courseID) {
        System.out.println("Course deleted: " + courseID);
    }

    void enrollStudent(String courseID, String studentID) {
        System.out.println("Student " + studentID + " enrolled in course: " + courseID);
    }
}

//Content Delivery System methods
class ContentDeliverySystem {

    void uploadContent(String content) {
        System.out.println("Content uploaded: " + content);
    }

    void streamContent(String contentID) {
        System.out.println("Streaming content: " + contentID);
    }
}
