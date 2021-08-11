package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

public class mergeKSizeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length -1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        if(left == right){
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists,left,mid),merge(lists,mid+1,right));
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        return getListNode(l1, l2);
    }
    static ListNode getListNode(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null ? l1 : l2);
        return head.next;
    }
}
