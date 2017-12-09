package lec8_30_17;

public class Student {
	private String stuId, stuName, stuMajor;

	//Getters and setters
	public String getId() {
		return stuId;
	}

	public void setId(String id) {
		this.stuId = id;
	}

	public String getName() {
		return stuName;
	}

	public void setName(String name) {
		this.stuName = name;
	}

	public String getMajor() {
		return stuMajor;
	}

	public void setMajor(String major) {
		this.stuMajor = major;
	}
	
	
	//Constructors
	public Student() {
		stuId = "000000000";
		stuName = "last_first";
		stuMajor = "none";
	}
	
	public Student(int id) {
		stuId = Integer.toString(id);
		stuName = "last_first";
		stuMajor = "none";
	}
	
	public Student(String name) {
		stuId = "000000000";
		stuName = name;
		stuMajor = "none";
	}
	
	public Student(int id, String name, String major) {
		stuId = Integer.toString(id);
		stuName = name;
		stuMajor = major;
	}
	
	//Member Functions
//	public String makeName(String fName, String lName) {
//		return lName + '_' + fName;
//	}
	
	public String toString() {
		return "ID: " + this.stuId + ", Name: " + this.stuName + ", Major: " + this.stuMajor;
	}
	
	public boolean equals(Student stu) {
		return (this.stuName).equals(stu.stuName)  && (this.stuId).equals(stu.stuId) && (this.stuMajor).equals(stu.stuMajor);
	}
	
}
