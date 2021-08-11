package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.util.List;

/**
 * 以k个一组反转链表
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        ListNode end = temp;
        while(end.next != null){
            for (int i = 0;i < k && end!= null;i++)
            {
                end = end.next;
            }   //将end后移k位
            if(end == null) break;;                     //若链表不够k个直接返回原链表
            ListNode next = end.next;                   //记录断开前的尾节点指向
            //断开
            end.next = null;
            ListNode start = pre.next;                  //初始化要反转链表的头节点
            pre.next = reverse(start);                  //反转以k为一组的链表
            // 连接
            start.next = next;
            // 反转后重置变量
            pre = start;
            end = start;
        }
        return  temp.next;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next ==null) return head;
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nexNode = null;
        while (curNode != null){
            nexNode = curNode.next;   // 保存当前节点指向
            curNode.next = preNode;   // 当前节点指向前一个节点
            preNode = curNode;        // 前一个节点后移
            curNode = nexNode;        // 当前节点后移
        }
        return preNode;
    }
    @Test
    public void test(){
        ListNode head = ListNodeUtils.init(10);
        ListNodeUtils.print(head);
        System.out.println();
        ListNodeUtils.print(reverseKGroup(head,3));
    }
}
