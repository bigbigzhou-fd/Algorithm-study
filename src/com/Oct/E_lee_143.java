package com.Oct;

import java.util.ArrayList;
import java.util.List;

public class E_lee_143 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(){
        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public void recorderList(ListNode head) {
        if(head == null || head.next ==null){
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        int len = 0;
        while(head!=null){
            len ++;
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j =len-1;

        head = list.get(i);

        ListNode first = head;
        ListNode end = new ListNode();

        while(i<j){

            end = list.get(j);
            if(end == first.next){
                end.next = null;
                return;
            }
            end.next = first.next;
            first.next = end;
            first = end.next;
            i++;
            j--;
            if(i >= j)
                first.next =null;
        }
    }

    public static void main(String[] args) {

    }
}
