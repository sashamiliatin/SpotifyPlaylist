package com.hit.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.hit.dm.Song;
import com.hit.service.SongService;

public class SongController {

    static SongService service = new SongService();


    public List<Song> searchSong(String searchVal,boolean user) {
        return service.searchSong(searchVal, user);
    }

    public boolean deleteSong(String songLink, boolean user){
        return service.deleteSong(songLink, user);
    }

    public boolean updateSong(String field, String updateVal, String songLink){
        return service.updateSong(field,updateVal,songLink);
    }

    public boolean addSong(Song song, boolean user) throws IOException {
        return service.addSong(song, user);
    }

    public Map<String,Song> getAllSongs(boolean user){
        return service.getAllSongs(user);
    }
}
