package polynom;

import java.util.ArrayList;

public class PolynomialFunction {
    // Список коэффициентов
    private ArrayList<String> Odds;
    // Список степеней
    private ArrayList<Integer> Degree;
    // Список операций
    private ArrayList<String> Operations;
    // Количество битов в p-адических числах
    public int k;
    public long board;

    public PolynomialFunction(ArrayList<String> odds, ArrayList<Integer> degree, ArrayList<String> operations)
    {
        Odds = odds;
        Degree = degree;
        Operations = operations;
    }
    // Степень двойки
    public long step2(int step) {
        long result = 1;
        for(int i = 0; i < step; i++) {
            result *= 2;
        }
        return result;
    }
    // Сложение двух р-адических чисел
    public long addition(long x, long y) {
        return (x + y) % board;
    }
    // Вычитание двух р-адических чисел
    public long subtraction(long x, long y) {
        return (x - y) % board;
    }
    // Умножение двух р-адических чисел
    public long multiplication(long x, long y) {
        return (x * y) % board;
    }
    // Возведение в степень р-адического числа
    public long exponentiation(long x, int n) {
        long result = 1;
        for(int i = 0; i < n; i++) {
            result = multiplication(x, result);
        }
        return result;
    }
    // Преобразование дробного коэффициента
    public long fractionalConvert(long numerator, long denominator) {
        byte[] x = new byte[k];
        byte[] y = new byte[k];
        byte[] res = new byte[k];
        for (int i = 0; i < k; i++) {
            x[i] = (byte) (numerator % 2);
            y[i] = (byte) (denominator % 2);
            numerator /= 2;
            denominator /= 2;
        }
        res[0] = x[0];
        for (int i = 1, sum = 0; i < k; i++) {
            for (int j = 1; j <= i; j++) {
                if (y[j] == 1) {
                    sum += res[i - j];
                }
            }
            if (sum % 2 == x[i]) {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
            sum += res[i];
            sum /= 2;
        }
        long result = 0;
        for (int i = 0; i < k; i++) {
            if (res[i] == 1) {
                result += step2(i);
            }
        }
        return result;
    }
    // Получение монома
    public long getMonomial(long odds, long variable, int degree) {
        return odds * this.exponentiation(variable, degree);
    }
    // Получение полинома
    public long getPolinomial(long monom_1, long monom_2, String operation) {
        long rezult = 0;
        if (operation.equals("+"))
        {
            rezult = this.addition(monom_1, monom_2);
        }
        else if (operation.equals("-"))
        {
            rezult = this.subtraction(monom_1, monom_2);
        }
        return rezult;
    }
}
