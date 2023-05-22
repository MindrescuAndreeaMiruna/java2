package Model;

import java.util.*;
import java.text.*;
import java.io.*;

public class AvionSingleton {
    private static AvionSingleton instantaAvion = null;
    final private AvionManager avionManager = new AvionManager();

    private List<Avion> avioane = new ArrayList<>();

    public void setAvioane(List<Avion> avioane){
        this.avioane = avioane;
    }

    public List<Avion> getAvioane(){
        return avioane;
    }
    public static AvionSingleton getInstance(){
        if(instantaAvion == null)
            instantaAvion = new AvionSingleton();
        return instantaAvion;
    }

   /* private static List<String[]> readCSV(String numeFisier){
        List<String[]> coloane = new ArrayList<>();

        // tratam erorile
        // inspiratie: javatpoint.com - how to read and parse csv file in java

        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))){
            String linie;
            while((linie = reader.readLine()) != null){
                String[] campuri = linie.replaceAll(" ", "").split(",");
                coloane.add(campuri);

            }
        } catch(IOException e){
            System.out.println("A intervenit o eroare.");
        }
        return coloane;
    }

    */

    private static List<String[]> readCSV(String numeFisier) {
        List<String[]> coloane = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] campuri = linie.replaceAll("\\s", "").split(",");
                coloane.add(campuri);
            }
        } catch (IOException e) {
            System.out.println("A intervenit o eroare.");
        }
        return coloane;
    }



    public void getCSV(){

        //inspiratie : how to read csv file in java - geeksforgeeks

        List<String[]> coloane = AvionSingleton.readCSV("data_final/avion.csv");
        for (String[] campuri : coloane) {
            if (campuri.length == 8) {
                Avion avionNou = new Avion(
                        Integer.parseInt(campuri[0]),
                        Integer.parseInt(campuri[1]),
                        campuri[2],
                        Integer.parseInt(campuri[3]),
                        Integer.parseInt(campuri[4]),
                        campuri[5],
                        campuri[6],
                        Integer.parseInt(campuri[7])
                );
                avioane.add(avionNou);
            } else {
                System.out.println("Rândul din fișier nu conține toate câmpurile necesare.");
            }
        }

        PersoanaManager.cresteNumarUnicPersoana(coloane.size());
    }

    public void writeCSV() {
        try {
            FileWriter writer = new FileWriter("data_final/avion.csv");
            for (Avion avion : AvionSingleton.getInstance().getAvioane()) {
                writer.write(avion.CSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public void addAvion(Avion avion) {
        avioane.add(avion);
        writeCSV();
    }


}
