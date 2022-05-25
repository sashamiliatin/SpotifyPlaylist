package com.hit.server;

import com.hit.dm.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Response {
    public String json;
    public List<Song> songs;

    public Response(){}

    public Response(Map<String,Song> songMap){
        List<Song> al = new ArrayList<>(songMap.values());
        this.songs = al;}
    public Response(List<Song> songs){ this.songs = songs;}


    public Response(String string){
        json = string;
    }

    public String toString() {
        return  "{'Songs':" + songs + "', 'json':'" + json + "'}";
    }

}
