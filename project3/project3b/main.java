package project3b;

//This file was taken as an example runner file from the project description
//In order to run the code, simply run the main function in "client.java"

public class main {
	
	public static void main (String [] args) {
		EducationPlatformFacade platform = new EducationPlatformFacade();
		// Publish a new course
		String courseInfo = "Java Programming" ;
		String content = "Course content for Java Programming" ;
		platform . publishCourse ( courseInfo , content );
		// Enroll a student in a course
		String courseID = "COURSE001" ;
		String studentCredentials = "studentUser : studentPass" ;
		String paymentDetails = "CreditCardInfo" ;
		platform . enrollInCourse ( courseID , studentCredentials , paymentDetails );
	}
}
