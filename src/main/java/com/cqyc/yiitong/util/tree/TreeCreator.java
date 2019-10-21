package com.cqyc.yiitong.util.tree;

/**
 * @author: cqyc
 * Description: 创建一棵树
 * Created by cqyc on 19-10-20
 */
public class TreeCreator {

    /**
     * 手动创建一个二叉树
     */
    public TreeNode createSampleTree() {
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('G'));
        root.setRight(new TreeNode('C'));
        root.getRight().setRight(new TreeNode('F'));
        return root;
    }

    /**
     * 根据前序遍历的结果以及中序遍历的结果创建一棵二叉树
     * 示例：ABDEGCF，DBGEACF
     */
    public TreeNode createTree(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }

        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.setLeft(createTree(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex)));
        root.setRight(createTree(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex)));
        return root;
    }

}
