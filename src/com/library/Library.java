package com.library;

import com.library.person.Reader;

import java.time.LocalDate;
import java.util.*;
import static com.library.BookStatus.AVAILABLE;
import static com.library.BookStatus.UNAVAILABLE;


public class Library {
    private Map<Long, Reader> readersList = new HashMap<>();
    private Map<Long, Book> booksList = new HashMap<>();

    private Library() {};

    public Map<Long, Reader> getReadersList() {
        return readersList;
    }

    public Map<Long, Book> getBooksList() {
        return booksList;
    }

    public void addNewBook(Book inputBook) {
        booksList.put(inputBook.getBook_id(), inputBook);
    }

    public void lendBook(Book wantedBook, Reader borrower) {
        if (booksList.containsKey(wantedBook.getBook_id()) && wantedBook.getStatus().equals(AVAILABLE)) {
            borrower.borrowBook(wantedBook);
            wantedBook.setStatus(UNAVAILABLE);
            wantedBook.setBorrowDate(LocalDate.now());
            System.out.println("The book " + wantedBook.getTitle() + " is given to " + borrower + " on " + wantedBook.getBorrowDate());
        }
        if (!booksList.containsKey(wantedBook.getBook_id())) {
            System.out.println("Invalid book ID");
        }
        if (wantedBook.getStatus().equals(UNAVAILABLE)) {
            System.out.println("The book " + wantedBook + " is unavailable for borrowing right now");
        }

    }
}
