package Homework4_test;

import Homework4.Treugolnik;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TreugolnikTest {

    @Test()
    @DisplayName("Позитивная проверка вычисления")
    public void checkSquare() {

        assertEquals(Treugolnik.out(3, 4, 5), "6,00", "Ошибка вычисления");
    }

    @Test
    @DisplayName("Передача отрицательного значения")
    public void negativeNumC() {

        assertEquals(Treugolnik.out(1, 4, -4), "Введены некорректные данные!", "Ошибка," +
                " принял отрицательное значение");
    }

    @Test
    @DisplayName("Передача отрицательного значения")
    public void negativeNumB() {

        assertEquals(Treugolnik.out(1, -4, 4), "Введены некорректные данные!", "Ошибка," +
                " принял отрицательное значение");
    }

    @Test
    @DisplayName("Передача отрицательного значения")
    public void negativeNumA() {

        assertEquals(Treugolnik.out(-1, 4, 4), "Введены некорректные данные!", "Ошибка," +
                " принял отрицательное значение");
    }

    @Test
    @DisplayName("Передача невалидного значения")
    public void tooBigNumA() {

        assertEquals(Treugolnik.out(100, 4, 4), "Введены некорректные данные!", "Ошибка, " +
                "это не треугольник");
    }

    @Test
    @DisplayName("Передача невалидного значения")
    public void tooBigNumB() {

        assertEquals(Treugolnik.out(10, 107, 4), "Введены некорректные данные!", "Ошибка, " +
                "это не треугольник");
    }

    @Test
    @DisplayName("Передача невалидного значения")
    public void tooBigNumC() {

        assertEquals(Treugolnik.out(5, 4, 96), "Введены некорректные данные!", "Ошибка, " +
                "это не треугольник");
    }
}
