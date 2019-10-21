package com.cqyc.yiitong.util.createlist;

import com.cqyc.yiitong.util.comm.Node;

import java.util.Arrays;

/**
 * @author: cqyc
 * Description:用递归的方式控制list反转
 * Created by cqyc on 19-10-18
 */
public class LinklistReverse {

    /**
     * 反转一个linkList
     * @param head head the linked list to reverse
     * @return head of the reversed linked list
     */
    public Node reverseLinkedList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        LinkListCreate creator = new LinkListCreate();
        LinklistReverse reverse = new LinklistReverse();
        Node.printLinklist(reverse.reverseLinkedList(creator.createLinkList(Arrays.asList(1, 2, 3, 4, 5))));
    }
}