package code_to_refactor;

import java.util.Scanner;

public class tabeladlazdjec {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("podaj ilosc zdjęc: ");
        int iloscZdjec = in.nextInt();

        String tablicaZdjec[] = new String[iloscZdjec];
        System.out.println("podaj nazwe zdjęcia: ");
        tablicaZdjec[0] = in.nextLine();

        for (int i = 0; i < tablicaZdjec.length; i++){
            tablicaZdjec[i] = in.nextLine();
        }

        for (int i = 0; i <= tablicaZdjec.length-1; i++){
            System.out.println(tablicaZdjec[i]);
        }

    }
}
