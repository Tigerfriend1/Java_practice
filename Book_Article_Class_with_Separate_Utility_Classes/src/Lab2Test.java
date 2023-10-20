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

    //여기서는 같은 클래스 객체만 넣기 때문에 리플랙션없이 바로 비교해도 됨.
    private static void checkEquality(Book book1, Book book2) {
        if((book1.getTitle().equals(book2.getTitle())) && (book1.getAuthor().equals(book2.getAuthor()))){
            System.out.println(true);
        }else System.out.println(false);
        //System.out.println(ReflectionUtility.getCheckEquality(object1,object2));
    }
    private static void checkEquality(Article article1, Article article2) {
        if((article1.getTitle().equals(article2.getTitle())) && (article1.getPublisher().equals(article2.getPublisher()))){
            System.out.println(true);
        }else System.out.println(false);
        //System.out.println(ReflectionUtility.getCheckEquality(object1,object2));
    }
    //리플렉션을 사용하여 구별(다른 클래스 추가시 사용)
    private static void checkEquality(Object object1, Object object2) {
        System.out.println(ReflectionUtility.getCheckEquality(object1,object2));
    }

    // implement your code



}