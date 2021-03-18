package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lixiang
 * @Date 2021/3/18
 */
public class OneToN {
    public static List<List<Integer>> subsets(int num) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums=new int[num];
        for (int i = 0; i < num; i++) {
            nums[i]=i+1;
        }
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(3);
        subsets.forEach(s ->{
            System.out.println(s);
        });
        List<Integer> getit = getit(3);
        getit.forEach(s->{
            System.out.println(s);
        });
    }

    static List<Integer> res=new ArrayList<>();
    public static void dfs(int cur, int n,int digit) {
        if (digit > n) {
            return;
        }
        if (cur % 10 > n) {
            return;
        }
        res.add(cur);
        for (int i = cur%10; i <= n; ++i) {
            dfs(cur * 10 + i + 1, n, digit + 1);
        }
    }
   public static List<Integer> getit(int n) {
        if (n == 0) {
            return null;
        }
        for(int i=1;i<=n;++i) {
            dfs(i, n, 1);
        }
        return res;
    }

}
