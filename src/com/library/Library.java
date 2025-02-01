package com.library;

import com.library.books.Book;
import com.library.books.BookStatus;
import com.library.person.Librarian;
import com.library.person.Reader;

import java.time.LocalDate;
import java.util.*;


public class Library {
    private Map<Long, Reader> readersList = new HashMap<>();
    private Map<Long, Book> booksList = new HashMap<>();
    private Map<Long, Librarian> librarianList = new HashMap<>();
    private String libraryName;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("New Library : " + this.getLibraryName());
    };

    // add remove, reader & books
    public void addNewBook(Book book) {
        if (booksList.containsKey(book.getBook_id())) {
            System.out.println("A book with this ID already exists. Please check. Existing book: " + booksList.get(book.getBook_id()) );
            return;
        }
        booksList.put(book.getBook_id(), book);
        System.out.println(book.getTitle() + " has been added to " + this.getLibraryName());
    }
    public void addNewReader(Reader reader) {
        if (reader.getMemberRecord() == null) {
            System.out.println("Verify reader record first.");
            return;
        }
        readersList.put(reader.getMemberRecord().getReaderId(), reader);
        System.out.println(reader.whoYouAre() + " added to " + libraryName + "'s member list");
    }
    public void removeReader(long readerId) {
        if (readersList.containsKey(readerId)) {
            readersList.remove(readerId);
            System.out.println("Reader with ID " + readerId + " has been removed.");
        } else {
            System.out.println("Reader with ID " + readerId + " not found.");
        }
    }
    public void removeBook(long bookId) {
        if (booksList.containsKey(bookId)) {
            booksList.remove(bookId);
            System.out.println("Book with ID " + bookId + " has been removed.");
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    // list getters
    public Map<Long, Reader> getReadersList() {
        return readersList;
    }
    public Map<Long, Book> getBooksList() {
        return booksList;
    }
    public Map<Long, Librarian> getLibrarianList() {
        return librarianList;
    }

    public void sellBook(Book book, Reader buyer) {
        if (!booksList.containsKey(book.getBook_id())) {
            System.out.println("Invalid book ID.");
            return;
        }
        if (book.getStatus() == BookStatus.UNAVAILABLE) {
            System.out.println("The book " + book.getTitle() + " is currently unavailable for purchase.");
            return;
        }
        book.changeOwner(buyer);
        book.setStatus(BookStatus.UNAVAILABLE);
        booksList.remove(book.getBook_id());
        buyer.purchaseBook(book);
        System.out.println("The book " + book.getTitle() + " has been sold to " + buyer.whoYouAre());
    }
    public void lendBook(Book book, Reader borrower) {
        if (!readersList.containsKey(borrower.getMemberRecord().getReaderId())) {
            System.out.println(borrower.whoYouAre() + " is not authorized to borrow from this library");
            return;
        }
        if (!booksList.containsKey(book.getBook_id())) {
            System.out.println("Invalid book ID.");
            return;
        }
        if (book.getStatus() == BookStatus.UNAVAILABLE) {
            System.out.println("The book " + book.getTitle() + " is unavailable for borrowing right now.");
            return;
        }
        book.changeOwner(borrower);
        book.setStatus(BookStatus.UNAVAILABLE);
        book.setBorrowDate(LocalDate.now());
        borrower.borrowBook(book, this);
    }
    public void takeBookBack(Book book, Reader reader) {
        if (!readersList.containsKey(reader.getMemberRecord().getReaderId())) {
            System.out.println("Reader not found.");
            return;
        }
        if (!booksList.containsKey(book.getBook_id())) {
            System.out.println("Book not found in library records.");
            return;
        }
        if (book.getCurrentOwner() != reader) {
            System.out.println("Reader does not own this book.");
            return;
        }
        reader.loseBook(book);
        book.changeOwner(null);
        book.setStatus(BookStatus.AVAILABLE);
        booksList.put(book.getBook_id(), book);
        reader.getMemberRecord().removeFromBorrowedBooksList(book);
    }

    public String getLibraryName() {
        return libraryName;
    }
}
