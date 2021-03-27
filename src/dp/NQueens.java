package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lixiang
 * @Date 2021/3/27
 */
public class NQueens {
    List<List<String>> results;
    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        //用于记录每行中皇后所在的位置
        int[] queens = new int[n];
        /* 从第一行开始递归回溯寻找每行的可选位置，
         * 列、斜边的二进制数串中某位为1表示为该位置不可选，
         * 初始为0表示棋盘的第一行内每一个方格都可以选（本规则在递归过程中始终不变）。
         * 注意递归方法中的记录可选位置的availableLocation和position则与之相反。
         */
        solveNQueens(queens, n, 0, 0, 0, 0);
        //返回最终结果
        return results;
    }
    /** 重载solveNQueens方法：记录下每行皇后的可选位置
     * int n：总行数
     * int row：当前行数
     * int columns：不可选的列
     * int diagonals1：不可选的左斜边
     * int diagonals2：不可选的右斜边
     */
    public void solveNQueens(
            int[] queens, int n, int row,
            int columns, int diagonals1, int diagonals2){

        //已经递归完成了最后一行的寻找，此时已经记录下了一个可行的方案
        if(row == n){
            //生成上一次成功得到的皇后位置字符串list，并加入结果集中
            results.add(generateString(queens));
            //返回
            return;
        }
        /* 【目的】将本行所有可选位置使用一个n位的二进制数串availableLocations表示
         * 【二进制解释】(1 << n) - 1的结果是得到一个各位均为1的n位二进制数串，
         * 将其与当前棋盘行内所有可选位置的二进制表示（列和斜边的二进制串[0为可选，1为不可选]
         * 按位或的结果再取反）按位与可以得到对应棋盘n列的n位二进制串表示，
         * 用于定位可以放置皇后的位置。
         * 定位所有可选的位置，某位为1表示对应方格可选。这里有一步取反，莫忽视。
         * 上面我们用 1 表示不可选的位置，但是这里我们取反后，用1表示可选的位置。
         */
        int availableLocations = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        //通过下面的操作来保持之前所有的行对下一行的影响
        //上左下右的斜边因为下降了一行，本行所处棋盘方格需要右移一位，对应二进制数串需要左移一位
        diagonals1 <<= 1;
        //上右下左的斜边因为下降了一行，本行所处棋盘方格需要左移一位，对应二进制数串需要右移一位
        diagonals2 >>= 1;
        // 当仍有可选位置时（available的二进制表示中还有一些位是1），检查每个可选的位置
        while(availableLocations != 0){
            /*【目的】找到当前行内最左一个可选方格。
             *【二进制解释】定位最后一个1的位置，此操作可以手写验证（不要忘了把负数转成补码）。
             *【详解】将availableLocation中的最低位1保留，其余位的1全部置0。赋给position
             *（此时position中只有一位为1对应棋盘最左可选位置）。
             * 定位的意思是：找到表示可选位置的二进制数串availableLocations中的最低位的1
             *（对应棋盘当前行内最左一个可选的方格）
             */
            int position = availableLocations & (-1 * availableLocations);
            /*【目的】得出position对应棋盘当前行内的索引columnNum（每行的方格索引从左到右从0开始）
             *【二进制解释】定位到position的二进制串中最低位1的次低位的位置（从右往左数）
             *【详解】position - 1使得position的二进制数串中最低位的1后面的0全部变为1;
             * 再使用Integer.bitCount(position-1)计算(position-1)的二进制数串中 1 的个数。
             * 举例：若position = 3，二进制表示为00000010，则column = （00000001中1的个数）= 1，
             * 即为其对应的棋盘当前行内的方格索引。
             */
            int columnNum = Integer.bitCount(position - 1);
            // 将这个可选的方格索引位置添加到记录数组中
            queens[row] = columnNum;
            /*【目的】将这一位置从所有可选取的方格集合中移除（本轮已经被选过，下一行不得再选）
             *【二进制解释】将这一位的1变为0：
             *【详解】减1把最低位的1变成0，将其后面的多个0变为1；
             * 再将结果和原数串按位与，把这些低位上多出来的1全部清除，
             * 最终的结果就是将availableLocations中的当前可选位置置0
             */
            availableLocations = availableLocations & (availableLocations - 1);
            /*【目的】进行下一行的搜索，行和可选列的变化直接在参数中传递即可
             *【解释】将表示已有皇后的列和斜边的二进制串（1表示该位置已有皇后不能再选）
             * 与当前可选位置的左/右移的结果（即下一行不能选的位置）进行按位或，
             * 得到的结果是将position位置的方格更新在了已有皇后的列和斜边中。
             */
            solveNQueens(queens, n, row + 1, columnNum | position,
                    diagonals1 | (position << 1), diagonals2 | (position >> 1));
        }
    }

    /* 生成某行表示皇后位置的字符串*/
    public List<String> generateString(int[] queens){
        List<String> result = new ArrayList<>();
        for(int i: queens){
            char[] chars = new char[queens.length];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            result.add(String.valueOf(chars));
        }
        return result;
    }

}
