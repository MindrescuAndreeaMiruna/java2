package Service;
import Model.Bilet;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Scanner;


public interface BiletService {
    void addBilet(Bilet bilet) throws Exception;
    //Map<UUID, Bilet> getBilete() throws Exception;
    void setBilete(List<Bilet> bilete);
    Bilet getBiletLista(Scanner in) throws Exception;
    void afisareBilet(Scanner in) throws Exception;
    List<Bilet> getBilete();
}
