package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

/**
 * 两两交换链表中的节点
 * @author liheng
 */
public class SwapPairs {
    /**
     * 递归调用
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead;
        ListNode temp = head.next.next;
        newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(temp);
        return newHead;
    }

    @Test
    public  void test(){
        ListNode head = ListNodeUtils.init(10);
        ListNodeUtils.print(head);
        System.out.println();
        ListNodeUtils.print(swapPairs(head));
    }
}


