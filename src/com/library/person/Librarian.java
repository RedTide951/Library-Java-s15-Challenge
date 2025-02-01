package com.library.person;

import com.library.Library;
import com.library.books.Book;

public class Librarian {

    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
        System.out.println("New Libarian: " + name);
    }

    public void searchBook(Book book, Library library) {
        library.getBooksList().get(book.getBook_id());
        System.out.println(book.getTitle() + " exists in " + library.getLibraryName() + " records.");
    }

    public void verifyMembership(Reader reader, MembershipTypes types, String address, int phoneNumber, Library library) {
        MemberRecord newRecord = new MemberRecord(reader.whoYouAre(), types, address, phoneNumber);
        reader.setMemberRecord(newRecord);
        System.out.println("Membership verification: " + reader.whoYouAre() + " is a verified by " + this.name + " for " + library.getLibraryName());
        library.addNewReader(reader);
    }

    public void issueBook(Book book, Reader reader, Library library) {
        if (reader.getMemberRecord().getMaxBookLimit() <= reader.getMemberRecord().getBorrowedBooks().size()) {
            System.out.println("Book cant be lent, " + reader.whoYouAre() + " has already borrowed max. number of books. Limit: " + reader.getMemberRecord().getMaxBookLimit());
        }
        library.lendBook(book, reader);
    }

}
