package com.ityb.iv.tree;

import java.util.LinkedList;

/**
 * Created by viruser on 2020/5/20.
 */
public class CompleteTree {


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree();
        System.out.println(isCompleteTree(treeNode));
    }

    public static boolean isCompleteTree(TreeNode root){
        LinkedList<TreeNode> linkedList=new LinkedList<TreeNode>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            TreeNode node = linkedList.poll();
            if(node.getLeft()!=null){
                if(node.getRight()==null){
                    return false;
                }
                linkedList.add(node.getLeft());
            }
            if(node.getRight()!=null){
                linkedList.add(node.getRight());
            }
        }
        return true;
    }
}
