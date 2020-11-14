package com.Nov;

import javax.xml.soap.Node;
import java.util.List;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-14 16:49
 * @description
 * 奇数位置的节点放在前面，偶数位置的节点放在后面
 * 时间复杂度 O(n) 空间复杂度 O(1)
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
class  ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class E_lee_328 {

    public static  ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        int i=2;
        ListNode pre = head;
        ListNode curr = pre.next;

        ListNode end = head;

        while (curr!= null){

            if(i%2 ==0){
                pre = curr;
                curr = curr.next;
                i++;

            }else{
                //断开
                pre.next = curr.next;

                //在前面的位置连上
                curr.next = end.next;
                end.next = curr;
                end = curr;

                i++;

                curr = pre.next;
            }
        }

        return head;
    }

    public static  void print(ListNode node){
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
////        ListNode node1 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
//        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        print(node1);
        ListNode res  = oddEvenList(node1);
        print(res);

    }

}
