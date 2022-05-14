package enrollmentApp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int studentYear;
	private int studentID;
	private String courses = "";
	private int tuitonBalance;
	private static int courseCost = 600;
	private static int id = 1000;
	
	
	public Student() {
		this.firstName = setFirstName();
		this.lastName = setLastName();
		setStudentYear();
		setStudentID();
		studentInterface();
	}
	
	public String setFirstName() {
		System.out.println("Enter Students First Name: >");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		return name;
	}
	
	public String setLastName() {
		System.out.println("Enter Students Last Name: >");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		return name;
	}
	
	public void setStudentYear() {
		do {
		System.out.println("1 for Freshman\n2 for Sophmore\n3 for Junior\n4 for Senior\nEnter Students Year >");
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
			if(!(year <= 4) || !(year >= 1)){
				System.out.println("Invalid Input");
			} else {
				this.studentYear = year;
				break;				
			}
		} while(true);
	}

	private void setStudentID() {
		this.studentID = Integer.parseInt(studentYear + "" + id);
		id++;
	}
	
 
	 public void studentEnrollment () {
		do {
			System.out.println("Enter course to enroll (Q to quit): ");
			Scanner scan = new Scanner(System.in);
			String course = scan.nextLine();
			if (!course.toLowerCase().equals("q")) {
				this.courses = this.courses + "\n " + course;
				this.tuitonBalance = this.tuitonBalance + this.courseCost;
			} else { break; }
		} while(true);
	}
	
	public void viewBalance() {
		System.out.println("Your Tuiton Balance Owed: $" + this.tuitonBalance);
		System.out.println("---------------------");
	}
	
	public void payTuiton() {
		System.out.println("Enter your payment >");
		Scanner scan = new Scanner(System.in);
		int payment = scan.nextInt();
		this.tuitonBalance = this.tuitonBalance - payment;
		System.out.println("Thankyou for your payment of $" + payment);
		viewBalance();
	}
	
	public String toString() {
		return "Student Name: " + firstName + " " + lastName + "\n" +
			   "Student ID: " + studentID + "\n" +
			   "Student Year: " + studentYear + "\n" +
			   "Enrolled Courses: " + courses + "\n" +
			   "Tuiton Balance Owed: $" + tuitonBalance + "\n ------------------------";
	}
	
	public void studentInterface() {
		do {
		System.out.println("Choose an action\n" +
				"1 to Enroll In A Course\n" +
				"2 to View Your Balance\n" +
				"3 to Pay Your Tuiton\n" +
				"4 to view Profile Summary\n" +
				"F if finished");
		System.out.println("--------------------");
		Scanner scan = new Scanner(System.in);
		String action = scan.nextLine();
		if(!action.toLowerCase().equals("f")) {
			switch(action) {
				case "1":
					studentEnrollment();
					break;
				case "2":
					viewBalance();
					break;
				case "3":
					payTuiton();
					break;
				case "4":
					System.out.println(toString());
					break;
				default:
					System.out.println("Not an option! Try Agin");
					System.out.println("---------------------");
			}
		} else { break; }
		} while(true);
	}
}
