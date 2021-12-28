package horloge;

import java.util.Date;

public class HorlogeUniverselle{
    private final int joursParSeconde;
    private Date dateSimu;
    private Date dateReel;

    public HorlogeUniverselle(int joursParSeconde) {
        this.joursParSeconde = joursParSeconde;
        dateSimu = new Date(System.currentTimeMillis());
        dateReel = new Date(System.currentTimeMillis());
    }

    public HorlogeUniverselle(){
        this(15);
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

    public void majHorloge(){
        Date dateReel2 = new Date(System.currentTimeMillis());

        if(dateReel2.after(dateReel)){
            dateSimu.setDate((int)
                    (dateSimu.getDate()+(
                            joursParSeconde*(dateReel2.getTime()-dateReel.getTime())/1000)
                    ));
        }

        dateReel=dateReel2;
    }
}
