package com.library.person;
import com.library.Book;

import java.util.ArrayList;

public class Reader extends Person{
    private ArrayList<Book> books = new ArrayList<Book>();

    public Reader(String name) {
        super(name);
    }

    public void purchaseBook(Book newBook) {
        books.add(newBook);
    }

    public void borrowBook(Book newBook) {
        books.add(newBook);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}
