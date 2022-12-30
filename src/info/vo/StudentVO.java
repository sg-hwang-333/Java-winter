package info.vo;

// VO : Value Object
public class StudentVO {
	// 필드 선언 (이름, 학번, 학년, 전공, 전화번호)
	private String name;
	private int stuId;
	private int grade;
	private String major;
	private String phoneNum;
	
	//생성자 : 필드 값 초기화
	public StudentVO() {} 
	public StudentVO(String name, int stuId, int grade, String major, String phoneNum) {
		this.name = name;
		this.stuId = stuId;
		this.grade = grade;
		this.major = major;
		this.phoneNum = phoneNum;
	}	
	
	
	// setter : 필드 값 설정
	// getter : 필드 값 반환
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// toString
	@Override   	// 메소드 재정의
 	public String toString() {
		return "StudentVO [name=" + name + ", stuId=" + stuId + ", grade=" + grade + ", major=" + major + ", phoneNum="
				+ phoneNum + "]";
	}
}
