import java.util.List;


public class Lab2Test {

    public static void main(String[] args) {

        Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997);

        Book book2 = new Book(book1);

        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);



        System.out.println(Book.getNumberOfBooks());

        checkEquality(book1, book2);

        getAttr(book1);

        toJson(book1);

        toJson(book2);



        Article article1 = new Article("Java Foundations", "TechMag", 2023);

        Article article2 = new Article(article1);

        Article article3 = new Article("Well-Designed Work", "Sharon", 2022);

        Article article4 = new Article(article3);



        System.out.println(Article.getNumberOfArticles());

        checkEquality(article1, article2);

        checkEquality(article3, article4);

        getAttr(article1);

        toJson(article1);

        toJson(article3);

    }

    private static void getAttr(Object object) {
        System.out.println(ReflectionUtility.getAttributes(object));
    }

    private static void toJson(Object object) {
        System.out.println(JSONUtility.toJSON(object));
    }

    private static void checkEquality(Object object1, Object object2) {
        System.out.println(ReflectionUtility.getCheckEquality(object1,object2));
    }

    // implement your code



}