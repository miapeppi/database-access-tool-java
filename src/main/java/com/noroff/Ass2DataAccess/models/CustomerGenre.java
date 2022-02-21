package com.noroff.Ass2DataAccess.models;

public class CustomerGenre extends Customer{
    private Integer count;
    private String genre;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
