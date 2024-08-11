import java.util.Scanner;
class Student {
    private String name,rollNo,grade,contactNo,dOB,email;
    public Student(String name,String rollNo,String grade,String contactNo,String dOB,String email) {
        this.name=name;
        this.rollNo=rollNo;
        this.grade=grade;
        this.contactNo=contactNo;
        this.dOB=dOB;
        this.email=email;
    }
    public String getRollNo() {
        return rollNo;
    }
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNo + ", Grade: " + grade +
               ", Contact Number: " + contactNo + ", DOB: " + dOB + ", Email: " + email;
    }
}
class StudentManagementSystem {
    private Student[] students;
    private int studentCount;
    public StudentManagementSystem() {
        students=new Student[50];  
        studentCount=0;
    }
    private void resizeArray() {
        Student[] newStudents=new Student[students.length*2];
        for (int i=0;i<studentCount;i++) {
            newStudents[i]=students[i];
        }
        students=newStudents;
    }
    public void addStudent(Student student) {
        if (studentCount==students.length) {
            resizeArray(); 
        }
        students[studentCount]=student;
        studentCount++;
        System.out.println("Student added successfully.");
    }
    public void removeStudent(String rollNo) {
        int index=-1;
        for (int i=0;i<studentCount;i++) {
            if (students[i].getRollNo().equals(rollNo)) {
                index=i;
                break;
            }
        }
        if (index!=-1) {
            for (int i=index;i<studentCount-1;i++) {
                students[i]=students[i+1];
            }
            students[studentCount-1]=null;
            studentCount--;
            System.out.println("Student removed successfully.");
        } 
        else {
            System.out.println("Student not found.");
        }
    }
    public Student searchStudent(String rollNo) {
        for (int i=0;i<studentCount;i++) {
            if (students[i].getRollNo().equals(rollNo)) {
                return students[i];
            }
        }
        return null;
    }
    public void displayAllStudents() {
        if (studentCount==0) {
            System.out.println("No students found.");
        } 
        else {
            for (int i=0;i<studentCount;i++) {
                System.out.println(students[i]);
            }
        }
    }
}
public class StudentManagementApp {
    private static Scanner sc=new Scanner(System.in);
    private static StudentManagementSystem sms=new StudentManagementSystem();
    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Exit");
            System.out.print("Enter your choice: ");
            int ch=sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addStudent() {
        System.out.print("Enter name: ");
        String name=sc.nextLine();
        System.out.print("Enter roll number: ");
        String rollNo=sc.nextLine();
        System.out.print("Enter grade: ");
        String grade=sc.nextLine();
        System.out.print("Enter contact number: ");
        String contactNo=sc.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dOB=sc.nextLine();
        System.out.print("Enter email: ");
        String email=sc.nextLine();
        if (name.isEmpty() || rollNo.isEmpty() || grade.isEmpty() || contactNo.isEmpty() || dOB.isEmpty() || email.isEmpty()) {
            System.out.println("All fields are required.");
        } 
        else {
            Student student=new Student(name,rollNo,grade,contactNo,dOB,email);
            sms.addStudent(student);
        }
    }
    private static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        String rollNo=sc.nextLine();
        sms.removeStudent(rollNo);
    }
    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String rollNo=sc.nextLine();
        Student student=sms.searchStudent(rollNo);
        if (student!=null) {
            System.out.println(student);
        } 
        else {
            System.out.println("Student not found.");
        }
    }
}
