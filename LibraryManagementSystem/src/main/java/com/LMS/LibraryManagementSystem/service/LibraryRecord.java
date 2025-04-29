package com.LMS.LibraryManagementSystem.service;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libraryrecord")
public class LibraryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String memberEmail;

    private String bookName;
    private String authorName;

    private LocalDate borrowedDate;
    private LocalDate dueDate;

    private double dueAmount;

    public LibraryRecord() {}

    public LibraryRecord(String memberName, String memberEmail, String bookName, String authorName, LocalDate borrowedDate, LocalDate dueDate, double dueAmount) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.bookName = bookName;
        this.authorName = authorName;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.dueAmount = dueAmount;
    }

    public Long getId() {
        return id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    @Override
    public String toString() {
        return "LibraryRecord{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                ", dueAmount=" + dueAmount +
                '}';
    }
}