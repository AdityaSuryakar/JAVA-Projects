//ALBUM class 
package com.dkte;
public class Album {
    private int albumId;
    private String title;
    public Album() {
    	//Parameter-less constructor
    }
    public Album(int albumId, String title) {
        this.albumId = albumId;
        this.title = title;
    }
    public int getAlbumId() { 
    	return albumId; 
    }
    public void setAlbumId(int albumId) {
    	this.albumId = albumId; 
    }
    public String getTitle() { 
    	return title; 
    }
    public void setTitle(String title) { 
    	this.title = title; 
    }
    @Override
    public String toString() {
        return "Album ID: " + albumId + ", Title: " + title;
    }
}
