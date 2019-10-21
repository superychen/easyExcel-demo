package com.cqyc.yiitong.util.tree;

/**
 * @author: cqyc
 * Description: 遍历二叉树
 * Created by cqyc on 19-10-21
 */
public class TreeTraversal {

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getValue());
        inOrder(root.getRight());
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getValue());
    }

    public static void main(String[] args) {
        TreeCreator treeCreator = new TreeCreator();
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode sampleTree = treeCreator.createSampleTree();
        treeTraversal.preOrder(sampleTree);
        System.out.println("=============");
        treeTraversal.inOrder(sampleTree);
        System.out.println("=============");
        treeTraversal.postOrder(sampleTree);

        System.out.println("-------------");
        TreeNode tree = treeCreator.createTree("ABDEGCF", "DBGEACF");
        treeTraversal.postOrder(tree);
    }
}
