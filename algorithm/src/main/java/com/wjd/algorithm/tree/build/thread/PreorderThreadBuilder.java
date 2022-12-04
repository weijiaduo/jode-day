package com.wjd.algorithm.tree.build.thread;

import com.wjd.structure.tree.TreeNode;
import com.wjd.structure.tree.thread.ThreadTreeNode;

/**
 * 前序线索二叉树
 *
 * @author weijiaduo
 * @since 2022/12/4
 */
public class PreorderThreadBuilder implements ThreadBuilder {

    private ThreadTreeNode prev;

    @Override
    public ThreadTreeNode build(TreeNode root) {
        ThreadTreeNode newRoot = new ThreadTreeNode(root);
        prev = null;
        dfs(newRoot);
        prev.right = null;
        prev.rTag = true;
        return newRoot;
    }

    /**
     * 递归遍历
     *
     * @param root 根节点
     */
    private void dfs(ThreadTreeNode root) {
        if (root == null) {
            return;
        }

        // 后驱节点
        if (prev != null && prev.right == null) {
            prev.right = root;
            prev.rTag = true;
        }
        // 前驱节点
        if (root.left == null) {
            root.left = prev;
            root.lTag = true;
        }
        prev = root;

        if (!root.lTag) {
            dfs(root.left);
        }
        if (!root.rTag) {
            dfs(root.right);
        }
    }

}
