package Model;

import java.util.*;
import java.text.ParseException;

public class PersoanaManager {
    private static int numarUnicPersoana = 0;

    public static void cresteNumarUnicPersoana (int x){
        PersoanaManager.numarUnicPersoana += x;
    }

    public Persoana crearePersoana(Scanner in) throws ParseException{
        return new Persoana(numarUnicPersoana++, in);
    }

}

