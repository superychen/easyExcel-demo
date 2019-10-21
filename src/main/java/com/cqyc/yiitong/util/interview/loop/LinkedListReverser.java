package com.cqyc.yiitong.util.interview.loop;

import com.cqyc.yiitong.util.comm.Node;
import com.cqyc.yiitong.util.createlist.LinkListCreate;

import java.util.Arrays;

/**
 * @author: cqyc
 * Description: 用循环的方式控制list反转
 * Created by cqyc on 19-10-18
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = null;
        Node curHead = head;

        //循环不定式
        //newHead指向已经反转的链表
        //curHead指向我们还没有反转的链表
        while (curHead != null) {
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkListCreate creator = new LinkListCreate();
        LinkedListReverser reverse = new LinkedListReverser();
        Node.printLinklist(reverse.reverseLinkedList(creator.createLinkList(Arrays.asList(1, 2, 3, 4, 5))));
        //反转100万个链表
        reverse.reverseLinkedList(creator.createLargeLinkedList(1000000));
    }

}
