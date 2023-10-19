public class Book {

    private String title;

    private String author;

    private int yearPublished;

    private static int numberOfBooks=0;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        numberOfBooks++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Book(Book book1) {
        this.title = book1.getTitle();
        this.author = book1.getAuthor();
        this.yearPublished = book1.getYearPublished();
        numberOfBooks++;
    }

    public static int getNumberOfBooks() {
        return numberOfBooks;
    }

    // implement your code

}