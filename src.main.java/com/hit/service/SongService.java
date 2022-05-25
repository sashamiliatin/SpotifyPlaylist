package com.hit.service;

import com.hit.dao.SongDaoImpl;
import com.hit.dm.Song;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SongService {

    SongDaoImpl songDao;
    public SongService() {
        this.songDao = new SongDaoImpl();//songDao;
    }


    public List<Song> searchSong(String search,boolean user) {
        List<Song> songs = songDao.searchSongs(search,user);
        if(songs.isEmpty())
            return Collections.EMPTY_LIST;
        return songs;
    }

    public boolean deleteSong(String songLink, boolean user) {
        return songDao.deleteSong(songLink,user);
    }

    public boolean updateSong(String field, String updateVal, String songLink) {
        return songDao.updateSong(field,updateVal,songLink);
    }

    public boolean addSong(Song song,boolean user) throws IOException {
        return songDao.saveSong(song,user);
    }

    public Map<String,Song> getAllSongs(boolean user){
        return songDao.getAllSongs(user);
    }

}
