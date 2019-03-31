public class Books {
	
	private int id;
	private String author;
	private String title;
	private int year;
	private String[] ISBN; //to solve the issue of multiple ISBN
	private String publisher;
	private String LLC;
	private int stock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String[] getISBN() {
		return ISBN;
	}
	public void setISBN(String[] ISBNnew) {
		ISBN = new String[ISBNnew.length];
		for (int j = 0; j<ISBNnew.length; j++) {
			ISBN[j] = ISBNnew[j];
		}
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLLC() {
		return LLC;
	}
	public void setLLC(String lLC) {
		LLC = lLC;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//method that prints all the information about the book in a single line
	public void printBook() {
		System.out.print(id + " "+ author + " "+title + " "+year + " ");
		for (int j = 0; j<ISBN.length; j++) {
			System.out.print(ISBN[j] + " ");
		}
		System.out.print(publisher + " "+ LLC + " "+ stock);
		System.out.println();
	}
	
	

}
