package horloge;

import java.util.Date;

public class HorlogeUniverselle implements Runnable{

    //Attributs
    private  int joursParSeconde;
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

    public void setJoursParSeconde(int joursParSeconde) {
        if(joursParSeconde >=0) {
            this.joursParSeconde = joursParSeconde;
        }
    }

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

    //incrémenter l'échelle de l'horloge
    public void incJPS(){
        joursParSeconde+=10;
    }

    //décrémenter l'échelle de l'horloge
    public void decJPS(){
        if(joursParSeconde+10>0){
            joursParSeconde-=10;
        }
    }

    //mettre en pause l'horloge
    public void playPause(int JPS){
        if (joursParSeconde!=0) {
            setJoursParSeconde(0);
        } else {
            setJoursParSeconde(JPS);
        }
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
