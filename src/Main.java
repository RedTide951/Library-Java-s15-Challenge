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
        Author testAuthor = new Author("TestAuthorName");
        testAuthor.newBook(new Book(56, testAuthor, "Author's book1", 20, BookStatus.AVAILABLE, 1.0));
        System.out.println("Who you are:" + testAuthor.whoYouAre());
        testAuthor.showBooks();
        System.out.println("******************");

        // Book Tests
        System.out.println("---Book Tests---");
        Book testBook1 = new Book(12, testAuthor ,"BookTitle1", 15, BookStatus.AVAILABLE,2.0);
        Book testBook2 = new Book(13, testAuthor ,"BookTitle2", 15, BookStatus.AVAILABLE,2.0);

        System.out.println("Display Book: " + testBook1.displayBook());
        System.out.println("Book id: " + testBook2.getBook_id());
        System.out.println("Get Author: " + testBook2.getAuthor());
        System.out.println("******************");

        // Reader Tests
        System.out.println("---Reader Tests---");
        Reader ali = new Reader("Ali");
        System.out.println("New Reader " + ali.whoYouAre());
        ali.showBooks();
        System.out.println("******************");

        // Library Tests
        Book testBook3 = new Book(13, testAuthor ,"Book3 Library Book", 15, BookStatus.AVAILABLE,2.0);
        Library library1 = new Library();
        library1.addNewBook(testBook3);
        ali.requestBorrowBook(library1, testBook3);
        library1.addNewReader(ali);
        ali.requestBorrowBook(library1, testBook3);
        ali.returnBook(testBook3, library1);
        library1.removeReader(ali.getReaderId());
        System.out.println("******************");


        // App run
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Library App!");
        System.out.println("1. Reader Entry");
        System.out.println("2. Librarian entry");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;

            case 2:
                System.out.println("Exiting the app.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();





    }
}