package Summertech;

public class Student {
private String student;
private String Grade;
public Student(String name,String grade1){
	student=name;
	Grade=grade1;
}
public Student(){
}
public String getStudent(){
	return student;
}
public String getGrade(){
	return Grade;
}
}
