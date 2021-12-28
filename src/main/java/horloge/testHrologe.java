package horloge;

public class testHrologe {
    public static void main(String[] args) {

        HorlogeUniverselle h = new HorlogeUniverselle(5);

        Thread horloge = new Thread(h);
        System.out.println();

        horloge.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(horloge);
    }
}
