package info.controller;
import java.util.Scanner;
import java.util.ArrayList;
import info.view.*;
import info.vo.*;

public class StudentController {
	
	ArrayList<StudentVO> svoList;
	public static final int CONTINUE = 1;
	public static final int EXIT = 0;
	
	ArrayList <String> names = new ArrayList <String>();
	ArrayList <Integer> stuIds = new ArrayList <Integer>();
	ArrayList <Integer> grades = new ArrayList <Integer>();
	ArrayList <String> majors = new ArrayList <String>();
	ArrayList <String> phoneNums = new ArrayList <String>();
	
	public void consoleToList() {
		
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		int flag = CONTINUE;       // 상태를 확인받기 위한 flag 변수
		while(true) {
			System.out.print("이름, 학번, 학년, 전공, 전화번호를 입력하세요 : ");
			names.add(s1.next());
			stuIds.add(s1.nextInt());
			grades.add(s1.nextInt());
			majors.add(s1.next());
			phoneNums.add(s1.next());
			
			System.out.print("계속하시겠습니까? 중지하려면 0을 누르십시오.");
			flag = s2.nextInt();
			if (flag == EXIT) {
				break;
			}
		}
		
		s1.close();
		s2.close();
	}
	
	
	public void voToDAO(StudentDAO dao){
		for (int i = 0; i< names.size(); i++ ) {    
			StudentVO svo = new StudentVO(names.get(i), stuIds.get(i) , grades.get(i), majors.get(i), phoneNums.get(i)); 
			dao.insert(svo); 
		}
	}
	
	
	public static void main(String[] args) {
		StudentController controller = new StudentController();
		controller.consoleToList();
		StudentDAO dao = new StudentDAO();
		controller.voToDAO(dao);
		
		StudentView sView = new StudentView();
		sView.view(dao.select());
		

	}

}
