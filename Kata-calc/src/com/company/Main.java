package com.company;

import java.lang.reflect.Array; //https://github.com/DeyiRo/KataProject.git
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {
        // write your code here
        Scanner console = new Scanner(System.in);

        while (console.hasNextLine()) {
            String s = console.nextLine();
            String[] list = s.split(" ");
            if (romanNumber(list[0]) != romanNumber(list[2])){
                throw new IllegalArgumentException("Несоответствие числительной системы. Введите только арабские или только римские числа в пределах 10.");
            } else {
                if ( romanNumber(list[0]) == true){
                    String result = calcForRoman(list);
                    System.out.println(result);}
                else { int result = calcForArabian(list);
                    System.out.println(result);
                }

            }

        }

    }
        public static boolean romanNumber(String a){
            List<String> letters = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
           return letters.contains(a.toUpperCase());
        }


            public static int calcForArabian(String[] s) throws IllegalArgumentException {
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[2]);
                int result;
                if ((a> 0 &&a<=10) && (b > 0 && b <=10)){
                switch (s[1]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        throw new IllegalArgumentException("Несоответствие арифметической операции. Доступны операции: +, -, *, /.");
                }

                    return result;

                    } else { throw new IllegalArgumentException("Введено число больше 10  или менее 1. Пожалуйста вводите число от 1 до 10 включительно."); }

                }


            public static String calcForRoman(String[]s) throws ArithmeticException {
               int a = romanToArabic(s[0]);
               int b = romanToArabic(s[2]);
                String resultat;
                int result;
                    switch (s[1]) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "/":
                            result = a / b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        default:
                            throw new IllegalArgumentException("Несоответствие арифметической операции. Доступны операции: +, -, *, /.");

                    }
                 if ( result > 0){
                    resultat = arabicToRoman(result);
                    return resultat;}
                 else { throw new ArithmeticException("Получен ноль или отрицательный число. Результат не может быть выведен, т.к. в римской системе нет отрицательных чисел.");}


                }







  /*  static int romanToArabian(String a) {
        String letters[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        int x = 0;
        for (int i = 0; i < 10; i++) {
            if (letters[i].equals(a)) {
                 x = i + 1;
                 break;
            } else  { x = Integer.parseInt(a);
            break; }

        } return x;
    }*/

    public static int romanToArabic(String input) { //Метод конвертирующий римские числа в арабские
        String romanNumeral = input.toUpperCase(); //полученная строка ввода конвертируется к верхнему регистру
        int result = 0; // задается стартовое значение переменной результат

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues(); //создается массив, с значениями в обратном порядке

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) { // пока длинна строки больше 0 и значение i не достигло длинны массива лист
            RomanNumeral symbol = romanNumerals.get(i);  //обьект енама который равен значению обьекта енама под индексом i
            if (romanNumeral.startsWith(symbol.name())) { // если полученная строка начинается с символа имени обьекта енам
                result += symbol.getValue(); //то результат равен результат+значение обьекта енам
                romanNumeral = romanNumeral.substring(symbol.name().length()); // а римское число равняется
            } else {
                i++; //иначе значение енам пропускается, счетчик i увеличивается
            }
        }

        if (romanNumeral.length() > 0) { //если длинна заданной строки больше нуля выдается исключение
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;

    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
