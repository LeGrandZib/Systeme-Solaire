package horloge;

import java.util.Date;

public class HorlogeUniverselle implements Runnable{

    //Attributs
    private final int joursParSeconde;
    private Date dateSimu;
    private Date dateReel;

    private boolean continu = true;

    //Constructeurs
    public HorlogeUniverselle(int joursParSeconde) {
        this.joursParSeconde = joursParSeconde;
        dateSimu = new Date(System.currentTimeMillis());
        dateReel = new Date(System.currentTimeMillis());
    }

    public HorlogeUniverselle(){
        this(15);
    }


    //Méthodes

    public void stop() {
        continu = false;
    }

    @Override
    public String toString() {
        return "HorlogeUniverselle{" +
                "joursParSeconde=" + joursParSeconde +
                ", date=" + dateSimu +
                ", instant=" + dateReel +
                '}';
    }

    public int getJoursParSeconde() {
        return joursParSeconde;
    }

    public Date getDateSimu() {
        return dateSimu;
    }

    public Date getDateReel() {
        return dateReel;
    }

    //Mise à jour de la date simulée de l'horloge universelle
    @Override
    public void run(){
        while(continu) {
            Date dateReel2 = new Date(System.currentTimeMillis());

            if (dateReel2.after(dateReel)) {
                //calcule le nombre de secondes de différence entre la date sauvegardée et l'instant présent et les
                //convertis en jours selon l'échelle précédemment choisie
                long res = joursParSeconde*86400 * (dateReel2.getTime() - dateReel.getTime()) / 1000;
                dateSimu.setTime(dateSimu.getTime()+res);

                //Met à jour la date réelle
                dateReel = dateReel2;
            }
        }
    }
}
