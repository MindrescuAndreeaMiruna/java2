
//ETAPA 2

import Model.*;
import Constants.Constants;
import Service.*;
import Service.Implementation.*;

import java.util.*;

import static Constants.Constants.SCOP_AEROPORT;
import java.text.ParseException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean ok = false;
        AvionServiceImpl avionService = new AvionServiceImpl();
        BiletServiceImpl biletService = new BiletServiceImpl();
        PersoanaServiceImpl persoanaService = new PersoanaServiceImpl();
        ZborServiceImpl zborService = new ZborServiceImpl();

        AvionManager avionManager = new AvionManager();
        BiletManager biletManager = new BiletManager();
        PersoanaManager persoanaManager = new PersoanaManager();
        ZborManager zborManager = new ZborManager();

        Audit audit = new Audit();

        AvionSingleton.getInstance().getCSV();
        BiletSingleton.getInstance().getCSV();
        PersoanaSingleton.getInstance().getCSV();
        ZborSingleton.getInstance().getCSV();

        avionService.setAvioane(AvionSingleton.getInstance().getAvioane());
        biletService.setBilete(BiletSingleton.getInstance().getBilete());
        persoanaService.setPersoane(PersoanaSingleton.getInstance().getPersoane());
        zborService.setZboruri(ZborSingleton.getInstance().getZboruri());

        while (!ok) {
            System.out.println("Insereaza comanda: ");
            System.out.println("1: Creare avion: ");
            System.out.println("2: Creare bilet: ");
            System.out.println("3: Creare persoana: ");
            System.out.println("4: Creare zbor: ");
            System.out.println("5: Calculeaza consumul de kerosen al avionului pe care il cream: ");
            System.out.println("6: Afisare date despre persoane: ");
            System.out.println("7: Afisare date despre bilete: ");
            System.out.println("8: Afisare date despre avioane: ");
            System.out.println("9: Afisare date despre zbor: ");
            System.out.println("0: Iesire");
            Avion avion = null;
            String command = in.nextLine();
            try {
                switch (command) {
                    case "1":
                        avion = avionManager.creareAvion(in);
                        audit.denumireActiune("Creare avion nou");
                        break;
                    case "2":
                        biletManager.creareBilet(in);
                        audit.denumireActiune("Creare bilet nou");
                        break;
                    case "3":
                        persoanaManager.crearePersoana(in);
                        audit.denumireActiune("Creare persoana noua");
                        break;
                    case "4":
                        zborManager.creareZbor(in);
                        audit.denumireActiune("Creare zbor nou");
                        break;
                    case "5":
                        avionService.calculConsumKerosen(avionManager.creareAvion(in));
                        audit.denumireActiune("Calculul consumului de kerosen pentru un avion creat");
                        break;
                    case "6":
                        persoanaService.afisarePersoana(in);
                        audit.denumireActiune("Afisare persoana");
                        break;
                    case "7":
                        biletService.afisareBilet(in);
                        audit.denumireActiune("Afisare bilet");
                        break;
                    case "8":
                        avionService.afisareAvion(in);
                        audit.denumireActiune("Afisare avion");
                        break;
                    case "9":
                        zborService.afisareZbor(in);
                        audit.denumireActiune("Afisare zbor");
                        break;
                    case "0":
                        ok = true;
                        break;
                }
                if (avion != null) {
                    AvionSingleton.getInstance().addAvion(avion);
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println('\n');

        }


        PersoanaSingleton.getInstance().setPersoane(persoanaService.getPersoane());
        AvionSingleton.getInstance().setAvioane(avionService.getAvioane());
        BiletSingleton.getInstance().setBilete(biletService.getBilete());
        ZborSingleton.getInstance().setZboruri(zborService.getZbor());

        PersoanaSingleton.getInstance().writeCSV();
        AvionSingleton.getInstance().writeCSV();
        BiletSingleton.getInstance().writeCSV();
        ZborSingleton.getInstance().writeCSV();

    }
}

