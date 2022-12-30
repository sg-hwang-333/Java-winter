package book.vo;

public class BookVO {
	
	// field
	String isbn;
	String bookName;
	String publish;
	String author;
	int price;
	String category;
	
	// 생성자
	public BookVO() {}
	public BookVO(String isbn, String bookName, String publish, String author, int price, String category) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.publish = publish;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	// getter / setter
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	// toString
	@Override
	public String toString() {
		return "[isbn=" + isbn + ", bookName=" + bookName + ", publish=" + publish + ", author=" + author
				+ ", price=" + price + ", category=" + category + "]";
	}
	
	
	
}
