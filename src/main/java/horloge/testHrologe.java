package horloge;

public class testHrologe {
    public static void main(String[] args) {
        HorlogeUniverselle h = new HorlogeUniverselle(5);
        System.out.println(h);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.majHorloge();

        System.out.println(h);
    }
}
