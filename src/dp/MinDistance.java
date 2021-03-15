package dp;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] DP = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            DP[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            DP[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = DP[i - 1][j] + 1;
                int down = DP[i][j - 1] + 1;
                int left_down = DP[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                DP[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return DP[n][m];
    }

}
