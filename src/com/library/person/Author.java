package com.library.person;

import com.library.books.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    public Author(String name) {
        super(name);
        System.out.println("New author (" + name + ") has been created");
    }

    private List<Book> authorsBooks = new ArrayList<>();

    public void newBook(Book newBook) {
        authorsBooks.add(newBook);
        System.out.println(this.whoYouAre() + "'s new book " + newBook.getTitle());
    }

    public void showBooks() {
        System.out.println("Author " + this.whoYouAre() + " wrote these books");
        for (int i = 0; i < authorsBooks.size(); i++) {
            System.out.println((i + 1) + ". " + authorsBooks.get(i).getTitle());
        }
    }
}
