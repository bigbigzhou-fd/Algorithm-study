package com.Oct;
/*
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

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

public class A_Lee_2 {

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int len1 = 0;
        StringBuffer s1 = new StringBuffer();
        while(l1!=null){
            s1.append(l1.val);
            l1 = l1.next;
            len1++;
        }

        int len2 = 0;
        StringBuffer s2 = new StringBuffer();
        while(l2!=null){
            s2.append(l2.val);
            l2 = l2.next;
            len2++;
        }

        //转换成字符数组，逆序
        char[] a = String.valueOf(s1).toCharArray();
        char[] b = String.valueOf(s2).toCharArray();

        StringBuffer res = new StringBuffer();
        int add = 0;
        int i = 0;
        while(i<len1 && i< len2){
            int now = ((a[i]-'0')+(b[i]-'0')+add)%10;
            add = ((a[i]-'0')+(b[i]-'0')+add)/10;
            res.append(now);
            i++;
        }
        while(i<len1){
            int now = (a[i]-'0'+add)%10;
            add = (a[i]-'0'+add)/10;
            res.append(now);
            i++;
        }
        while(i<len2){
            int now = (b[i]-'0'+add)%10;
            add = (b[i]-'0'+add)/10;
            res.append(now);
            i++;
        }
        if(add!=0)
            res.append(add);

        System.out.println("结果1："+res);


        ListNode ln  = new ListNode();
        ln.val = res.charAt(0)-'0';
        ListNode lnow = ln;
        int m = 1;
        while(m<res.length()){
             ListNode llt = new ListNode();
             llt.val = res.charAt(m)-'0';
             lnow.next = llt;
             lnow = llt;
             m++;
        }
        return ln;
    }

    public static void main(String[] args) {
//       ListNode l1 = new ListNode();
//       l1.val = 9;
//        ListNode l2 = new ListNode();
//        l2.val = 9;
//        ListNode l3 = new ListNode();
//        l3.val = 9;
//        ListNode l4 = new ListNode();
//        l4.val = 9;
//        ListNode l5 = new ListNode();
//        l5.val = 9;
//        ListNode l6 = new ListNode();
//        l6.val = 9;
//        ListNode l7 = new ListNode();
//        l7.val = 9;
//
//        l1.next =l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;




//        ListNode l8 = new ListNode();
//        l8.val = 9;
//        ListNode l9 = new ListNode();
//        l9.val = 9;
//        ListNode l10 = new ListNode();
//        l10.val = 9;
//        ListNode l11 = new ListNode();
//        l11.val = 9;
//        l8.next = l9;
//        l9.next = l10;
//        l10.next = l11;


//        addTwoNumbers(l1,l8);

        ListNode ll1 = new ListNode();
        ll1.val = 2;
        ListNode ll2 = new ListNode();
        ll2.val = 4;
        ListNode ll3 = new ListNode();
        ll3.val = 3;
        ll1.next = ll2;
        ll2.next = ll3;

        ListNode l8 = new ListNode();
        l8.val = 5;
        ListNode l9 = new ListNode();
        l9.val = 6;
        ListNode l10 = new ListNode();
        l10.val = 4;
//        ListNode l11 = new ListNode();
//        l11.val = 9;
        l8.next = l9;
        l9.next = l10;
//        l10.next = l11;
        addTwoNumbers(ll1,l8);
    }
}
