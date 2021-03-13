package com.ityb.iv.arithmetic;

public class ReverseListByKGroup {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode  reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        //创建一个虚拟节点
        ListNode hh = new ListNode(0);
        hh.next = head; //头节点的前一个结点
        int len = 0;

        //计算链表的长度
        while (head != null) {
            len++;
            head = head.next;
        }

        //将链表进行翻转
        //pre:当前组头节点的前一个结点；first当前组翻转前的头节点；
        ListNode pre = hh;
        ListNode first = hh.next;
        ListNode temp;
        for (int i = 0; i < len / k; i++) {//对每一组进行翻转
            for (int j = 1; j < k; j++) {//对当前组进行翻转（不考虑翻转前的头节点）
                temp = first.next;//获取翻转节点；
                first.next = temp.next;//修改翻转节点的前一个结点的指针,指向翻转节点的下一个节点
                temp.next = pre.next;//将翻转结点插入到第一个节点位置
                pre.next = temp;
            }
            pre = first;//修改下一组的pre节点
            first = pre.next;//修改下一组翻转前的第一个节点
        }
        return hh.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = reverseKGroup(head,3);
        ListNode cur = head;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}
