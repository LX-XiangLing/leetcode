package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @Author lixiang
 * @Date 2020/12/28
 */
public class UniqueBinarySearchTrees {
    /**
     * 解法1
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    /**
     * 解法2
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int Trees(int n) {
        return helper(1, n);
    }

    public int helper(int start, int end) {
        if (map.containsKey(end - start)) {
            return map.get(end - start);
        }
        if (start > end) {
            return 1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int left = helper(start, i - 1);
            int right = helper(i + 1, end);
            sum += left * right;
        }
        map.put(end - start, sum);
        return sum;
    }

}
