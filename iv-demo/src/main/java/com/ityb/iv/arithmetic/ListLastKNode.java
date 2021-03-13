package com.ityb.iv.arithmetic;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class ListLastKNode {

    public class ListNode {
        ListNode next = null;
        int val;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode findKthToTail (ListNode pHead, int k) {
        ListNode p = pHead;
        ListNode quickNode = pHead;
        int currentIndex=0;
        while (currentIndex < k && quickNode != null ){
            quickNode = quickNode.next;
            currentIndex++;
        }
        if(currentIndex <k) return null;
        while(quickNode!=null){
            quickNode = quickNode.next;
            p = p.next;
        }
        return p;
    }
}
