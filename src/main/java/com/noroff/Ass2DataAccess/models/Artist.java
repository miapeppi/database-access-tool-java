package com.noroff.Ass2DataAccess.models;

public class Artist {
    private Integer artistId;
    private String name;

    public Artist() {}

    public Artist(Integer artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
