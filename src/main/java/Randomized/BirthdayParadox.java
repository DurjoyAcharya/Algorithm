package Randomized;

public class BirthdayParadox {
    private static double BirthdayBash(double p)
    {

        return Math.ceil(Math.sqrt(2 *
                365 * Math.log(1 / (1 - p))));
    }
    public static void main(String[] args) {
        System.out.println(BirthdayBash(.8));
    }
}
