package com.learning.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * */
public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static boolean noNeedTraversal(Node root) {
        return root == null || (root.left == null && root.right == null);
    }

    /**
     * 前序：根左右
     */
    static void preOrderTraversal(Node root, List<Integer> answers) {
        if (noNeedTraversal(root)) return;
        answers.add(root.data);
        preOrderTraversal(root.left, answers);
        preOrderTraversal(root.right, answers);
    }

    /**
     * 中序：左根右
     */
    static void inOrderTraversal(Node root, List<Integer> answers) {
        if (noNeedTraversal(root)) return;
        inOrderTraversal(root.left, answers);
        answers.add(root.data);
        inOrderTraversal(root.right, answers);
    }

    /**
     * 后序：左右根
     */
    static void postOrderTraversal(Node root, List<Integer> answers) {
        if (noNeedTraversal(root)) return;
        postOrderTraversal(root.left, answers);
        postOrderTraversal(root.right, answers);
        answers.add(root.data);
    }

    public static void main(String[] args) {
        List<Integer> preAnswer = new ArrayList<>();
        List<Integer> inAnswer = new ArrayList<>();
        List<Integer> postAnswer = new ArrayList<>();
        BinaryTree tree = new BinaryTree();
        Node root = tree.new Node(0);

        /**
         * initialize an binary tree
         * */

        preOrderTraversal(root, preAnswer);
        inOrderTraversal(root, inAnswer);
        postOrderTraversal(root, postAnswer);

        /**
         * print out preAnswers, inAnswers, postAnswers
         * */

    }

}
