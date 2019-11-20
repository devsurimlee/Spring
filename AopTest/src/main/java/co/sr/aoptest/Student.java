package co.sr.aoptest;

public class Student {
	private String name;
	private String dept;
	private int age;
	private String grade;
	
	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		System.out.println( "Student [name=" + name + ", dept=" + dept + ", age=" + age + ", grade=" + grade + "]" );
		return "Student [name=" + name + ", dept=" + dept + ", age=" + age + ", grade=" + grade + "]";
	}
	
}
