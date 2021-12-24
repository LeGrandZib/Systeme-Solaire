package Fenetre;

import Planetes.planete;
import eduPrinceton.Draw;
import eduPrinceton.DrawListener;

import java.util.List;

import java.awt.*;

public class Fenetre implements DrawListener {

    //Attributs
    boolean continu = true;
    Draw d = new Draw("Systeme Solaire");


    //Constructeur
    public Fenetre() {
        d.setCanvasSize(800,800);
        d.addListener(this);
    }

    public boolean isContinu() { return continu; }

    //Méthode
    public void affiche(List<planete> planetes){
        d.clear(Color.black);

        for ( planete p : planetes ) {
            d.setPenColor(p.getCouleur());
            d.filledCircle(p.getX(), p.getY(), p.getRayon());
            //d.circle(p.getxCercle(), p.getyCercle(), p.getRayonRevolution());
            p.deplacerPlanete();
        }
        //Temps d'attendre pour permettre un affichage plus visuel
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(char c) {
        if(c == 's'){
            continu = false;
        }
    }


    @Override
    public void mousePressed(double x, double y) {}
    @Override
    public void mouseDragged(double x, double y) {}
    @Override
    public void mouseReleased(double x, double y) {}
    @Override
    public void mouseClicked(double x, double y) {}
    @Override
    public void keyPressed(int keycode) {}
    @Override
    public void keyReleased(int keycode) {}
}
