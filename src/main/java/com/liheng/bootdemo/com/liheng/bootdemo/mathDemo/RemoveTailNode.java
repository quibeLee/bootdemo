package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import java.util.HashMap;
import java.util.Map;

public class RemoveTailNode {
    /**
     * 穷尽法：将链表遍历寻找需要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeTailNode(ListNode head, int n){
        ListNode pre = new ListNode(0,head);
        ListNode cur = pre;
        int len = getLength(head);
        for(int i = 1;i < len-n+1;++i){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = pre.next;
        return ans;
    }

    public int getLength(ListNode head){
        int len = 0;
        while (head != null){
            ++len;
            head = head.next;
        }
        return len;
    }

    /**
     * 快慢指针：用于解决链表遍历节点，和链表闭环问题
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNode(ListNode head, int n){
        ListNode pre = new ListNode(0,head);
        ListNode first = head;
        ListNode second = pre;
        for(int i = 0; i < n;i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = pre.next;
        return ans;
    }


    public String remap(String key){
        Map map = new HashMap();
        map.put("(",")");
        return map.get(key).toString();
    }
}
