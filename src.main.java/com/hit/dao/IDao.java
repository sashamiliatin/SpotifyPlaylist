package com.hit.dao;

import com.hit.dm.Song;

import java.util.List;
import java.util.Map;

public interface IDao <T> {

    List<Song> searchSongs(String searchVal, boolean user)throws Exception;
    boolean saveSong(T t,boolean user)throws Exception;
    boolean updateSong(String field, String updateVal, Song song)throws Exception;
    boolean deleteSong(Song song,boolean user)throws Exception;
    Map<String,Song> getAllSongs(boolean user)throws Exception;
}
