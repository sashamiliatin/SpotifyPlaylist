import com.hit.algorithm.*;
import com.hit.dao.SongDaoImpl;
import com.hit.dm.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        Integer matches ;
        List<Song> songList=new ArrayList<>();
        NaiveSearchImp algo = new NaiveSearchImp();
        matches = algo.search("ausdjahsdastest`sdksajhdk", "test");
        System.out.println(matches);
        SongDaoImpl dao = new SongDaoImpl();
//        songList =dao.getSong("official");
////        for (Song song:songList) {
////
////            System.out.println(song.toString());
////        }
        Song song = new Song("Balada","Sasha","Shtoot","LinkToSong");
        Song song1 = new Song("Balada1","Sasha1","Shtoot1","LinkToSong1");
        Song song2 = new Song("Balada2","Sasha2","Shtoot2","LinkToSong2");
        boolean booll = dao.saveSong(song);
        dao.saveSong(song1);
        dao.saveSong(song2);
        songList =dao.searchSongs("Sasha");
        System.out.println(songList+"\n");
        dao.deleteSong(song);

    }

}
