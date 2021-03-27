package dfs;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author lixiang
 * @Date 2021/3/27
 */
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 1;
        }
        int res = 0;
        int index = 2;//0是海洋1是陆地，为了避免冲突，从2开始
        HashMap<Integer, Integer> indexAndAreas = new HashMap<>(); //序号对应面积的一个映射，因为面积要最后结束才能计算出来，所以遍历过程中用index代替，放在映射中
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = area(grid, r, c, index);
                    indexAndAreas.put(index, area);
                    index++;
                    res = Math.max(res, area);
                }
            }
        }
        if (res == 0) {
            return 1;
        }//如果没有陆地，那么就造1块
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {//遍历海洋格子
                    HashSet<Integer> hashSet = findNeighbour(grid, r, c);//把上下左右四邻放入set里，set的目的是去重
                    if (hashSet.size() < 1) {
                        continue;
                    }//周围没有陆地就不必再继续算了，所以continue
                    int twoIsland = 1;//起始是1，直接把我们造出来的1计算进去
                    for (Integer i : hashSet) {
                        twoIsland += indexAndAreas.get(i);
                    }//通过序号找到面积
                    res = Math.max(res, twoIsland);
                }
            }
        }
        return res;
    }


    private HashSet<Integer> findNeighbour(int[][] grid, int r, int c) {
        HashSet<Integer> hashSet = new HashSet<>();
        if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0) {
            hashSet.add(grid[r - 1][c]);
        }
        if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0) {
            hashSet.add(grid[r + 1][c]);
        }
        if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0) {
            hashSet.add(grid[r][c - 1]);
        }
        if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0) {
            hashSet.add(grid[r][c + 1]);
        }
        return hashSet;
    }

    private int area(int[][] grid, int r, int c, int index) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = index;
        return 1 + area(grid, r - 1, c, index) + area(grid, r + 1, c, index) + area(grid, r, c - 1, index) + area(grid, r, c + 1, index);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
