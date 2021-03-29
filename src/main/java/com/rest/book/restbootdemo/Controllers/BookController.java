package com.rest.book.restbootdemo.Controllers;

import java.util.List;
import java.util.Optional;

import com.rest.book.restbootdemo.Entities.Book;
import com.rest.book.restbootdemo.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books",method = RequestMethod.GET)
    @GetMapping(path = "/getallbooks")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = bookService.getAllBooks();
        if(list.size()<0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping(path = "/getbookbyid/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        if(book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = bookService.addBook(book);
        if(b!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping(path = "/deletebook/{id}")
    @ResponseBody
    public String deleteBookById(@PathVariable("id") int id) {
        bookService.deletebook(id);
        return "delete kr dia bro";
    }

    @PutMapping(path = "/updatebook/{id}")
    public void updateById(@RequestBody Book book, @PathVariable("id") int id) {

        bookService.updateBook(book, id);
        System.out.println("Book successfully updated..");
    }
}
