package org.example;

import java.text.DecimalFormat;

public class Treugolnik {

    public static void main(String[] args) {

        int a = 7;
        int b = 10;
        int c = 5;

        double p = (a+b+c)/2;

        double s2 = p*(p-a)*(p-b)*(p-c);
        double s1 = Math.sqrt(s2);

        String s = new DecimalFormat("#0.00").format(s1);

        System.out.println(s);
    }
}
