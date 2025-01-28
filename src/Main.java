import com.library.Book;
import com.library.BookStatus;
import com.library.person.Author;
import com.library.person.Reader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Author testAuthor = new Author("TestAuthorName");

        Book testBook = new Book(12, testAuthor ,"BookTitle", 15, BookStatus.AVAILABLE,2.0);

        System.out.println("**who you are");
        System.out.println(testAuthor.whoYouAre());

        System.out.println("**display book");
        System.out.println(testBook.displayBook());


        Reader ali = new Reader("ali");



        System.out.println("**Show books");
        ali.purchaseBook(testBook);
        ali.showBooks();
    }
}