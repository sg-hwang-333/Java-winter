package book.view;

import java.util.ArrayList;
import book.vo.BookVO;

public class BookView {
	public void view(ArrayList<BookVO> bookList) {
		for (BookVO bvo : bookList) {
			System.out.println(bvo.toString());
		}
	}

}
