package com.example.mock_project.service;


import java.util.List;
import com.example.mock_project.entities.Book;
import com.example.mock_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public long countBook(){return bookRepository.count();};

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return  bookRepository.getBookById(id);
    }

    public void saveBook(Book bookEntity){
        bookRepository.save(bookEntity);
    }

    public void updateBook(int id, Book bookEntity){
        Book newBookEntity = bookRepository.getBookById(id);
        newBookEntity.setBookTitle(bookEntity.getBookTitle());
        newBookEntity.setAuthor(bookEntity.getAuthor());
        newBookEntity.setBrief(bookEntity.getBrief());
        newBookEntity.setPublishedDate(bookEntity.getPublishedDate());
        newBookEntity.setContent(bookEntity.getContent());
        newBookEntity.setCategory(bookEntity.getCategory());

        bookRepository.save(newBookEntity);
    }


    public void deleteBookById(int id ){
        bookRepository.deleteById(id);
    }

    public Page<Book> listAll(int currentPage, String keyword){
        Pageable pageable = PageRequest.of(currentPage - 1, 2);
        if(keyword !=null && keyword != "") {
            return  bookRepository.findBookByBookTitleOrAuthor(keyword, keyword, pageable);
        }
        return bookRepository.findAll(pageable);
    }

    public List<Book> getListBookByBookTitle(ArrayList <String> titles){
        ArrayList<Book> listBooks = new ArrayList<>();
        for (String title: titles
             ) {
            Book book = bookRepository.getBookByBookTitle(title);
            listBooks.add(book);
        }
        return listBooks;
    }
}
