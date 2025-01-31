package com.library.authorizedPersonnel;

import com.library.Library;
import com.library.books.Book;
import com.library.person.Reader;

public class Librarian {

    private String name;
    private String password;

    Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void searchBook(Book book, Library library) {
        library.getBooksList().get(book.getBook_id());
        System.out.println(book + " exists in the " + library + " library.");
    }
    public void verifyMembership(Reader reader, MembershipTypes types, String address, int phoneNumber) {
        MemberRecord newRecord = new MemberRecord(reader.whoYouAre(), types, address, phoneNumber);
        reader.setMemberRecord(newRecord);
    }
    public void issueBook(Book book, Reader borrower, Library library) {
        library.lendBook(book, borrower);
    }



}
