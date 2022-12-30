package score.vo;

public class ScoreVO {
	String stuId;
	String name;
	String grade;
	String classroom;
	int kor;
	int eng;
	int math;
	int science;
	int total;
	double avg;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int kor, int eng, int math, int science) {
		this.total = kor+eng+math+science;
	}
	public double getAvg() {
		return this.avg;
	}
	public void setAvg(int total) {
		this.avg = (double)total/4.0;
	}
	
	public ScoreVO() {}
	public ScoreVO(String stuId, String name, String grade, String classroom, int kor, int eng, int math, int science,
			int total, double avg) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.science = science;
		this.total = total;
		this.avg = avg;
	}
	
	
}
