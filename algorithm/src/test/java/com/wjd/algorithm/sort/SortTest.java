package com.wjd.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author weijiaduo
 * @since 2022/7/21
 */
public class SortTest {

    @Test
    void testBubble() {
        testSort(new BubbleSort());
    }

    @Test
    void testSelect() {
        testSort(new SelectSort());
    }

    @Test
    void testInsert() {
        testSort(new InsertSort());
    }

    @Test
    void testQuick() {
        testSort(new QuickSort());
    }

    @Test
    void testMerge() {
        testSort(new MergeSort());
    }

    private void testSort(Sort sort) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int size = 50 + random.nextInt(150);
            int[] expect = new int[size];
            for (int j = 0; j < size; j++) {
                expect[j] = random.nextInt(1000);
            }
            int[] actual = Arrays.copyOf(expect, expect.length);
            Arrays.sort(expect);
            sort.sort(actual);
            assertArrayEquals(actual, expect);
        }
        System.out.println(System.nanoTime() - start);
    }

}
