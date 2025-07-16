//Track class
package com.dkte;
public class Track {
    private int trackId;
    private String title;
    private int albumId;
    private int artistId;
    public Track() {
    	//parameter-less cons.
    }
    public Track(int trackId, String title, int albumId, int artistId) {
        this.trackId = trackId;
        this.title = title;
        this.albumId = albumId;
        this.artistId = artistId;
    }
    public int getTrackId() { 
    	return trackId; 
    }
    public void setTrackId(int trackId) { 
    	this.trackId = trackId; 
    }
    public String getTitle() { 
    	return title; 
    }
    public void setTitle(String title) { 
    	this.title = title; 
    }
    public int getAlbumId() { 
    	return albumId; 
    }
    public void setAlbumId(int albumId) { 
    	this.albumId = albumId; 
    }
    public int getArtistId() { 
    	return artistId; 
    }
    public void setArtistId(int artistId) { 
    	this.artistId = artistId; 
    }
    public String toString() {
        return "Track ID: " + trackId + ", Title: " + title + ", Album ID: " + albumId + ", Artist ID: " + artistId;
    }
}
