package design;

import java.math.BigDecimal;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class Sqrt {
    public static void main(String[] args) {
        double sqrt = sqrt(10, 2);
        System.out.println(sqrt);
    }

    public static double sqrt(int n, int precision) {
        double lower = 0;
        double high = n;
        double mid = 0;
        double threshold = Math.pow(10, -precision);
        do {
            mid = lower + (high - lower) / 2;
            if (mid * mid > n) {
                high = mid;
            } else {
                lower = mid;
            }

        } while (Math.abs(mid * mid - n) > threshold);

        //省略掉定数位后的
        //ROUND_UP直接对指定位数后的内容做进一位处理
        return new BigDecimal(mid).setScale(precision, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
