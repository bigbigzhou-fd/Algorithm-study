package com.Oct;

//重新排列列表
//1->2->3->4->5 1->5->2->4->3
//1->2->3->4 1->4->2->3

public class D_lee_143 {
    class ListNode{
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

    public void recorderList(ListNode head){
        //head不动
        ListNode h2 = head;//h2构建新链表
        ListNode h3 = head;//标记h3中节点的

        int len = 1;
        while(h3.next!=null){
            len++;

            ListNode temp = h3.next;
            temp.next = h2;
            h2 = temp;

            h3 = h3.next;
        }

        int x = len/2;
        h3 = head;
        ListNode node = h2;
        while(x-- > 0){

            node.next = h3.next;
            h3.next = node;
            h2 = h2.next;
            h3 = node.next;
            node = h2;

            if(x==0 && len%2 == 1){
                h3.next.next = null;
            }else{
                h3.next = null;
            }
        }
    }



    public static void main(String[] args) {

    }

}
