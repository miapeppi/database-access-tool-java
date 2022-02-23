package com.noroff.Ass2DataAccess.models;

public class Album {
    private Integer albumId;
    private String title;
    private Artist artist;

    public Album() {}

    public Album(Integer albumId, String title, Artist artist) {
        this.albumId = albumId;
        this.title = title;
        this.artist = artist;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
