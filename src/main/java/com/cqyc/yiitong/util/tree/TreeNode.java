package com.cqyc.yiitong.util.tree;

/**
 * @author: cqyc
 * Description: 树的节点实体类
 * Created by cqyc on 19-10-20
 */
public class TreeNode {
    private final char value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
