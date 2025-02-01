package com.library.person;

import com.library.Library;
import com.library.books.Book;

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
    public void verifyMembership(Reader reader, MembershipTypes types, String address, int phoneNumber, Library library) {
        MemberRecord newRecord = new MemberRecord(reader.whoYouAre(), types, address, phoneNumber);
        reader.setMemberRecord(newRecord);
        library.addNewReader(reader);
    }

    public void issueBook(Book book, Reader reader, Library library) {
        if (reader.getMemberRecord().getMaxBookLimit() > reader.getMemberRecord().getMaxBookLimit())
        library.lendBook(book, reader);
    }

    public void fineCalculator(Reader reader) {

    }



}
