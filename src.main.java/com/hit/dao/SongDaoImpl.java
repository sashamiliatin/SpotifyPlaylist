package com.hit.dao;

import com.hit.dm.Song;

import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl implements IDao<Song>{
    @Override
    public List<Song> getGame(String searchVal) {
        List<Song> songList=new ArrayList<>();
        int result = 0;
//        try {
//            for(String id: generator.idSet) {
//                Gson gson = new Gson();
//                Reader reader = Files.newBufferedReader(Paths.get(path + id + ".json"));
//
//                Game game = gson.fromJson(reader, Game.class);
//                Text = game.toString();
//
//                KMP kmp = new KMP(Text , searchVal);
//                String txt = kmp.getTxt();
//                String pat = kmp.getPat();
//                result = kmp.Search(txt, pat);
//
//                if (result == 1)
//                    gameList.add(game);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        return songList;
    }

    @Override
    public void saveSong(Song song) {

    }

    @Override
    public void updateSong(String songName, String updateVal) {

    }

    @Override
    public void deleteSong(String songName) {

    }
}
