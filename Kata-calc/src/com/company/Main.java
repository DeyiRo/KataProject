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
                throw new IllegalArgumentException("�������������� ������������ �������. ������� ������ �������� ��� ������ ������� ����� � �������� 10.");
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
                        throw new IllegalArgumentException("�������������� �������������� ��������. �������� ��������: +, -, *, /.");
                }

                    return result;

                    } else { throw new IllegalArgumentException("������� ����� ������ 10  ��� ����� 1. ���������� ������� ����� �� 1 �� 10 ������������."); }

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
                            throw new IllegalArgumentException("�������������� �������������� ��������. �������� ��������: +, -, *, /.");

                    }
                 if ( result > 0){
                    resultat = arabicToRoman(result);
                    return resultat;}
                 else { throw new ArithmeticException("������� ���� ��� ������������� �����. ��������� �� ����� ���� �������, �.�. � ������� ������� ��� ������������� �����.");}


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

    public static int romanToArabic(String input) { //����� �������������� ������� ����� � ��������
        String romanNumeral = input.toUpperCase(); //���������� ������ ����� �������������� � �������� ��������
        int result = 0; // �������� ��������� �������� ���������� ���������

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues(); //��������� ������, � ���������� � �������� �������

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) { // ���� ������ ������ ������ 0 � �������� i �� �������� ������ ������� ����
            RomanNumeral symbol = romanNumerals.get(i);  //������ ����� ������� ����� �������� ������� ����� ��� �������� i
            if (romanNumeral.startsWith(symbol.name())) { // ���� ���������� ������ ���������� � ������� ����� ������� ����
                result += symbol.getValue(); //�� ��������� ����� ���������+�������� ������� ����
                romanNumeral = romanNumeral.substring(symbol.name().length()); // � ������� ����� ���������
            } else {
                i++; //����� �������� ���� ������������, ������� i �������������
            }
        }

        if (romanNumeral.length() > 0) { //���� ������ �������� ������ ������ ���� �������� ����������
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
