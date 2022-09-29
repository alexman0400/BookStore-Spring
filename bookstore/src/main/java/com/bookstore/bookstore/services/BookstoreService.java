package com.bookstore.bookstore.services;

import com.bookstore.bookstore.entities.Book;
import org.springframework.stereotype.Service;

import java.util.*;
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
        try {
            return bookList.stream().filter(t -> t.getId()  == id).findFirst().get();
        }
        catch(NoSuchElementException e){
            System.out.println("No such Book element found");
        }
        return null;
    }

    public void addNewBook(Book newBook) {
        bookList.add(newBook);
    }

    public void removeBook(int id) {
        Book b = getBook(id);
        if(b != null)
            bookList.remove(b);
    }

    public void updateBook(Book updatedVersion) {
        removeBook(updatedVersion.getId());
        bookList.add(updatedVersion);
    }
}
