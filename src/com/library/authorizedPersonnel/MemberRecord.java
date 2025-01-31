package com.library.authorizedPersonnel;

import com.library.books.Book;
import com.library.person.Reader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class MemberRecord extends Reader {
    private MembershipTypes type;
    private LocalDate membershipDate;
    private int maxBookLimit;
    private String address;
    private int phoneNumber;


    private ArrayList<Book> books = new ArrayList<Book>();
    private static final AtomicLong idCounter = new AtomicLong(1);
    private final long readerId;

    protected MemberRecord(String name, MembershipTypes type, String address, int phoneNumber) {
        super(name);
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

}
