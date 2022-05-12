package com.hit.service;

import com.hit.dao.SongDaoImpl;
import com.hit.dm.Song;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SongService {

    SongDaoImpl songDao;
    public SongService() {
        this.songDao = new SongDaoImpl();//songDao;
    }


    public List<Song> userSearchSong(String search) {
        List<Song> songs = songDao.searchSongs(search,true);
        if(songs.isEmpty())
            return null;
        return songs;
    }
    public List<Song> adminSearchSong(String search) {
        List<Song> songs = songDao.searchSongs(search,false);
        if(songs.isEmpty())
            return null;
        return songs;
    }

    public boolean userDeleteSong(Song song) {
        return songDao.deleteSong(song,true);
    }

    public boolean adminDeleteSong(Song song) {
        return songDao.deleteSong(song,false);
    }

    public boolean userAddSong(Song song) throws IOException {
        return songDao.saveSong(song,true);
    }

    public boolean adminAddSong(Song song) throws IOException {
        return songDao.saveSong(song,false);
    }

    public Map<String,Song> userGetAllSongs(){
        return songDao.getAllSongs(true);
    }

    public Map<String,Song> adminGetAllSongs(){
        return songDao.getAllSongs(false);
    }

//    public boolean editSong(Song song) {
//        if(book == null)
//            return false;
//        return bookDao.save(book);
//    }
}
