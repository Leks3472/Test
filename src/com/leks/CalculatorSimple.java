package com.leks;

import java.util.Scanner;

public class CalculatorSimple {

    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner scan = new Scanner(System.in);
        var expr = scan.nextLine();
        expr = expr.trim();
        expr = expr.replaceAll("\\s+", "");
        var i = 0;
        var n = 0;
        var firstOperand = ""; // первая часть выражения
        char action = 0; // действие
        var secondOperand = ""; // вторая часть выражения
        //нахождение оператора
        while (i < expr.length()) {
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '*' || expr.charAt(i) == '/') {
                action = expr.charAt(i);
                n = i;
            }
            i++;
        }
        //нахождение 1-го операнда
        i = 0;
        while (i < n) {
            firstOperand = firstOperand + expr.charAt(i);
            i++;
        }
        //нахождение 2-го операнда
        i = n + 1;
        while (i < expr.length()) {
            secondOperand = secondOperand + expr.charAt(i);
            i++;
        }

        if ((firstOperand.equals("1") ||
                firstOperand.equals("2") ||
                firstOperand.equals("3") ||
                firstOperand.equals("4") ||
                firstOperand.equals("5") ||
                firstOperand.equals("6") ||
                firstOperand.equals("7") ||
                firstOperand.equals("8") ||
                firstOperand.equals("9") ||
                firstOperand.equals("10")) &&
                (secondOperand.equals("1") ||
                        secondOperand.equals("2") ||
                        secondOperand.equals("3") ||
                        secondOperand.equals("4") ||
                        secondOperand.equals("5") ||
                        secondOperand.equals("6") ||
                        secondOperand.equals("7") ||
                        secondOperand.equals("8") ||
                        secondOperand.equals("9") ||
                        secondOperand.equals("10"))) {

            System.out.println(calculArabic(firstOperand, action, secondOperand));

        } else if ((firstOperand.equals("I") ||
                firstOperand.equals("II") ||
                firstOperand.equals("III") ||
                firstOperand.equals("IV") ||
                firstOperand.equals("V") ||
                firstOperand.equals("VI") ||
                firstOperand.equals("VII") ||
                firstOperand.equals("VIII") ||
                firstOperand.equals("IX") ||
                firstOperand.equals("X")) &&
                (secondOperand.equals("I") ||
                        secondOperand.equals("II") ||
                        secondOperand.equals("III") ||
                        secondOperand.equals("IV") ||
                        secondOperand.equals("V") ||
                        secondOperand.equals("VI") ||
                        secondOperand.equals("VII") ||
                        secondOperand.equals("VIII") ||
                        secondOperand.equals("IX") ||
                        secondOperand.equals("X"))) {

            System.out.println(calculRoman(firstOperand, action, secondOperand));


        } else {
            System.out.println("Вы ввели неверные значения");
            System.exit(0);

        }

    }

    static String calculArabic(String a, char b, String c) {
        int result = 0;
        int aInt = Integer.parseInt(a);
        int cInt = Integer.parseInt(c);
        switch (b) {
            case '+':
                result = aInt + cInt;
                break;
            case '-':
                result = aInt - cInt;
                break;
            case '*':
                result = aInt * cInt;
                break;
            case '/':
                // Здесь проверка деления на 0, но так как диапозон вводимых значений не включает 0, то проверка выключена
                //  if (b == 0)
                //      System.out.println("Error");
                //  else {
                result = aInt / cInt;
                //                      }
                break;
        }
        return Integer.toString(result);
    }

    static String calculRoman(String a, char b, String c) {
        String firstNumberArabic;
        String secondNumberArabic;
        String resultRoman;

        firstNumberArabic = romanToArabic(a);
        secondNumberArabic = romanToArabic(c);

        if (Integer.parseInt(firstNumberArabic) < Integer.parseInt(secondNumberArabic) && b == '-') {
            System.out.println("Вы ввели неверное выражение (1-й операнд должен быть больше 2-го опернда)");
            System.exit(0);
        }
        resultRoman = arabicToRoman(calculArabic(firstNumberArabic, b, secondNumberArabic));

        return resultRoman;

    }

    static String romanToArabic(String operand) {
        int numberArabicFromRoman = 0;

        if (operand.equals("I")) {
            numberArabicFromRoman = 1;
        } else if (operand.equals("II")) {
            numberArabicFromRoman = 2;
        } else if (operand.equals("III")) {
            numberArabicFromRoman = 3;
        } else if (operand.equals("IV")) {
            numberArabicFromRoman = 4;
        } else if (operand.equals("V")) {
            numberArabicFromRoman = 5;
        } else if (operand.equals("VI")) {
            numberArabicFromRoman = 6;
        } else if (operand.equals("VII")) {
            numberArabicFromRoman = 7;
        } else if (operand.equals("VIII")) {
            numberArabicFromRoman = 8;
        } else if (operand.equals("IX")) {
            numberArabicFromRoman = 9;
        } else if (operand.equals("X")) {
            numberArabicFromRoman = 10;
        }
        return Integer.toString(numberArabicFromRoman);
    }
    static String arabicToRoman(String numberRoman) {
        int arabic = Integer.parseInt(numberRoman);

        int res = arabic % 10; //находим остаток из десятков. Это же количество едениц
        int res10_1 = (arabic - res) / 10; //находим количество десятков

        String res100;
        if (arabic == 100) {
            res100 = "C";
        }
        else {
            res100 = "";
        }

        String res10_2 = "";

        if (res10_1 == 1) {
            res10_2 = "X";
        } else if (res10_1 == 2) {
            res10_2 = "XX";
        } else if (res10_1 == 3) {
            res10_2 = "XXX";
        } else if (res10_1 == 4) {
            res10_2 = "XL";
        } else if (res10_1 == 5) {
            res10_2 = "L";
        } else if (res10_1 == 6) {
            res10_2 = "LX";
        } else if (res10_1 == 7) {
            res10_2 = "LXX";
        } else if (res10_1 == 8) {
            res10_2 = "LXXX";
        } else if (res10_1 == 9) {
            res10_2 = "XC";
        } else if (res10_1 == 0) {
            res10_2 = "";
        }

        String res1_2 = "";

        if (res == 1) {
            res1_2 = "I";
        } else if (res == 2) {
            res1_2 = "II";
        } else if (res == 3) {
            res1_2 = "III";
        } else if (res == 4) {
            res1_2 = "IV";
        } else if (res == 5) {
            res1_2 = "V";
        } else if (res == 6) {
            res1_2 = "VI";
        } else if (res == 7) {
            res1_2 = "VII";
        } else if (res == 8) {
            res1_2 = "VIII";
        } else if (res == 9) {
            res1_2 = "IX";
        } else if (res == 0) {
            res1_2 = "";
        }
        return res100 + res10_2 + res1_2;
    }

}


