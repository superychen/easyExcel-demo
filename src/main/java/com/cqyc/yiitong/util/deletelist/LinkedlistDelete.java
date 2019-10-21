package com.cqyc.yiitong.util.deletelist;

import com.cqyc.yiitong.util.comm.Node;
import com.cqyc.yiitong.util.createlist.LinkListCreate;

import java.util.Arrays;

/**
 * @author: cqyc
 * Description: 链表循环删除节点
 * Created by cqyc on 19-10-20
 */
public class LinkedlistDelete {
    public Node deleteIfEquals(Node head, int value) {
        while (head != null && head.getValue() == value) {
            head = head.getNext();
        }
        if (head == null) {
            return null;
        }
        Node prev = head;
        while (prev.getNext() != null) {
            if (prev.getNext().getValue() == value) {
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkListCreate create = new LinkListCreate();
        LinkedlistDelete delete = new LinkedlistDelete();
        Node.printLinklist(delete.deleteIfEquals(create.createLinkList(Arrays.asList(2, 2, 4, 5, 6, 7, 8)), 2));
    }
}
