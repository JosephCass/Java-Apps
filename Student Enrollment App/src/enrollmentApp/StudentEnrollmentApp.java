package enrollmentApp;

import java.util.Scanner;

public class StudentEnrollmentApp {

	public static void main(String[] args) {
		askHowManyStudent();
	}

	public static void askHowManyStudent() {
		System.out.println("How many student do you want to add");
		Scanner scan = new Scanner(System.in);
		int studentsAmount = scan.nextInt();
		Student[] students = new Student[studentsAmount];
		for(int n = 0; n < studentsAmount; n++) {
			students[n] = new Student();
		}
		for(Student stu : students) {
			System.out.println(stu);
		}
	}
	
	
}