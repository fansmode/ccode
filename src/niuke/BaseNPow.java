package niuke;

public class BaseNPow {

    /**
     * 数值的整数次方
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 == 1) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }

}
