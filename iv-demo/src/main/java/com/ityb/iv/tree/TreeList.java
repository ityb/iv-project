package com.ityb.iv.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by viruser on 2020/3/13.
 */
public class TreeList {

    /**
     * 构建二叉树结构
     * @param
     * @return
     * @author yangbin3
     * @date 2020/3/13
     */
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

    /**
     * 后续遍历
     * @param root
     * @return
     * @author yangbin3
     * @date 2020/3/13
     */

    public static void postorderList(TreeNode root){
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node=stack1.pop();
            stack2.push(node);
            if(node.getLeft()!=null){
                stack1.push(node.getLeft());
            }
            if(node.getRight()!=null){
                stack1.push(node.getRight());
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().getData()+" ");
        }
    }

    /**
     * 前序遍历
     * @param root
     * @return
     * @author yangbin3
     * @date 2020/3/13
     */

    public static void preOrderList(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
            while(node!=null){
                System.out.print(node.getData()+" ");
                stack.push(node);
                node=node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node=node.getRight();
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     * @return
     * @author yangbin3
     * @date 2020/3/13
     */

    public static void middleOrderList(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode treeNode=root;
        while (!stack.isEmpty()||treeNode!=null){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.getLeft();
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                System.out.print(node.getData()+" ");
                treeNode=node.getRight();
            }
        }
    }

    /**
     * 层次遍历
     * @param root
     * @return
     * @author yangbin3
     * @date 2020/3/13
     */

    public static void levelList(TreeNode root){
        LinkedList<TreeNode> treeNodeLinkedList=new LinkedList<TreeNode>();
        treeNodeLinkedList.offer(root);
        while(!treeNodeLinkedList.isEmpty()){
            TreeNode treeNode = treeNodeLinkedList.poll();
            System.out.print(treeNode.getData()+" ");
            if(treeNode.getLeft()!=null){
                treeNodeLinkedList.offer(treeNode.getLeft());
            }
            if(treeNode.getRight()!=null){
                treeNodeLinkedList.offer(treeNode.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree();
        System.out.print("后序遍历：");
        postorderList(treeNode);
        System.out.println();
        System.out.print("前序遍历：");
        preOrderList(treeNode);
        System.out.println();
        System.out.print("中序遍历：");
        middleOrderList(treeNode);
        System.out.println();
        System.out.print("层次遍历：");
        levelList(treeNode);
    }
}
