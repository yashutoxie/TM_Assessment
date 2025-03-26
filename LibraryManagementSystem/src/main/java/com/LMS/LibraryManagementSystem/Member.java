package com.LMS.LibraryManagementSystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String status;

    @ElementCollection
    @CollectionTable(name = "borrowedbooks", joinColumns = @JoinColumn(name = "member_id"))
    @MapKeyJoinColumn(name = "book_id")
    private Map<Book, BorrowedBook> borrowedBooks = new HashMap<>();

    public Member() {}

    public Member(String name, String email, String status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<Book, BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<Book, BorrowedBook> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book, LocalDate dueDate, double dueAmount) {
        borrowedBooks.put(book, new BorrowedBook(dueDate, dueAmount));
    }

    @Override
    public String toString() {
        return "Member{id=" + id + ", name='" + name + "', borrowedBooks=" + borrowedBooks + "}";
    }
}
