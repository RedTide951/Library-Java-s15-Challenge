package com.library.books;
import com.library.person.Author;
import com.library.person.Reader;

import java.time.LocalDate;

public class Book {
    private long book_id;
    private String author;
    private String name;
    private double price;
    private BookStatus status;
    private double edition;
    private LocalDate borrowDate;
    private LocalDate purchaseDate;
    private LocalDate returnDate;
    private Reader currentOwner;
    private BookTypes bookType;

    public Book(long book_id, Author author, String name, double price, BookStatus status, double edition) {
        this.book_id = book_id;
        this.author = author.whoYouAre();
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.bookType = BookTypes.JOURNAL;
        System.out.println(name + "Created as a new book");
    }

    public Book(long book_id, Author author, String name, double price, BookStatus status, double edition, BookTypes bookType) {
        this.book_id = book_id;
        this.author = author.whoYouAre();
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.bookType = bookType;
        System.out.println(name + "Created as a new book");
    }

    public long getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return name;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String displayBook() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", purchaseDate=" + purchaseDate +
                ", currentOwner=" + currentOwner +
                '}';
    }

    public Reader getCurrentOwner() {
        return this.currentOwner;
    }

    public void changeOwner(Reader newOwner) {
        this.currentOwner = newOwner;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setEdition(double edition) {
        this.edition = edition;
    }

    public void setCurrentOwner(Reader currentOwner) {
        this.currentOwner = currentOwner;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }


}
