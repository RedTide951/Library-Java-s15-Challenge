package com.library.person;
import com.library.authorizedPersonnel.Librarian;
import com.library.authorizedPersonnel.MemberRecord;
import com.library.books.Book;
import com.library.Library;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Reader extends Person{

    public Reader(String name) {
        super(name);
    }

    public void purchaseBook(Library library, Book book) {
        library.sellBook(book, this);
    }
    public void requestBorrowBook(Library library, Book book) {
        library.lendBook(book, this);
    }
    public void receiveBook(Book newBook) {
        books.add(newBook);
        System.out.println(newBook.getTitle() + " has been received by " + this.whoYouAre());
    }
    public void loseBook(Book book) {
        books.remove(book);
        System.out.println("Reader " + this.whoYouAre() + " no longer owns the book: " + book.getTitle());
    }
    public void returnBook(Book book, Library library) {
        library.returnBook(book, this);
    }
    public void showBooks() {
        System.out.println("Reader " + this.whoYouAre() + " Currently has following books");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getTitle());
        }
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
}
