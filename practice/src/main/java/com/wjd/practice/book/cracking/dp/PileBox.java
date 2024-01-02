package com.wjd.practice.book.cracking.dp;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 面试题 08.13. 堆箱子
 * <p>
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。
 * <p>
 * 箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * <p>
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * <p>
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * <p>
 * 示例2:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * <p>
 * 提示:
 * <p>
 * 箱子的数目不大于3000个。
 *
 * @author weijiaduo
 * @since 2024/1/2
 */
public class PileBox {

    /**
     * 思路：动态规划
     * <p>
     * 先给箱子排序，保证前面的箱子宽度至少比后面的大
     * <p>
     * 然后定义 dp[i] 为以 i 箱子为顶端时的最大高度
     * <p>
     * dp[i] = max(dp[j] + hi, dp[i])，0 <= j < i
     * <p>
     * 复杂度：时间 O(nlogn + n^2) 空间 O(n)
     * <p>
     * 执行耗时:39 ms,击败了74.84% 的Java用户
     * 内存消耗:43.2 MB,击败了12.90% 的Java用户
     */
    @TestCase(input = {"[[1, 1, 1], [2, 2, 2], [3, 3, 3]]",
            "[[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]",
            "[[3, 1, 4], [10, 16, 15], [9, 10, 20], [8, 9, 8], [19, 7, 8], [10, 8, 2], [18, 16, 6], [8, 4, 9], [13, 1, 10], [18, 4, 6], [14, 8, 16], [13, 18, 2], [17, 10, 16], [4, 6, 6], [11, 17, 7], [1, 8, 7], [16, 10, 15], [18, 18, 4], [7, 2, 12], [1, 7, 3], [8, 5, 4], [15, 4, 9], [16, 7, 6], [12, 13, 20], [2, 4, 3], [12, 13, 20], [1, 2, 13], [16, 20, 11], [14, 4, 17], [16, 15, 8], [15, 18, 17], [4, 4, 8], [5, 18, 1], [16, 10, 10], [17, 19, 13], [18, 20, 13], [17, 5, 19], [5, 2, 17], [7, 13, 13], [9, 11, 12], [11, 10, 12], [10, 16, 5], [4, 3, 18], [18, 11, 18], [14, 14, 16], [18, 1, 14], [7, 5, 19], [10, 15, 11], [2, 11, 8], [6, 8, 17], [12, 1, 12], [8, 4, 17], [13, 14, 11], [17, 20, 11], [15, 10, 15], [7, 6, 19], [14, 13, 15], [11, 9, 12], [19, 14, 2], [14, 11, 8], [4, 2, 18], [12, 20, 15], [2, 12, 18], [16, 6, 9]]"},
            output = {"6", "10", "70"})
    public int dynamic1(int[][] box) {
        Arrays.sort(box, (a, b) -> b[0] - a[0]);

        // 状态定义
        int n = box.length;
        int[] dp = new int[n];

        // 状态初始化
        // 每个箱子以自己作最底下的箱子
        for (int i = 0; i < n; i++) {
            dp[i] = box[i][2];
        }

        // 状态转移
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] < box[j][0] &&
                    box[i][1] < box[j][1] &&
                    box[i][2] < box[j][2]) {
                    dp[i] = Math.max(dp[j] + box[i][2], dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

}
