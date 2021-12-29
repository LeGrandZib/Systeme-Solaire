package Systeme;

import eduPrinceton.Draw;
import Planetes.planete;
import Fenetre.Fenetre;
import horloge.HorlogeUniverselle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class UseSysteme {
    public static void main(String[] args) {

        //Création fenetre

        Fenetre f = new Fenetre();

        HorlogeUniverselle horloge = new HorlogeUniverselle(1);
        Thread threadHorloge = new Thread(horloge);

        //Constante rotationTerre (toutes les autres planètes se déplacent autour du soleil en fonction de la période de révolution de la Terre)
        final double rotationTerre = 0.02;

        //Création des planetes

        planete soleil = new planete(Color.orange);

        planete mercure = new planete(0.57 + soleil.getRayon(), 0.5, 0.005, 360/87.96, Color.gray); //88 jours
        planete venus = new planete(0.64 + soleil.getRayon(), 0.5, 0.01, 360/224.69, Color.pink);// 224 jours
        planete terre = new planete(0.7 + soleil.getRayon(), 0.5, 0.02, 360/365.25, Color.green); // 365 jours
        planete mars = new planete(0.8 + soleil.getRayon(), 0.5, 0.007, 360/686.97, 247, 111, 82); // 687 jours
        planete jupiter = new planete(1.54 + soleil.getRayon(), 0.5, 0.03, 360/4332.589, 217, 174, 81); // 4 332 jours
        planete saturne = new planete(2.41 + soleil.getRayon(), 0.5, 0.028, 360/10759.23, 225, 199, 117); // 10 759 jours
        planete uranus = new planete(4.33 + soleil.getRayon(), 0.5, 0.023, 360/30685.4, Color.white); // 30 685 jours
        planete neptune = new planete(6.5 + soleil.getRayon(), 0.5, 0.0235, 360/60216.8, Color.blue); // 60 216 jours

        List<planete> planetes;
        planetes = Arrays.asList(soleil, mercure, venus, terre, mars, jupiter, saturne, uranus, neptune);

        //Affichage des planetes + évolution
        // 's' pour arrêter

        f.setPlanetes(planetes);

        threadHorloge.start();

        while(f.isContinu()){
            f.affiche(planetes, horloge);
        }
    }
}
