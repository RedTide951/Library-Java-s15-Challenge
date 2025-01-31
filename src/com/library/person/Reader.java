package com.library.person;
import com.library.Book;
import com.library.BookStatus;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reader extends Person{
    private ArrayList<Book> books = new ArrayList<Book>();

    public Reader(String name) {
        super(name);
    }

    public void purchaseBook(Book newBook) {
        if (newBook.getStatus().equals(BookStatus.AVAILABLE)) {
            books.add(newBook);
            System.out.println(newBook.getTitle() + "has been purchased by " + this.whoYouAre() + " for " + newBook.getPrice());
            newBook.changeOwner(this);
            newBook.setStatus(BookStatus.UNAVAILABLE);
        } else {
            System.out.println("The book " + newBook.getTitle() + " is currently unavailable");
        }
    }

    public void borrowBook(Book newBook) {
        if (newBook.getStatus().equals(BookStatus.AVAILABLE)) {
            books.add(newBook);
            System.out.println(newBook.getTitle() + "has been borrowed by " + this.whoYouAre());
            newBook.changeOwner(this);
            newBook.setStatus(BookStatus.UNAVAILABLE);
        } else {
            System.out.println("The book " + newBook.getTitle() + " is currently unavailable");
        }
    }

    public void returnBook(Book newBook) {
        books.remove(newBook);
        System.out.println(newBook.getTitle() + "has been returned by " + this.whoYouAre());
        newBook.changeOwner(null);
        newBook.setStatus(BookStatus.AVAILABLE);
    }

    public void showBooks() {
        System.out.println("Reader " + this.whoYouAre() + " Currently has following books");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getTitle());
        }
        System.out.println("*End of books list*");
    }


}
