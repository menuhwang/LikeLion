package homework.homework_221011.codeup._1045;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((long) a + b);
        System.out.println(a - b);
        System.out.println( (long) a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.printf("%.2f", (float) a / b);
    }
}
