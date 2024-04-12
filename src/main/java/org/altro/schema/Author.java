package org.altro.schema;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Authors")
public class Author {

    // Properties
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "author")
    private Collection<Book> books;


    // Constructors

    public Author() {
    }

    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
