package com.library.person;
import com.library.books.Book;
import com.library.Library;

import java.util.ArrayList;

public class Reader extends Person{
    private ArrayList<Book> ownedBooks = new ArrayList<Book>();

    private MemberRecord memberRecord;

    public Reader(String name) {
        super(name);
        System.out.println("New Reader " + name);
    }

    public void purchaseBook(Library library, Book book) {
        library.sellBook(book, this);
    }
    public void requestBorrowBook(Library library, Book book) {
        library.lendBook(book, this);
    }
    public void receiveBook(Book newBook) {
        ownedBooks.add(newBook);
        System.out.println(newBook.getTitle() + " has been received by " + this.whoYouAre());
    }
    public void loseBook(Book book) {
        ownedBooks.remove(book);
        System.out.println("Reader " + this.whoYouAre() + " no longer owns the book: " + book.getTitle());
    }
    public void returnBook(Book book, Library library) {
        library.takeBookBack(book, this);
    }
    public void showOwnedBooks() {
        if (ownedBooks.isEmpty()) {
            System.out.println(this.whoYouAre() + " does not own any books");
            return;
        }
        System.out.println("Reader " + this.whoYouAre() + " Currently owns the following books");
        for (int i = 0; i < ownedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + ownedBooks.get(i).getTitle());
        }
    }

    public void showBorrowedBooks() {
        if (this.getMemberRecord() == null) {
            System.out.println( this.whoYouAre() + " has no membership records.");
            return;
        }
        System.out.println("Reader " + this.whoYouAre() + " Currently borrowed the following books");
        for (int i = 0; i < getMemberRecord().getBorrowedBooks().size(); i++) {
            System.out.println((i + 1) + ". " + getMemberRecord().getBorrowedBooks().get(i).getTitle());
        }
    }

    // getters setters
    protected void setMemberRecord(MemberRecord memberRecord) {
        this.memberRecord = memberRecord;
    }
    public MemberRecord getMemberRecord() {
        return memberRecord;
    }
    public ArrayList<Book> getOwnedBooks() {
        return ownedBooks;
    }
}
