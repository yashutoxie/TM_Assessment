package com.jpa.relationsJPA;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Explicit strategy
    private long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    // ✅ Default constructor (required by JPA)
    public Author() {}

    // ✅ Parameterized constructor for easier object creation
    public Author(String name) {
        this.name = name;
    }

    // ✅ Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    // ✅ Helper method to add a book and maintain both sides of the relationship
    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this); // Maintain bidirectional consistency
    }

    // ✅ Helper method to remove a book and maintain both sides of the relationship
    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    // ✅ Override toString() for better logging and debugging
    @Override
    public String toString() {
        return "Author{id=" + id + ", name='" + name + "', books=" + books + "}";
    }
}
