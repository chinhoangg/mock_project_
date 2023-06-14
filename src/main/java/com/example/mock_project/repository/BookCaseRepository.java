package com.example.mock_project.repository;

import com.example.mock_project.entities.BookCase;
import com.example.mock_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

/**
 * @author Admin
 */
@Repository
public interface BookCaseRepository extends JpaRepository<BookCase,Integer> {

    long count();

    List<BookCase> findAll();
    public BookCase save(BookCase bookCaseEntity);

    List<BookCase> findBookCaseById(User user);
    List<BookCase> findBookCaseByUserId(Integer id);

    @Transactional
    void deleteBookCaseByName(String name);
}
