package book.vo;

import java.util.ArrayList;


public class BookDAO {
	ArrayList <BookVO> bookList = new ArrayList <BookVO>();
	
	//저장
	public void insert(BookVO bvo) {
		bookList.add(bvo);
	}
	//반환
	public ArrayList<BookVO> select() {
		return bookList;
	}

}
