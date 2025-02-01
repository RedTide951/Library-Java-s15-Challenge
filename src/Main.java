import com.library.books.Book;
import com.library.books.BookStatus;
import com.library.Library;
import com.library.person.Author;
import com.library.person.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Author test
        System.out.println("---Author Tests---");
        Author testAuthor = new Author("Veli the Author");
        testAuthor.newBook(new Book(56, testAuthor, "Veli's book", 20, BookStatus.AVAILABLE, 1.0));
        Book testBook1 = new Book(12, testAuthor ,"testBook1", 15, BookStatus.AVAILABLE,2.0);
        Book testBook2 = new Book(13, testAuthor ,"testBook2", 15, BookStatus.AVAILABLE,2.0);
        Book testBook3 = new Book(14, testAuthor ,"testBook3", 15, BookStatus.AVAILABLE,2.0);
        testAuthor.showBooks();
        System.out.println("******************");

        // Book Tests
        System.out.println("---Book Tests---");
        System.out.println("Display Book: " + testBook1.displayBook());
        System.out.println("get Bookid: " + testBook2.getBook_id());
        System.out.println("Get Author: " + testBook2.getAuthor());
        System.out.println("******************");

        // Reader Tests
        System.out.println("---Reader Tests---");
        Reader ali = new Reader("Ali");
        ali.showOwnedBooks();
        ali.showBorrowedBooks();
        ali.receiveBook(testBook1);
        ali.showOwnedBooks();
        ali.loseBook(testBook1);
        System.out.println("******************");

        // Library Tests
        System.out.println("---Library Tests---");
        Library library1 = new Library("Halk kütüphanesi");
        library1.addNewBook(testBook1);
        library1.addNewBook(testBook2);
        library1.addNewBook(testBook3);
        library1.addNewReader(ali);
        library1.sellBook(testBook3, ali);
        ali.showOwnedBooks();
        System.out.println("******************");

    }
}