package com.bookstore.bookstore.services;

import com.bookstore.bookstore.entities.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BookstoreService {
    private List<Book> bookList =  new ArrayList<>(Arrays.asList(
            new Book(1, "Book 1", "Author 1", "Date 1"),
            new Book(2, "Book 2", "Author 2", "Date 2"),
            new Book(3, "Book 3", "Author 3", "Date 3")));


    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBook(int id){
        return bookList.stream().filter(t -> t.getId()  == id).findFirst().get();
    }

    public void addNewBook(Book newBook) {
        bookList.add(newBook);
    }

    public int removeBook(int id) {
        Optional<Book> b = Optional.ofNullable(bookList.stream().filter(t -> t.getId()  == id).findFirst().get());
        if(!b.isEmpty()){
            bookList.remove(bookList.stream().filter(t -> t.getId()  == id).findFirst().get());
            return 0;
        }

        return -1;
    }

    public int updateBook(int id, Book updatedVersion) {
        Optional<Book> b = Optional.ofNullable(bookList.stream().filter(t -> t.getId()  == id).findFirst().get());
        if(!b.isEmpty()){
            bookList.remove(bookList.stream().filter(t -> t.getId()  == id).findFirst().get());
            bookList.add(updatedVersion);
            return 0;
        }

        return -1;
    }
}
