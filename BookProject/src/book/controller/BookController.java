package book.controller;

import java.util.ArrayList;
import java.util.Scanner;

import book.view.BookView;
import book.vo.BookDAO;
import book.vo.BookVO;

public class BookController {
	public static final int CONTINUE = 1;
	public static final int EXIT = 0;
	
	ArrayList <String> isbns = new ArrayList <String>();
	ArrayList <String> bookNames = new ArrayList <String>();
	ArrayList <String> publishes = new ArrayList <String>();
	ArrayList <String> authors = new ArrayList <String>();
	ArrayList <Integer> prices = new ArrayList <Integer>();
	ArrayList <String> categorys = new ArrayList <String>();
	
	public void consoleToList() {
		
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		int flag = CONTINUE; 
		System.out.println("---------- 사용자 입력란 ----------");
		while(true) {
			System.out.print("== 도서번호 > ");
			isbns.add(s1.next());
			System.out.print("== 책 이름 > ");
			bookNames.add(s1.next());
			System.out.print("== 출판사 > ");
			publishes.add(s1.next());
			System.out.print("== 저자명 > ");
			authors.add(s1.next());
			System.out.print("== 가격 > ");
			prices.add(s1.nextInt());
			System.out.print("== 카테고리 > ");
			categorys.add(s1.next());
			
			System.out.print("계속하시겠습니까? 중지하려면 0을 누르십시오.");
			flag = s2.nextInt();
			if (flag == EXIT) {
				break;
			}
			
			System.out.println("-----------------------------");
		}
		
		s1.close();
		s2.close();
	}
	
	
	public void voToDAO(BookDAO dao){
		for (int i = 0; i< isbns.size(); i++ ) {    
			BookVO bvo = new BookVO(isbns.get(i), bookNames.get(i) , publishes.get(i), authors.get(i), prices.get(i), categorys.get(i)); 
			dao.insert(bvo); 
		}
	}
	

	public static void main(String[] args) {
		BookController controller = new BookController();
		controller.consoleToList();
		BookDAO dao = new BookDAO();
		controller.voToDAO(dao);
		
		BookView sView = new BookView();
		sView.view(dao.select());

	}

}
