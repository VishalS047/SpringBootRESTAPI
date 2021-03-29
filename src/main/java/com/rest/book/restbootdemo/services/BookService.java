package com.rest.book.restbootdemo.services;

import java.util.List;

import com.rest.book.restbootdemo.DAO.BookRepository;
import com.rest.book.restbootdemo.Entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    // private static List<Book> list = new ArrayList<>();
    @Autowired
    private BookRepository bookRepository;
    // static {
    //     list.add(new Book(100, "As You Like It", " William Shakespeare"));
    //     list.add(new Book(101, "Much to do about nothing", " William Shakespeare"));
    //     list.add(new Book(102, "Macbeth", " William Shakespeare"));
    // }

    // get allbooks
    // public List<Book> getAllBooks() {
    //     return list;
    // }

    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)bookRepository.findAll();
        return list;
    }

    // get book by its respective Id.
    public Book getBookById(int id) {
        Book book = bookRepository.findBookById(id);
        return book;
    }

    // add book in the list
    public Book addBook(Book b) {
        Book book = bookRepository.save(b);
        System.out.println("Book successfully added......");
        return book;
    }

    // delete book from the list;
    public void deletebook(int id){
        bookRepository.deleteById(id);
        System.out.println("Book successfully deleted");
    }

    // updating the book based on id
    public void updateBook(Book book, int id){
        book.setId(id);
        bookRepository.save(book);
        System.out.println("Book successfully uploaded.....");
    }

}
