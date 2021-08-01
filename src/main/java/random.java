import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random r = new Random();


        for (int i = 0; i <= 20; i++){

            int a = r.nextInt(17 - 15 + 1) + 15;
            int b = r.nextInt(59 - 10 + 1) + 10;
            System.out.println(a + ":" + b + " ");
        }
    }
}
