package Array;

/**
 * @Author lixiang
 * @Date 2021/3/18
 *     //时间复杂度 O(M+N) ：其中，NNN 和 MMM 分别为矩阵行数和列数，此算法最多循环 M+NM+NM+N 次。
 *     //空间复杂度 O(1) : i, j 指针使用常数大小额外空间。
 */
public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) {
                i--;
            }
            else if(matrix[i][j] < target) {
                j++;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a={{1, 4, 7},{2,5,8},{3,6,9}};
        boolean numberIn2DArray = findNumberIn2DArray(a, 3);
        System.out.println(numberIn2DArray);
    }
}
