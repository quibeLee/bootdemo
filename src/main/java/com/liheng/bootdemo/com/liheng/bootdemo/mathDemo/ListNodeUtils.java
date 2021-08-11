package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

/**
 * 简单单链表
 */
public class ListNodeUtils {
    private static ListNode head;
    private static ListNode current;


    public static void add(int data){
        if(head == null){
            head = new ListNode(data);
            current = head;
        }else {
            current.next = new ListNode(data);
            current = current.next;
        }
    }

    public static void print(ListNode node){
        if(node == null){
            return ;
        }
        current = node;
        while (current != null){
            System.out.print(current.val + "");
            current = current.next;
        }
    }

    public static ListNode init(int con){
        for (int i = 0;i < con;i++){
            add(i);
        }
        return head;
    }

    public static int length(ListNode node){
        if(head == null){
            return -1;
        }
        int length = 0;
        current = head;
        while (current != null){
            length ++;
            current = current.next;
        }
        return length;
    }
}
