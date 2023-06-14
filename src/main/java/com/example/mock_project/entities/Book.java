package com.example.mock_project.entities;

import javax.persistence.*;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Admin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String bookTitle;

    @Column
    private String author;

    @Column(columnDefinition = "text")
    private String brief;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;

    @Column(columnDefinition = "text")
    private String content;

    @Column
    private Integer category;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "contain",
            joinColumns =@JoinColumn(name = "book_id"),
            inverseJoinColumns =@JoinColumn(name = "book_case_id"))
    private Set<BookCase> bookCaseList = new HashSet<>();

    public void addBookCase(BookCase bookCase) {
        this.bookCaseList.add(bookCase);
    }
}
