package com.bookstore.bookstore.controllers;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.services.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/bookstore")
public class BookstoreAPI {

    ////TODO
    ////Error handling if is isn't found

    @Autowired
    private BookstoreService BookStoreService;

    @GetMapping(value = "/getAll")
    public List<Book> getBookList(){

        return BookStoreService.getAllBooks();
    }

    @GetMapping(value = "/getBook/{id}")
    public Book getBook(@PathVariable int id){
        return BookStoreService.getBook(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/newBook")
    public void addBook(@RequestBody Book newBook){
        BookStoreService.addNewBook(newBook);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/removeBook/{id}")
    public void removeBook(@PathVariable int id){
        BookStoreService.removeBook(id);
    }

    @RequestMapping(method=RequestMethod.PATCH, value="/updateBook")
    public void updateBook(@RequestBody Book book){
        BookStoreService.updateBook(book);
    }


}
