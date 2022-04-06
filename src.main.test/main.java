import com.hit.algorithm.*;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Integer matches ;
        NaiveSearchImp algo = new NaiveSearchImp();
        matches = algo.search("ausdjahsdastest`sdksajhdk", "test");
        System.out.println(matches);
    }

}
