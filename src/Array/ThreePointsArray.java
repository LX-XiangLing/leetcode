package Array;

/**
 * @Author lixiang
 * @Date 2021/3/30
 */
public class ThreePointsArray {
    public static boolean threePointsArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = sum / 3;
        if (avg * 3 != sum) {
            return false;
        }
        int temp = 0;
        int step = 0;
        for (int j = 0; j < arr.length; j++) {
            temp += arr[j];
            System.out.print(arr[j] + " ");
            if (temp == avg) {
                temp = 0;
                System.out.println("   ");
                step++;
            }
        }
        if (step == 3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ary = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        boolean b = threePointsArray(ary);
        System.out.println(b);
    }
}
