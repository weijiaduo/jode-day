package com.wjd.structure.tree.general;

import com.wjd.algorithm.tree.general.build.LevelGeneralTreeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author weijiaduo
 * @since 2022/12/10
 */
public class Node {

    /**
     * 节点值
     */
    public int val;

    /**
     * 子节点
     */
    public List<Node> children;

    /**
     * @param val 节点值
     */
    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    /**
     * 构建树
     *
     * @param values 层次遍历的输出结果
     * @return 树根节点
     */
    public static Node build(Integer[] values) {
        return new LevelGeneralTreeBuilder().build(values);
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
