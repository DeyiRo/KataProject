package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000); // обьекты енам с значениями согласно конструктору

    private int value;  // создаем приватную переменную енама

    RomanNumeral(int value) { // конструктор обьектов енам
        this.value = value;
    }

    public int getValue() {  //геттер, возвращающий значение переменной обьекта енам
        return value;
    }

    public static List<RomanNumeral> getReverseSortedValues() { // метод возвращающий массив отсортированных в обратном порядке значений
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}
