package com.learning.java.algorithm.tree;

import com.learning.java.algorithm.list.BaseList;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 */
public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 前序：根左右
     */
    public static List<Integer> preOrderTraversal(Node root, List<Integer> answers) {
        if (root == null) return answers;
        answers.add(root.data);
        preOrderTraversal(root.left, answers);
        preOrderTraversal(root.right, answers);
        return answers;
    }

    /**
     * 中序：左根右
     */
    public static List<Integer> inOrderTraversal(Node root, List<Integer> answers) {
        if (root == null) return answers;
        inOrderTraversal(root.left, answers);
        answers.add(root.data);
        inOrderTraversal(root.right, answers);
        return answers;
    }

    /**
     * 后序：左右根
     */
    public static List<Integer> postOrderTraversal(Node root, List<Integer> answers) {
        if (root == null) return answers;
        postOrderTraversal(root.left, answers);
        postOrderTraversal(root.right, answers);
        answers.add(root.data);
        return answers;
    }

    /**
     * 按层从上往下
     */
    public static List<List<Integer>> levelTraversal(Node root, int level, List<List<Integer>> answers) {
        if (root == null) return answers;
        if (answers.size() == level) {
            answers.add(new ArrayList<>());
        }
        answers.get(level).add(root.data);
        levelTraversal(root.left, level + 1, answers);
        levelTraversal(root.right, level + 1, answers);
        return answers;
    }

    public static void printPreOrder(Node root) {
        List<Integer> preAnswer = preOrderTraversal(root, new ArrayList<>());
        BaseList.printList(preAnswer);
    }

    public static void printInOrder(Node root) {
        List<Integer> inAnswer = inOrderTraversal(root, new ArrayList<>());
        BaseList.printList(inAnswer);
    }

    public static void printPostOrder(Node root) {
        List<Integer> postAnswer = postOrderTraversal(root, new ArrayList<>());
        BaseList.printList(postAnswer);
    }

    public static void printLevelOrder(Node root) {
        List<List<Integer>> levelAnswer = levelTraversal(root, 0 ,new ArrayList<>());
        BaseList.printList2(levelAnswer);
    }

    public static Node createBinaryTree() {
        BinaryTree tree = new BinaryTree();
        Node root = tree.new Node(1);
        Node n2 = tree.new Node(2);
        Node n3 = tree.new Node(3);
        Node n4 = tree.new Node(4);
        Node n5 = tree.new Node(5);
        Node n6 = tree.new Node(6);
        Node n7 = tree.new Node(7);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return root;
    }

    public static Node createBinarySearchTree() {
        BinaryTree tree = new BinaryTree();
        Node root = tree.new Node(4);
        Node n1 = tree.new Node(1);
        Node n2 = tree.new Node(2);
        Node n3 = tree.new Node(3);
        Node n5 = tree.new Node(5);
        Node n6 = tree.new Node(6);
        Node n7 = tree.new Node(7);
        root.left = n2;
        root.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        return root;
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();
        printPreOrder(root);
        printInOrder(root);
        printPostOrder(root);
        printLevelOrder(root);
    }

}
