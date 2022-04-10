package com.hit.dao;

import com.hit.algorithm.NaiveSearchImp; // Import the Search algorithm
import com.hit.dm.Song; // Import the Song class

import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files


import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl implements IDao<Song>{

    private String path = "src.main.resources/Datasource.txt";
    private String temp ="src.main.resources/Datasource.tmp";
    @Override
    public List<Song> searchSongs(String searchVal) throws IOException {
        NaiveSearchImp algo = new NaiveSearchImp();
        List<Song> songList=new ArrayList<>();
        BufferedReader myReader = null;
        Scanner scan =null;
        Song song = null;
        try {
            myReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = myReader.readLine())!=null) {
                scan = new Scanner(line);
                scan.useDelimiter(";");
                song = new Song(scan.next(),scan.next(),scan.next(),scan.next());
                if(algo.search(song.toString(),searchVal)==1){
                    songList.add(song);
                }

            }
            myReader.close();
            return songList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public boolean saveSong(Song song) throws IOException {
        List<Song> songList;
        PrintWriter output = null;
        songList = getAllSongs();
        if (!songList.contains(song)) {
            try {
                output = new PrintWriter(new FileWriter(path,true));
                output.println(song.toString());
                output.close();
                return true;
            }
            // Catch block to handle if exception occurs
            catch (IOException e) {

                // Print the exception
                System.out.print(e.getMessage());
                return false;
            }
        }
        else {
            System.out.print("Song with the same content already exist\n");
            return false;
        }
    }

    @Override
    public void updateSong(String songName, String updateVal) {

    }

    @Override
    public void deleteSong(Song song) throws IOException {
        File tempFile = new File(temp);
        List<Song> songs = getAllSongs();
        try{
            PrintWriter output = new PrintWriter(new FileWriter(tempFile, true));
            for (Song song1:songs) {
                if (!song1.equals(song)){
                    output.println(song1.toString());
                    output.flush();
                }
            }
            output.close();
            File file = new File(path);
            //Rename the new file to the filename the original file had.
            tempFile = new File(temp);
            if (!tempFile.renameTo(file))
                System.out.println("Could not rename file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> getAllSongs() throws IOException {
        List<Song> songList=new ArrayList<>();
        BufferedReader myReader = null;
        Scanner scan =null;
        Song song = null;
        try {
            myReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = myReader.readLine())!=null) {
                scan = new Scanner(line);
                scan.useDelimiter(";");
                song = new Song(scan.next(),scan.next(),scan.next(),scan.next());
                songList.add(song);

            }
            myReader.close();
            return songList;
        } catch (IOException e) {
            return songList;
        }
    }
}
