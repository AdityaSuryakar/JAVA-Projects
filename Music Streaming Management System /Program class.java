package com.dkte;

import java.sql.*;
import java.util.Scanner;

public class Program {
    static Scanner sc=new Scanner(System.in);
    public static void addArtist() //1
    { 
        System.out.print("Enter artist name:");
        String name =sc.next();
        String sql="INSERT INTO artist(name) VALUES(?)";
        try (Connection con= DbUtil.getConnection();
              PreparedStatement stmt= con.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Artist added.");
        	} 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void addAlbum()  //2
    {
        System.out.print("Enter album title: ");
        String title = sc.next();
        String sql = "INSERT INTO album(title) VALUES(?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.executeUpdate();
            System.out.println("Album added.");
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }
    public static void addTrack() //3
    {
        System.out.print("Enter track title: ");
        String title = sc.next();
        System.out.print("Enter album id: ");
        int albumId = sc.nextInt();
        System.out.print("Enter artist id: ");
        int artistId = sc.nextInt();
        String sql = "INSERT INTO track(title, album_id, artist_id) VALUES(?,?,?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setInt(2, albumId);
            stmt.setInt(3, artistId);
            stmt.executeUpdate();
            System.out.println("Track added.");
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void displayArtists() //4
    {
        String sql = "SELECT * FROM artist";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) 
                System.out.println("Artist ID: " + rs.getInt(1) + ", Name: " + rs.getString(2));
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void displayAlbums() //5
    {
        String sql = "SELECT * FROM album";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next())
                System.out.println("Album ID: " + rs.getInt(1) + ", Title: " + rs.getString(2));
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void displayTracks() //6
    {
        String sql = "SELECT * FROM track";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next())
                System.out.println("Track ID: " + rs.getInt(1) + ", Title: " + rs.getString(2) +
                        ", Album ID: " + rs.getInt(3) + ", Artist ID: " + rs.getInt(4));
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void viewTracksByArtist() //7
    {
        System.out.print("Enter artist ID: ");
        int artistId = sc.nextInt();
        String sql = "SELECT * FROM track WHERE artist_id=?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, artistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                System.out.println("Track ID: " + rs.getInt(1) + ", Title: " + rs.getString(2));
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void viewTracksByAlbum() //8
    {
        System.out.print("Enter album ID: ");
        int albumId = sc.nextInt();
        String sql = "SELECT * FROM track WHERE album_id=?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, albumId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                System.out.println("Track ID: " + rs.getInt(1) + ", Title: " + rs.getString(2));
        } 
        catch (SQLException e) { 
        	e.printStackTrace(); 
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n0.Exit 1.Add Artist 2.Add Album 3.Add Track 4.Display Artists 5.Display Albums 6.Tracks by Artist 7.All Tracks 8.Tracks by Album");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 :addArtist();
                case 2 : addAlbum();
                case 3 : addTrack();
                case 4 : displayArtists();
                case 5 : displayAlbums();
                case 6 : viewTracksByArtist();
                case 7 : displayTracks();
                case 8 : viewTracksByAlbum();  
            }
        } while (choice != 0);
    }
}
