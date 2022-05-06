package com.hit.dao;

import com.hit.dm.Song;

import java.util.List;
import java.util.Map;

public interface IDao <T> {

    List<Song> searchSongs(String searchVal)throws Exception;
    void saveSong(T t)throws Exception;
    void updateSong(String songName, String updateVal)throws Exception;
    void deleteSong(Song song)throws Exception;
    Map<String,Song> getAllSongs()throws Exception;
}
