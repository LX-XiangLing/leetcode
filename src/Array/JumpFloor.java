package Array;

public class JumpFloor {
    public int jumpFloor(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        int a = 1, b = 1, c=0;
        for (int i=2; i<=target; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
