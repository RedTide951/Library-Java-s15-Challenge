package com.library.person;

import com.library.books.Book;

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
        System.out.println("Author " + this.whoYouAre() + " wrote those books");
        for (int i = 0; i < authorsBooks.size(); i++) {
            System.out.println((i + 1) + ". " + authorsBooks.get(i).getTitle());
        }
    }
}
