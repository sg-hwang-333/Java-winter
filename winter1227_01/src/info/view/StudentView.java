package info.view;
import info.vo.StudentVO;
import java.util.ArrayList;

// 화면에 보여주기(출력) 위한 객체 
public class StudentView {
	// view() : 화면에 출력을 위한 메소드
	public void view(ArrayList<StudentVO> svoList) {
		for (StudentVO svo : svoList) {
			System.out.println("================================================================");
			System.out.println(svo.toString());
			System.out.println("================================================================");
		}
	}

}
