package info.controller;
import java.util.ArrayList;
import java.util.Scanner;
import info.vo.StudentDAO;
import info.vo.StudentVO;
import info.vo.StudentView;

public class StudentInfoController {
	public static final int CONTINUE = 1;
	public static final int EXIT = 0;
	
	ArrayList<StudentVO> svoList; //StudentDAO의 svoList와는 이름만 같고 다른 객체
	

	public static void main(String[] args) {
		//ArrayList 선언
		ArrayList <String> names = new ArrayList <String>();
		ArrayList <Integer> stuIds = new ArrayList <Integer>();
		ArrayList <Integer> grades = new ArrayList <Integer>();
		ArrayList <String> majors = new ArrayList <String>();
		ArrayList <String> addresses = new ArrayList <String>();
		ArrayList <String> mobiles = new ArrayList <String>();
	
		
		Scanner s1 = new Scanner(System.in);   //값 입력용
		Scanner s2 = new Scanner(System.in);   //상수 입력용
		int flag = CONTINUE;
		while(true) {
			System.out.println("=====================");
			System.out.print("이름, 학번, 학년, 전공, 주소, 전화번호를 입력하세요 : ");
			
			names.add(s1.next());
			stuIds.add(s1.nextInt());
			grades.add(s1.nextInt());
			majors.add(s1.next());
			addresses.add(s1.next());
			mobiles.add(s1.next());
			
			// 중지여부 확인
			System.out.println("중지하시려면 0, 계속하려면 1을 입력하세요.");
			flag = s2.nextInt();
			if (flag == EXIT) {
				break;
			}
		}
		
		StudentInfoController controller = new StudentInfoController();
		StudentDAO dao = new StudentDAO();
		for (int i = 0; i< names.size(); i++ ) {    //ArrayList의 길이를 알기 위해선 size()를 사용한다.
			StudentVO svo = new StudentVO(names.get(i), stuIds.get(i) , grades.get(i), majors.get(i), addresses.get(i), mobiles.get(i)); 
			dao.insert(svo); // 콜 바이 레퍼런스 : 객체를 참조할 수 있는 값을 줌
		}
		controller.svoList = dao.select(); 
		
		//화면출력
		StudentView stuView = new StudentView();
		stuView.view(controller.svoList);
		
		s1.close();
		s2.close();
	}
}