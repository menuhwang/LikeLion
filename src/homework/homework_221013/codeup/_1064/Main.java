package homework.homework_221013.codeup._1064;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println((a < b) ? (a < c) ? a : (b < c) ? b : c : (b < c) ? b : c);
    }
}
