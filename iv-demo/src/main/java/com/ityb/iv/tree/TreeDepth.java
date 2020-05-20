package com.ityb.iv.tree;

/**
 * Created by viruser on 2020/5/20.
 */
public class TreeDepth {

    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.getLeft());
        int right = treeDepth(root.getRight());
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree();
        System.out.println(treeDepth(treeNode));
    }



}