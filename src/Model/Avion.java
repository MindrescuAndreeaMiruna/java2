package Model;

import java.text.ParseException;
import java.text.*;
import java.util.*;

public class Avion implements MijlocDeTransport{
    private int distantaMaxima;
    private int numarPasageri;
    private String serieAvion;
    private int capacitateKerosen;
    private int consumKerosenMediu;
    private String orasPlecare;
    private String orasDestinatie;
    private final int idAvion;

    public Avion(int distantaMaxima, int numarPasageri, String serieAvion, int capacitateKerosen, int consumKerosenMediu, String orasPlecare, String orasDestinatie, int idAvion) {
        this.distantaMaxima = distantaMaxima;
        this.numarPasageri = numarPasageri;
        this.serieAvion = serieAvion;
        this.capacitateKerosen = capacitateKerosen;
        this.consumKerosenMediu = consumKerosenMediu;
        this.orasPlecare = orasPlecare;
        this.orasDestinatie = orasDestinatie;
        this.idAvion = idAvion;
    }

    public Avion(int idAvion, Scanner in) throws ParseException{
        this.idAvion = idAvion;
        this.reading(in);
    }


    public void reading(Scanner in) throws ParseException{
        System.out.println("Distanta maxima pe care o poate parcurge avionul: ");
        this.distantaMaxima = Integer.parseInt(in.nextLine());
        System.out.println("Numarul de pasageri: ");
        this.numarPasageri = Integer.parseInt(in.nextLine());
        System.out.println("Seria avionului este: ");
        this.serieAvion = in.nextLine();
        System.out.println("Capacitatea de combustibil a avionului este: ");
        this.capacitateKerosen = Integer.parseInt(in.nextLine());
        System.out.println("Consumul mediu de kerosen al avionului este: ");
        this.consumKerosenMediu = Integer.parseInt(in.nextLine());
        System.out.println("Orasul de plecare al avionului este: ");
        this.orasPlecare = in.nextLine();
        System.out.println("Orasul de destinatie al avionului este: ");
        this.orasDestinatie = in.nextLine();

    }

    public String CSV(){
        return idAvion + "," +
                distantaMaxima + "," +
                numarPasageri + "," +
                serieAvion + "," +
                capacitateKerosen + "," +
                consumKerosenMediu + "," +
                orasPlecare + "," +
                orasDestinatie;
    }


    public int getIdAvion() {
        return idAvion;
    }

    public void setDistantaMaxima(int distantaMaxima) {
        this.distantaMaxima = distantaMaxima;
    }

    public double getDistantaMaxima() {
        return distantaMaxima;
    }

    public void setNumarPasageri(int numarPasageri) {
        this.numarPasageri = numarPasageri;
    }

    public void setSerieAvion(String serieAvion) {
        this.serieAvion = serieAvion;
    }

    public void setCapacitateKerosen(int capacitateKerosen) {
        this.capacitateKerosen = capacitateKerosen;
    }

    public void setConsumKerosenMediu(int consumKerosenMediu) {
        this.consumKerosenMediu = consumKerosenMediu;
    }

    public void setOrasPlecare(String orasPlecare) {
        this.orasPlecare = orasPlecare;
    }

    public void setOrasDestinatie(String orasDestinatie) {
        this.orasDestinatie = orasDestinatie;
    }


    public int getNumarPasageri() {
        return numarPasageri;
    }

    public String getSerieAvion() {
        return serieAvion;
    }

    public double getCapacitateKerosen() {
        return capacitateKerosen;
    }

    public double getConsumKerosenMediu() {
        return consumKerosenMediu;
    }

    public String getOrasPlecare() {
        return orasPlecare;
    }

    public String getOrasDestinatie() {
        return orasDestinatie;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "distantaMaxima=" + distantaMaxima +
                ", numarPasageri=" + numarPasageri +
                ", serieAvion='" + serieAvion + '\'' +
                ", capacitateKerosen=" + capacitateKerosen +
                ", consumKerosenMediu=" + consumKerosenMediu +
                ", orasPlecare='" + orasPlecare + '\'' +
                ", orasDestinatie='" + orasDestinatie + '\'' +
                ", idAvion=" + idAvion +
                '}';
    }

    @Override
    public String ruta() {
        return "Avionul are ruta " + this.orasPlecare + " - " + this.orasDestinatie;
    }


}
