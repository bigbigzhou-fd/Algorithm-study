package com.Oct;

import java.util.*;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-29 18:19
 * @description
 * 二叉树的后序遍历 注意判断条件 不要弄混了
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class L_lee_129_roottoleft {
    public static int sunNumbers(TreeNode root ){
        if(root == null){
            return 0;
        }
        // 一个后序遍历 一个map集合标记是否被访问过
        Stack<TreeNode> stack = new Stack<>();

        //记录node节点是否被访问过
        Map<TreeNode,Boolean> map = new HashMap<>();

        stack.push(root);
        map.put(root,false);//false:右节点没有被访问过

        //记录跟姐节点到叶子节点的值
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        TreeNode node = root;

        while(!stack.empty()){

            while(node.left!=null&&map.get(node)==false){//左孩子一直入栈
                stack.push(node.left);
                map.put(node.left,false);
                node = node.left;
            }
            node = stack.peek();

            if(map.get(node) == true){//这个节点的右孩子被访问过了

                TreeNode tnode =  stack.peek();//拿到出栈元素
//                System.out.println("节点："+""+tnode.val);

                //叶子节点 栈里面的元素就是到父节点路径
                if(tnode.left == null && tnode.right ==null){

                    int val = 0;
                    for (TreeNode node2:stack) {
                         val = val*10+node2.val;
                    }

                    list.add(val);
//                    System.out.println(list.size()+":"+val);
                    sum += val;
                }

                stack.pop();

            }else{
                map.put(node,true);//标记这个孩子的右边孩子被访问过
                if(node.right !=null){
                    stack.push(node.right);
                    map.put(node.right,false);
                }
                node = stack.peek();
            }

        }
//        System.out.println("结果："+list.toString());

        return sum;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
//        sunNumbers(node1);

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        sunNumbers(node1);


//        Stack<Integer> stack = new Stack<>();
//        for(int i =1;i<11;i++){
//            stack.push(i);
//        }
//        for (int t:
//             stack) {
//            System.out.println(t);
//        }
    }

}
