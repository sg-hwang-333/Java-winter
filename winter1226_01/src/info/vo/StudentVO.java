package info.vo;
/*학생 정보를 저장하는 Object (value Object)
 * 생성자
 * 필드 값을 반환해주는 메서드, 필드 값을 설정해주는 메서드 */

public class StudentVO {    //value Object(VO) 또는 DTO
	//FIELD
	private String name;
	private int stuId;
	private int grade;
	private String major;
	private String address;
	private String mobile;
	
	//생성자
	public StudentVO() {}
	public StudentVO(String name, int stuId, int grade, String major, String address, String moblie) {
		super();
		this.name = name;
		this.stuId = stuId;
		this.grade = grade;
		this.major = major;
		this.address = address;
		this.mobile = moblie;
	}
	
	// getter / setter
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMoblie() {
		return mobile;
	}
	public void setMoblie(String moblie) {
		this.mobile = moblie;
	}
	
	//toString
	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", stuId=" + stuId + ", grade=" + grade + ", major=" + major + ", address="
				+ address + ", moblie=" + mobile + "]";
	}
	
	
	

}
