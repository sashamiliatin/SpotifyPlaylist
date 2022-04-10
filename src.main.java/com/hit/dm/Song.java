package com.hit.dm;

import java.io.Serializable;

public class Song implements Serializable {
    private String SongArtist;
    private String SongName;
    private String SongGenre;
    private String SongLink;

    public String getSongArtist() {
        return SongArtist;
    }

    public void setSongArtist(String songArtist) {
        SongArtist = songArtist;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getSongGenre() {
        return SongGenre;
    }

    public void setSongGenre(String songGenre) {
        SongGenre = songGenre;
    }

    public String getSongLink() {
        return SongLink;
    }

    public void setSongLink(String songLink) {
        SongLink = songLink;
    }

    public Song(String songName,String songArtist,  String songGenre, String songLink) {
        SongArtist = songArtist;
        SongName = songName;
        SongGenre = songGenre;
        SongLink = songLink;
    }

    public Song() {
    }

    @Override
    public String toString() {
        return SongName+";"+SongArtist+";"+SongGenre+";"+SongLink;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Song other = (Song) obj;
        return SongName.equals(other.SongName) &&
                SongArtist.equals(other.SongArtist) &&
                SongGenre.equals(other.SongGenre) &&
                SongLink.equals(other.SongLink);
    }
}
