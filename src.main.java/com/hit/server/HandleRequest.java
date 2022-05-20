package com.hit.server;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hit.controller.SongController;
import com.hit.dm.Song;
import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Scanner;

public class HandleRequest implements Runnable {
    Socket socket;
    Scanner reader;
    PrintWriter writer;
    Gson gson = new GsonBuilder().create();
    SongController controller = new SongController();


    public HandleRequest(Socket socket) throws IOException{
        this.socket = socket;
        reader = new Scanner((new InputStreamReader(socket.getInputStream())));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run(){
        try{

            Type type = new TypeToken<Request>(){}.getType();
            System.out.println(reader.next());
            Request request = gson.fromJson(reader.next(), type);
            Response response = null;

            String command = request.getHeaders().get("action");
            switch (command) {
                case "admin/songs" -> {
                    response = new Response(controller.searchSong(request.getBody(),false));
                }
                case "user/songs" -> {
                    response = new Response(controller.searchSong(request.getBody(),true));
                }
                case "user/save" -> {

                    Song song = new Song();
                    song.setSongName(request.getHeaders().get("SongName"));
                    song.setSongGenre(request.getHeaders().get("Genre"));
                    song.setSongArtist(request.getHeaders().get("Artist"));
                    song.setSongLink(request.getHeaders().get("Link"));

                    controller.addSong(song,true);
                    response = new Response("Song "+song.getSongName()+" was added to user playlist");

                }
                case "admin/save" -> {

                    Song song = new Song();
                    song.setSongName(request.getHeaders().get("SongName"));
                    song.setSongGenre(request.getHeaders().get("Genre"));
                    song.setSongArtist(request.getHeaders().get("Artist"));
                    song.setSongLink(request.getHeaders().get("Link"));

                    controller.addSong(song,false);
                    response = new Response("Song "+song.getSongName()+" was added to admin playlist");

                }
                case "song/update" -> {

                    String songLink = request.getHeaders().get("Link");
                    String update = request.getHeaders().get("toUpdate");
                    String val = request.getHeaders().get("Val");
                    controller.updateSong(update,val,songLink);

                    response = new Response("1");
                }
                case "user/delete" -> {
                    String songLink = request.getBody();
                    controller.deleteSong(songLink,true);
                    response = new Response("Song with Link "+songLink+" was deleted from admin");
                }
                case "admin/delete" -> {
                    String songLink = request.getBody();
                    controller.deleteSong(songLink,false);
                    response = new Response("Song with Link "+songLink+" was deleted from user");
                }
            }
            if(response != null) {
                writer.println(gson.toJson(response));
                writer.flush();
            }
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e){
            System.out.println("Server error");
        }
    }
}
