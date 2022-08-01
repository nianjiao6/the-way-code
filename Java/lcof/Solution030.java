package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import utils.Pair;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * https://lc.netlify.app/#/lcof/%E9%9D%A2%E8%AF%95%E9%A2%9803.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97/README
 */
public class Solution030 {
    static List<Pair<int[], int[]>> checkList = new ArrayList<>();
    static {
        checkList.add(new Pair<>(new int[] { 1, 2, 4, 0 ,3}, new int[] {  }));
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
            int[] data = x.getLeft();
            int[] pass = x.getRight();
            int num = findRepeatNumber(data);
            if (!(num == -1 && pass.length == 0) && Arrays.stream(pass).noneMatch(y -> y == num)) {
                flag.set(false);
                System.out.printf("匹配失败 -> %s : %s%n", Arrays.toString(data), Arrays.toString(pass));
            }

        });
        if (flag.get()) {
            System.out.println("匹配成功");
        }
    }


    /**
     * 核心算法
     * 
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0, n = nums.length; i < n; ++i) {
            System.out.println(" i =" + i);
            while (nums[i] != i) {
                System.out.println(" -> i =" + i + " " + nums[i] + " " + nums[nums[i]]);
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}