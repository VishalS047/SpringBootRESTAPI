package com.rest.book.restbootdemo.DAO;

import org.springframework.data.repository.CrudRepository;
import com.rest.book.restbootdemo.Entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    
    public Book findBookById(int id);
}