package com.Oct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-27 10:04
 * @description
 */
public class J_lee_144_preorderBinnaryTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //递归去写，怎么解决list被之前赋值的问题

    public static List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){

        if(root == null){
            return list;
        }
        list.add(root.val);
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        if(root.right!=null){
            preorderTraversal(root.right);
        }

        return list;
    }

    //先序遍历，非递归
    public List<Integer> noRecursivePreOrder(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        //根节点 左孩子节点 右孩子节点
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return  list;
        }

        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
