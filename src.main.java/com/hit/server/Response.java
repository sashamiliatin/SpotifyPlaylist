package com.hit.server;

import com.hit.dm.Song;
import java.util.List;


public class Response {
    public String json;
    public List<Song> songs;

    public Response(){}


    public Response(List<Song> songs){ this.songs = songs;}


    public Response(String string){
        json = string;
    }

    public String toString() {
        return  "{'Songs':" + songs + "', 'json':'" + json + "'}";
    }

}
