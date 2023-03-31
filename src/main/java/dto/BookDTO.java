package dto;

public class BookDTO {
	int bookid;
	String title ;
	String kana_title ;
	String author;
	int isbn;
	String publisher;
	String publication_date;
	String rental;
	public BookDTO(int bookid, String title, String kana_title, String author, int isbn, String publisher,
			String publication_date, String rental) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.kana_title = kana_title;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.rental = rental;
	}
	public int getId() {
		return bookid;
	}
	public void setId(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKana_title() {
		return kana_title;
	}
	public void setKana_title(String kana_title) {
		this.kana_title = kana_title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public String getRental() {
		return rental;
	}
	public void setRental(String rental) {
		this.rental = rental;
	}
	
	
	
		
}
