package Model;

import java.text.ParseException;
import java.util.*;


public class ZborManager {
    private static int idUnic = 0;

    public static void generateId(int i){
        ZborManager.idUnic += i;
    }

    public Zbor creareZbor(Scanner in) throws ParseException{
        return new Zbor(idUnic++, in);
    }
}
