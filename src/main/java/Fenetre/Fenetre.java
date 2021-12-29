package Fenetre;

import Planetes.planete;
import eduPrinceton.Draw;
import eduPrinceton.DrawListener;
import eduPrinceton.StdDraw;
import horloge.HorlogeUniverselle;

import java.util.List;

import java.awt.*;

public class Fenetre implements DrawListener {

    //Attributs
    private double mouseX;
    private double mouseY;
    private int longueur;
    private int hauteur;

    boolean continu = true;
    Draw d = new Draw("Systeme Solaire");

    List<planete> planetes;

    //Constructeur

    public Fenetre(int x, int y) {
        this.hauteur = y;
        this.longueur = x;
        d.setCanvasSize(longueur,hauteur);
        d.addListener(this);
        d.enableDoubleBuffering();
    }

    public Fenetre() {
        this(800,800);
    }

    public boolean isContinu() { return continu; }

    public void setPlanetes(List<planete> planetes) {
        this.planetes = planetes;
    }

    //Méthode
    public void affiche(List<planete> planetes, HorlogeUniverselle horloge){
        d.clear(Color.black);

        for ( planete p : planetes ) {
            d.setPenColor(p.getCouleur());
            d.filledCircle(p.getX(), p.getY(), p.getRayon());
            //d.circle(p.getxCercle(), p.getyCercle(), p.getRayonRevolution());
            d.show();
            p.deplacerPlanete(horloge);
        }
        //Temps d'attendre pour permettre un affichage plus visuel
        d.pause(10);
    }


    @Override
    public void keyTyped(char c) {
        if(c == 's'){
            for ( planete p : planetes ) {
                p.dezoom();
            }
        }else if(c == 'z'){
            for ( planete p : planetes ) {
                p.zoom();
            }
        }
    }




    @Override
    public void mousePressed(double x, double y) {
        System.out.println("x : " + x);
        System.out.println("y : " + y + "\n");
        this.mouseX = x;
        this.mouseY = y;
    }
    @Override
    public void mouseDragged(double x, double y) {

        System.out.println("x : " + x);
        System.out.println("y : " + y + "\n");

        for ( planete p : planetes ) {
            p.deplacerPlanete(-(this.mouseX - x), -(this.mouseY - y));
        }

        this.mouseX = x;
        this.mouseY = y;

    }
    @Override
    public void mouseReleased(double x, double y) {}
    @Override
    public void mouseClicked(double x, double y) {}
    @Override
    public void keyPressed(int keycode) {}
    @Override
    public void keyReleased(int keycode) {}
}
