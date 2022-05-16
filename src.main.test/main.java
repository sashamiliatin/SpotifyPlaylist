import com.hit.algorithm.*;
import com.hit.dao.SongDaoImpl;
import com.hit.dm.Song;
import com.hit.service.SongService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Integer matches ;
        List<Song> songList=new ArrayList<>();
        NaiveSearchImp algo = new NaiveSearchImp();
        matches = algo.search("ausdjahsdastest`sdksajhdk", "test");
        System.out.println(matches);
        SongDaoImpl dao = new SongDaoImpl();
        Song song = new Song("Balada","Sasha","Shtoot","LinkToSong");
        Song song1 = new Song("Balada1","Sasha1","Shtoot1","LinkToSong1");
        Song song2 = new Song("Balada2","Sasha2","Shtoot2","LinkToSong2");
//        dao.saveSong(song);
//        dao.saveSong(song1);
//        dao.saveSong(song2);
        SongService service = new SongService();
        service.userAddSong(song);
        service.userAddSong(song1);
        service.userAddSong(song2);
        service.adminAddSong(song);
        service.adminAddSong(song2);
        songList = service.userSearchSong("sasha");
//        songList =dao.searchSongs("Sasha");
        System.out.println(songList+"\n");
        service.userDeleteSong(song);
//        dao.deleteSong(song);
//        System.out.println(dao.getAllSongs());
//        System.out.println(service.);

        service.adminUpdateSong("Name", "blablsa", song2);
        System.out.println(service.adminGetAllSongs().values());

        service.adminUpdateSong("Link", "1234", song2);

        System.out.println(service.adminGetAllSongs().values());


    }

}
