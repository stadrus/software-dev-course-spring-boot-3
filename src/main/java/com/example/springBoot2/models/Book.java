package com.example.springBoot2.models;

public class Book {
    private String name;
    private int year;
    private String author;
    private int pages;

    public Book() {
    }

    public Book(String name, String author, int year, int pages) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
