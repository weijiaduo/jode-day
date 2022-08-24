package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 1175. 质数排列
 * <p>
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * <p>
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 *
 * @author weijiaduo
 * @since 2022/6/30
 */
public class NumPrimeArrangements implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 100;
        int result = numPrimeArrangements(n);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：算出n内的质数个数，然后对质数和非质数分别进行全排列即可
     * <p>
     * 复杂度：时间 O(n^(3/2)) 空间O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了15.14% 的Java用户
     */
    private int numPrimeArrangements(int n) {
        int primeNum = 0;
        // 1既不是质数，也不是合数
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeNum++;
            }
        }
        long ans = factorial(primeNum) * factorial(n - primeNum);
        return (int) (ans % 1000000007);
    }

    /**
     * 是否是质数
     *
     * @param n 数字
     * @return true 质数/false 非质数
     */
    private boolean isPrime(int n) {
        // 实际取根号n范围还可以缩小
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 阶乘
     *
     * @param n n
     * @return 阶乘
     */
    private long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            // 边算边取余才行，否则会溢出
            ans = ans * i % 1000000007;
        }
        return ans;
    }

    /**
     * 打表真香
     * <p>
     * 思路：全列举打表
     * <p>
     * 复杂度：时间O(1) 空间O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了53.17% 的Java用户
     */
    public int numPrimeArrangements2(int n) {
        return new int[]{0, 1, 1, 2, 4, 12, 36, 144, 576, 2880, 17280, 86400, 604800, 3628800, 29030400, 261273600, 612735986, 289151874, 180670593, 445364737, 344376809, 476898489, 676578804, 89209194, 338137903, 410206413, 973508979, 523161503, 940068494, 400684877, 13697484, 150672324, 164118783, 610613205, 44103617, 58486801, 462170018, 546040181, 197044608, 320204381, 965722612, 554393872, 77422176, 83910457, 517313696, 36724464, 175182841, 627742601, 715505693, 327193394, 451768713, 263673556, 755921509, 94744060, 600274259, 410695940, 427837488, 541336889, 736149184, 514536044, 125049738, 250895270, 39391803, 772631128, 541031643, 428487046, 567378068, 780183222, 228977612, 448880523, 892906519, 858130261, 622773264, 78238453, 146637981, 918450925, 514800525, 828829204, 243264299, 351814543, 405243354, 909357725, 561463122, 913651722, 732754657, 430788419, 139670208, 938893256, 28061213, 673469112, 448961084, 80392418, 466684389, 201222617, 85583092, 76399490, 500763245, 519081041, 892915734, 75763854, 682289015}[n];
    }

}
