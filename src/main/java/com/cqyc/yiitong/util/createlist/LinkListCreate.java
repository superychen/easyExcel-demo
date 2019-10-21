package com.cqyc.yiitong.util.createlist;

import com.cqyc.yiitong.util.comm.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: cqyc
 * Description: 列出所有的的组合，给定输出的几位数
 * Created by cqyc on 19-10-18
 */
public class LinkListCreate {

    /**
     * 用递归的方式创建一个linklist
     * @param data 数据转换成list
     * @return
     */
    public Node createLinkList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        //递归
        Node headOfSublist = createLinkList(data.subList(1, data.size()));
        firstNode.setNext(headOfSublist);
        return firstNode;
    }

    /**
     * 用循环的方式创建一个非常大的list
     * @param size 大小
     * @return
     */
    public Node createLargeLinkedList(int size){
        Node prev = null;
        Node head = null;
        for (int i = 0; i < size; i++) {
            Node node = new Node(i);
            if(prev != null){
                prev.setNext(node);
            }else {
                head = node;
            }
            prev = node;
        }
        return head;
    }


    public static void main(String[] args) {
        LinkListCreate creator = new LinkListCreate();
        Node.printLinklist(creator.createLinkList(new ArrayList<>()));
        Node.printLinklist(creator.createLinkList(Arrays.asList(1)));
        System.out.println("===============");
        Node.printLinklist(creator.createLinkList(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

}
