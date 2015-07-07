package com.mcs.assignment.pojos;

/**
 * Created by eranga on 7/7/15.
 */
public class Book {
    String title;
    String publisher;

    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
