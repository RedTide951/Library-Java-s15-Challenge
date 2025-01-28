package com.library.person;

import com.library.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    public Author(String name) {
        super(name);
    }

    private List<Book> authorsBooks = new ArrayList<>();

    public void newBook(Book newBook) {
        authorsBooks.add(newBook);
    }

    public void showBooks() {
        for (Book book : authorsBooks) {
            System.out.println(book.getTitle());
        }
    }
}
