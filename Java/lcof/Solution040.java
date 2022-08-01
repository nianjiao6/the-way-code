package lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import utils.Pair;

/**
 * 题目描述
 * 在一个 n * m
 * 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution040 {

    static int[][] arr = new int[][] {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 }
    };

    static List<Pair<Integer, Boolean>> checkList = new ArrayList<>();
    static {
        checkList.add(new Pair<>(3, true));
        checkList.add(new Pair<>(25, false));
    }

    /**
     * 测试程序
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 程序的测试工作
        AtomicBoolean flag = new AtomicBoolean(true);

        checkList.forEach(x -> {
            int data = x.getLeft().intValue();
            boolean pass = x.getRight();
            if (!(!findNumberIn2DArray(arr, data) || pass) && (findNumberIn2DArray(arr, data) || !pass)) {
                flag.set(false);
                System.out.printf("匹配失败 -> %s : %s%n", data, pass);
            }

        });
        if (flag.get()) {
            System.out.println("匹配成功");
        }
    }

    /**
     * 核心算法
     * 
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0, j = n - 1; i < m && j >= 0;) {
            int tmp = matrix[i][j];
            if (tmp == target) {
                return true;
            }

            if (tmp > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
