package com.hit.dao;

import com.hit.dm.Song;

import java.util.List;

public interface IDao <T> {

    List<Song> searchSongs(String searchVal)throws Exception;
    boolean saveSong(T t)throws Exception;
    void updateSong(String songName, String updateVal)throws Exception;
    void deleteSong(Song song)throws Exception;
    List<Song> getAllSongs()throws Exception;
}
