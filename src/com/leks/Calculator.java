package com.leks;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner scan = new Scanner(System.in);
        var expr = scan.nextLine();
        CalculatorClass calculator = new CalculatorClass();
        System.out.println(calculator.calc(expr));
    }
}