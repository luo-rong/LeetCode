package _069_Sqrtx;

public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        return ((int) sqrt(x, x));
    }

    private double sqrt(double x, double num) {
        double res = (num + x / num) / 2;
        if (res == num) {
            return num;
        } else {
            return sqrt(x, res);
        }
    }
}
