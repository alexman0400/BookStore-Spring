package com.bookstore.bookstore.entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Book {

    public int getId() {
        return id;
    }

    private @Id int id;
    private @NotNull String name;
    private @NotNull String author;
    private @NotNull String date;
}
