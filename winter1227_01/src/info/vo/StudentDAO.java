package info.vo;
import java.util.ArrayList;

// DAO : Data Access Object (DB에서 값을 선택하거나 할 때 사용)
public class StudentDAO {
	// ArrayList : 학생정보객체 (StudentVO)들을 저장하기 위해 필요함
	ArrayList <StudentVO> svoList = new ArrayList<StudentVO>();       //<>안의 타입을 설정하지 않으면 자동으로 Object형으로 됨 
	
	// insert : ArrayList에 학생정보객체(StudentVO)를 추가하는 메소드
	public void insert(StudentVO svo) {
		svoList.add(svo);
	}
	
	// select : 전체 학생정보객체드를 반환하는 메소드
	public ArrayList<StudentVO> select() {
		return svoList;
	}

}
