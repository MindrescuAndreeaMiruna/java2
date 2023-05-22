package Model;
import java.util.*;
import java.text.ParseException;


public class BiletManager {
    private static int numarUnicBilet = 0;
    public static void cresteNumarUnicBilet(int i){
        BiletManager.numarUnicBilet += i;
    }

    public Bilet creareBilet(Scanner in) throws ParseException{
        return new Bilet(numarUnicBilet++, in);
    }
}
