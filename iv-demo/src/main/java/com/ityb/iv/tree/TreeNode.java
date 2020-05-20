package com.ityb.iv.tree;

/**
 * Created by viruser on 2020/3/13.
 */
public class TreeNode {

    private Integer data;

    private TreeNode left;

    private TreeNode right;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode buildTree(){
        TreeNode root=new TreeNode();
        root.setData(1);

        TreeNode leftTreeNode=new TreeNode();
        leftTreeNode.setData(2);
        root.setLeft(leftTreeNode);
        TreeNode rightTreeNode=new TreeNode();
        rightTreeNode.setData(3);
        root.setRight(rightTreeNode);

        TreeNode subLeftTreedNode=new TreeNode();
        subLeftTreedNode.setData(4);
        leftTreeNode.setLeft(subLeftTreedNode);

        TreeNode subRightTreeNode=new TreeNode();
        subRightTreeNode.setData(5);
        leftTreeNode.setRight(subRightTreeNode);

        TreeNode sub=new TreeNode();
        sub.setData(6);
        rightTreeNode.setLeft(sub);


        return root;
    }


}
