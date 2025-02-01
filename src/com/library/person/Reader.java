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

    public void purchaseBook(Book book) {
        ownedBooks.add(book);
        System.out.println(book.getTitle() + " has been purchased by " + this.whoYouAre());
    }

    public void borrowBook(Book book, Library library) {
        getMemberRecord().addToBorrowedBooksList(book);
    }
    public void loseBook(Book book) {
        ownedBooks.remove(book);
        System.out.println("Reader " + this.whoYouAre() + " no longer owns the book: " + book.getTitle());
    }

    public void returnBook(Book book) {
        if (!this.getMemberRecord().getBorrowedBooks().contains(book)) {
            System.out.println(book.getTitle() + "does not exist in your borrowed list");
            return;
        }

        this.getMemberRecord().removeFromBorrowedBooksList(book);
        showBorrowedBooks();
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
        if (this.getMemberRecord().getBorrowedBooks().isEmpty()) {
            System.out.println( this.whoYouAre() + " has no books borrowed right now");
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
