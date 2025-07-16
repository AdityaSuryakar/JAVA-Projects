//Q.You are tasked with developing a menu-driven console-based application that manages Artists, Albums, 
//and Tracks, and allows a user to interact with the system via a menu-driven interface. 
//Requirements: 
//Your system must support the following menu-driven operations: 
//1. Add a new artist 
//2. Add a new album 
//3. Artist adds a track for the album 
//4. Display all artists 
//5. Display all albums 
//6. View all tracks for a given artist 
//7. Display all tracks 
//8. View all tracks for a given album 
//Class Design: 
//1. Artist (artist_id, name) 
//2. Album (album_id, title) 
//3. Track (track_id, title, album_id, artist_id) 

---------------------------------------------------------------------------------------------------------------------------

//ARTIST class
package com.dkte;
public class Artist 
{
    private int artistId;
    private String name;
    public Artist() {
    	//PARAMETER-less constructor 
    }
    public Artist(int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public int getArtistId() { 
    	return artistId; 
    }
    public void setArtistId(int artistId) { 
    	this.artistId = artistId; 
    }
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    @Override
    public String toString() {
        return "Artist ID: " + artistId + ", Name: " + name;
    }
}


