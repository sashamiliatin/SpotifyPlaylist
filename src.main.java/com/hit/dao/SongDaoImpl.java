package com.hit.dao;

import com.hit.algorithm.NaiveSearchImp; // Import the Search algorithm
import com.hit.dm.Song; // Import the Song class

import java.io.*;
import java.util.*;

public class SongDaoImpl implements IDao<Song>{

    private String path = "src.main.resources/Datasource.txt";
    @Override
    public List<Song> searchSongs(String searchVal) throws IOException {
        NaiveSearchImp algo = new NaiveSearchImp();
        List<Song> songList=new ArrayList<>();
        try {
            ObjectInputStream in= new ObjectInputStream(new FileInputStream(path));
            Map<String,Song> songs = (Map<String,Song>)in.readObject();
            in.close();
            if (!songs.isEmpty()){
                songs.forEach((k,v)->{if (algo.search(v.toString(),searchVal)==1){songList.add(v);}});
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public void saveSong(Song song) throws IOException {
        Map<String,Song> songList = getAllSongs();
        if (!songList.isEmpty()){
            if (!songList.containsKey(song.getSongLink())){
                ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(path));
                songList.put(song.getSongLink(), song);
                out.writeObject(songList);
                out.close();
            }
            else{
                System.out.println("Song All ready exist");
            }
        }
        else {
            songList.put(song.getSongLink(), song);
            ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(songList);
            out.close();
        }
    }

    @Override
    public void updateSong(String songName, String updateVal) {

    }

    @Override
    public void deleteSong(Song song) throws IOException, ClassNotFoundException {
        Map<String,Song> songList = getAllSongs();
        if (!songList.isEmpty()){
            if (songList.containsKey(song.getSongLink())){
                ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(path));
                songList.remove(song.getSongLink());
                out.writeObject(songList);
                out.close();
                System.out.println("Song: "+song.getSongName()+" Was deleted");
            }
            else {
                System.out.println("No song was found");
            }

        }
        else {
            System.out.println("Song List Is empty!!!");
        }
    }

    @Override
    public Map<String,Song> getAllSongs() throws IOException {
        ObjectInputStream in = null;
        try {
             in= new ObjectInputStream(new FileInputStream(path));
        } catch (IOException e) {
            Map<String,Song> songs = new HashMap<>();
            return songs;
        }

        Map<String,Song> songs = new HashMap<>();
        try {
            songs = (Map<String,Song>)in.readObject();
        } catch (IOException e) {
            in.close();
            return songs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
