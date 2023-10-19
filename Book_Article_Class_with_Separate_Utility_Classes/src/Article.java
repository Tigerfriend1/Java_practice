public class Article {

    private String title;

    private String publisher;

    private int yearPublished;

    private static int numberOfArticles=0;

    public Article(String title, String publisher, int yearPublished) {
        this.title = title;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        numberOfArticles++;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Article(Article article1) {
        this.title= article1.getTitle();
        this.publisher = article1.getPublisher();
        this.yearPublished = article1.getYearPublished();
        numberOfArticles++;
    }

    public static int getNumberOfArticles() {
        return numberOfArticles;
    }

    // implement your code

}