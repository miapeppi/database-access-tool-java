package com.noroff.Ass2DataAccess.models;

public class Track {
    private Integer trackId;
    private String name;
    private Album album;
    private Integer mediaTypeId;
    private Genre genre;
    private String composer;
    private long milliseconds;
    private byte bytes;
    private double unitPrice;

    public Track() {}

    public Track(Integer trackId, String name, Album album, Integer mediaTypeId, Genre genre, String composer, long milliseconds, byte bytes, double unitPrice) {
        this.trackId = trackId;
        this.name = name;
        this.album = album;
        this.mediaTypeId = mediaTypeId;
        this.genre = genre;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Integer mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public byte getBytes() {
        return bytes;
    }

    public void setBytes(byte bytes) {
        this.bytes = bytes;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
