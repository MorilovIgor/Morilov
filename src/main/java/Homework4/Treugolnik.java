package Homework4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Treugolnik {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Сторона a = ");
        int a = sc.nextInt();

        System.out.println("Сторона b = ");
        int b = sc.nextInt();

        System.out.println("Сторона c = ");
        int c = sc.nextInt();

        out(a, b, c);
    }

    public static String out(int a, int b, int c) {

        if (a > 0 && b > 0 && c > 0) {
            if (a + b > c && a + c > b && b + c > a) {

                double p = (a + b + c) / 2;

                double s2 = p * (p - a) * (p - b) * (p - c);
                double s1 = Math.sqrt(s2);

                String s = new DecimalFormat("#0.00").format(s1);

                System.out.println("Площадь треугольника = " + s);

                return s;
            } else {
                System.out.println("Введены некорректные данные!");
                return "Введены некорректные данные!";
            }
        } else {
            System.out.println("Введены некорректные данные!");
            return "Введены некорректные данные!";
        }
    }
}
