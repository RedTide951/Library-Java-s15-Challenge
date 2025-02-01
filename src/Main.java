import com.library.books.Book;
import com.library.books.BookStatus;
import com.library.Library;
import com.library.person.Author;
import com.library.person.Librarian;
import com.library.person.MembershipTypes;
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
        Book testBook4 = new Book(15, testAuthor ,"testBook4", 15, BookStatus.AVAILABLE,2.0);
        Book testBook5 = new Book(16, testAuthor ,"testBook4", 15, BookStatus.AVAILABLE,2.0);
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
        ali.purchaseBook(testBook1);
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

        // Librarian Tests
        System.out.println("---Librarian Tests---");
        Librarian librarian1 = new Librarian("Librarian1", "password");
        librarian1.searchBook(testBook2, library1);
        librarian1.verifyMembership(ali, MembershipTypes.STUDENT, "35260 / ali's adress", 05325552535, library1);
        librarian1.issueBook(testBook1, ali, library1);
        librarian1.issueBook(testBook2, ali, library1);
        librarian1.issueBook(testBook4, ali, library1);
        library1.addNewBook(testBook4);
        librarian1.issueBook(testBook4, ali, library1);
        ali.showBorrowedBooks();
        ali.returnBook(testBook5);
        ali.returnBook(testBook1);
        ali.returnBook(testBook2);
        ali.returnBook(testBook4);
        System.out.println("******************");

        


    }
}