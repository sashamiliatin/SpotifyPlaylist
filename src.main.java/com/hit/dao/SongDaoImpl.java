package com.hit.dao;

import com.hit.algorithm.NaiveSearchImp; // Import the Search algorithm
import com.hit.dm.Song; // Import the Song class

import java.io.*;
import java.util.*;

public class SongDaoImpl implements IDao<Song>{

    private String user_path = "src.main.resources/Datasource.txt";
    private String admin_path = "src.main.resources/Datasource1.txt";
    @Override
    public List<Song> searchSongs(String searchVal,boolean user) {
        String filePath = null;
        if (user){filePath = user_path;}
        else {filePath = admin_path;}
        NaiveSearchImp algo = new NaiveSearchImp();
        List<Song> songList=new ArrayList<>();
        try {
            ObjectInputStream in= new ObjectInputStream(new FileInputStream(filePath));
            Map<String,Song> songs = (Map<String,Song>)in.readObject();
            in.close();
            if (!songs.isEmpty()){
                songs.forEach((k,v)->{if (algo.search(v.toString(),searchVal)==1){songList.add(v);}});
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public boolean saveSong(Song song,boolean user) throws IOException {
        String filePath = null;
        if (user){filePath = user_path;}
        else {filePath = admin_path;}
        Map<String,Song> songList = getAllSongs(user);
        ObjectOutputStream out = null;
        if (!songList.isEmpty()){
            if (!songList.containsKey(song.getSongLink())){
                try{
                     out= new ObjectOutputStream(new FileOutputStream(filePath));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                songList.put(song.getSongLink(), song);
                out.writeObject(songList);
                out.close();
                return true;
            }
            else{
                System.out.println("Song All ready exist");
                return false;
            }
        }
        else {
            songList.put(song.getSongLink(), song);
            out= new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(songList);
            out.close();
            return false;
        }
    }

    @Override
    public boolean updateSong(String songName, String updateVal , boolean user) {
    return true;
    }

    @Override
    public boolean deleteSong(Song song, boolean user) {
        String filePath = null;
        if (user){filePath = user_path;}
        else {filePath = admin_path;}
        Map<String,Song> songList = getAllSongs(user);
        ObjectOutputStream out = null;
        if (!songList.isEmpty()){
            if (songList.containsKey(song.getSongLink())){
                try{
                     out= new ObjectOutputStream(new FileOutputStream(user_path));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

                songList.remove(song.getSongLink());
                try {
                    out.writeObject(songList);
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

                System.out.println("Song: "+song.getSongName()+" Was deleted");
                return true;
            }
            else {
                System.out.println("No song was found");
                return false;
            }

        }
        else {
            System.out.println("Song List Is empty!!!");
            return false;
        }
    }

    @Override
    public Map<String,Song> getAllSongs(boolean user) {
        String filePath = null;
        if (user){filePath = user_path;}
        else {filePath = admin_path;}
        ObjectInputStream in = null;
        try {
             in= new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            Map<String,Song> songs = new HashMap<>();
            return songs;
        }

        Map<String,Song> songs = new HashMap<>();
        try {
            songs = (Map<String,Song>)in.readObject();
            in.close();
        } catch (IOException e) {
            try{
                in.close();
                return songs;
            } catch (IOException ex) {
                ex.printStackTrace();
                return songs;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
