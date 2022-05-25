package com.hit.server;
import com.hit.dm.Song;
import java.util.List;
import java.util.Map;

public class Request {

    private Map <String, String> headers;
    private Map <String, String> body;

    public Request(Map<String, String> headers, Map <String, String> body) {
        this.headers = headers;
        this.body = body;
    }

    public Request(List<Song> songs) {

    }


    public Map <String, String> getBody() {
        return body;
    }


    public void setBody(Map <String, String> body) {
        this.body = body;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }


    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }


    @Override
    public String toString() {
        return "{'headers':'" + headers + "', 'body':'" + body + "'}";
    }
}
