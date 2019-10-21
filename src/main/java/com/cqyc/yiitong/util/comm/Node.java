package com.cqyc.yiitong.util.comm;

/**
 * @author: cqyc
 * Description: 节点
 *  Created by cqyc on 19-10-18
 */
public class Node {

    private final int value;

    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public static void printLinklist(Node head){
        while (head != null){
            System.out.println(head.getValue());
            head = head.getNext();
        }
        System.out.println();
    }
}
