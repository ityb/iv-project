package com.ityb.iv.arithmetic;

/**
 * 镜像二叉树
 */
public class MirrorTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mirror(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        if(treeNode.left == null || treeNode.right == null){
            return treeNode;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = temp.right;
        temp.right = temp;
        mirror(treeNode.left);
        mirror(treeNode.right);
        return treeNode;
    }
}
