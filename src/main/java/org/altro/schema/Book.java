package org.altro.schema;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Author author;

    @Column(nullable = false)
    private String title;

    public Book(){

    }
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
