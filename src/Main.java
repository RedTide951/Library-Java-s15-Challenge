import com.library.Book;
import com.library.BookStatus;
import com.library.person.Author;
import com.library.person.Reader;

public class Main {
    public static void main(String[] args) {

        // Author test
        System.out.println("---Author Tests---");
        Author testAuthor = new Author("TestAuthorName");
        testAuthor.newBook(new Book(56, testAuthor, "Author's book1", 20, BookStatus.AVAILABLE, 1.0));
        System.out.println("Who you are method:" + testAuthor.whoYouAre());
        System.out.println("-Show books");
        testAuthor.showBooks();
        System.out.println("-End of Show books");
        System.out.println("******************");

        // Create new book Tests
        System.out.println("---Book Tests---");
        Book testBook1 = new Book(12, testAuthor ,"BookTitle1", 15, BookStatus.AVAILABLE,2.0);
        Book testBook2 = new Book(13, testAuthor ,"BookTitle2", 15, BookStatus.AVAILABLE,2.0);
        Book testBook3 = new Book(14, testAuthor ,"BookTitle4", 10, BookStatus.UNAVAILABLE,2.0);
        Book testBook4 = new Book(14, testAuthor ,"BookTitle4", 10, BookStatus.AVAILABLE,2.0);

        System.out.println("display book method for test book 1");
        System.out.println(testBook1.displayBook());
        System.out.println("******************");

        // Reader Tests
        System.out.println("---Reader Tests---");
        Reader ali = new Reader("ali");
        ali.whoYouAre();
        ali.borrowBook(testBook1);
        ali.purchaseBook(testBook2);
        ali.showBooks();
        System.out.println("******************");
    }
}