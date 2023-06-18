package com.wjd.practice.leetcode.array.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @since 2022/5/28
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return ans;
    }

    /**
     * 递归法
     * <p>
     * 思路：数字不重复，所以直接递归遍历，直接按照全排列的定义计算
     * 第1个位置，有n种情况
     * 第2个位置，有n-1种情况
     * ......
     * 第n个位置，有1种情况
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了52.44% 的Java用户
     */
    private void backtrack(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length - 1) {
            List<Integer> path = new ArrayList<>(nums.length);
            for (int num : nums) {
                path.add(num);
            }
            ans.add(path);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            backtrack(nums, index + 1, ans);
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}
