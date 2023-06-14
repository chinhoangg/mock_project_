package com.example.mock_project.service;

import com.example.mock_project.entities.BookCase;
import com.example.mock_project.entities.User;
import com.example.mock_project.repository.BookCaseRepository;
import com.example.mock_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author Admin
 */
@Service
public class BookCaseService {
    @Autowired
    private BookCaseRepository bookCaseRepository;


    public long countBookCase(){return bookCaseRepository.count();};


    public List<BookCase> findAll(){
        return bookCaseRepository.findAll();
    }
    public void addBookCaseItem(BookCase myBookcase) {
        bookCaseRepository.save(myBookcase);
    }
    public List<BookCase> getBookCaseByUserId(Integer id) {
        List<BookCase> bookCases = bookCaseRepository.findBookCaseByUserId(id);
        return bookCases;
    }
    public void deleteBookCaseByName(String name){
        bookCaseRepository.deleteBookCaseByName(name);
    }

}
