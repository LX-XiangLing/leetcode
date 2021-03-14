package heap;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * @Author lixiang
 * @Date 2021/3/14
 */
public class SmallestK {
    public static int[] smallestK(int[] arr, int k) {
        int[] re = new int[k];
        if (k == 0) {
            return re;
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            re[i]=queue.poll();
        }
        return re;
    }

}
