package com.example.mock_project.repository;

import com.example.mock_project.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Admin
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    long count();

    public List<Book> findAll();

    public Book getBookById(int id);
    public Book getBookByBookTitle(String bookTitle);

    public Book save(Book bookEntity);

    void deleteById(int  id);

    public Page<Book> findBookByBookTitleOrAuthor(String bookTitle, String author, Pageable pageable);


}
