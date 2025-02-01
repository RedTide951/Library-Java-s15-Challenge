package com.library.person;

import com.library.books.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class MemberRecord {
    private static final AtomicLong idCounter = new AtomicLong(1);
    private final long readerId;
    private String username;
    private MembershipTypes type;
    private LocalDate membershipDate;
    private int maxBookLimit;
    private String address;
    private int phoneNumber;
    private double totalDebt;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();



    protected MemberRecord(String username, MembershipTypes type, String address, int phoneNumber) {
        this.username = username;
        this.readerId = idCounter.getAndIncrement();
        this.type = type;
        this.membershipDate = LocalDate.now();
        if (type == MembershipTypes.STUDENT) {
            this. maxBookLimit = 5;
        } else if (type == MembershipTypes.FACULTY) {
            this. maxBookLimit = 10;
        }
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //getters
    public MembershipTypes getType() {
        return type;
    }
    public LocalDate getMembershipDate() {
        return membershipDate;
    }
    public int getMaxBookLimit() {
        return maxBookLimit;
    }
    public String getAddress() {
        return address;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getMember() {
        return this.toString();
    }
    public long getReaderId() {
        return readerId;
    }
    public String getName() {
        return username;
    }
    public double getTotalDebt() {
        return totalDebt;
    }
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    // setters (for override)
    public void setName(String username) {
        this.username = username;
    }
    public void setType(MembershipTypes type) {
        this.type = type;
    }
    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }
    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }
    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    public void addToBorrowedBooksList(Book book) {
        this.borrowedBooks.add(book);
        System.out.println(book + " has been added to " + this.getName() + "'s borrowed list");
        this.totalDebt += 5.0;
        System.out.println(this.getName() + " new debt " + this.getTotalDebt());
    }
    public void removeFromBorrowedBooksList(Book book) {
        this.borrowedBooks.remove(book);
        System.out.println(book + " has been removed from " + this.getName() + "'s borrowed list");
        this.totalDebt -= 5.0;
        System.out.println(this.getName() + " new debt " + this.getTotalDebt());
    }

    @Override
    public String toString() {
        return "MemberRecord{" +
                "readerId=" + readerId +
                ", username='" + username + '\'' +
                ", type=" + type +
                ", membershipDate=" + membershipDate +
                ", maxBookLimit=" + maxBookLimit +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
