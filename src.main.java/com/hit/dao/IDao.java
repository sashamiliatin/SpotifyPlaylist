package com.hit.dao;

import com.hit.dm.Song;

import java.util.List;

public interface IDao <T> {

    List<Song> getGame(String searchVal);
    void saveSong(T t);
    void updateSong(String songName, String updateVal);
    void deleteSong(String songName);
}
