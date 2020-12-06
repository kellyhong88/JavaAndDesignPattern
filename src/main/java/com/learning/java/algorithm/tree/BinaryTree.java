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
    public static List<Integer> preOrderTraversal(Node root, List<Integer> traversalList) {
        if (root == null) return traversalList;
        traversalList.add(root.data);
        preOrderTraversal(root.left, traversalList);
        preOrderTraversal(root.right, traversalList);
        return traversalList;
    }

    /**
     * 中序：左根右
     */
    public static List<Integer> inOrderTraversal(Node root, List<Integer> traversalList) {
        if (root == null) return traversalList;
        inOrderTraversal(root.left, traversalList);
        traversalList.add(root.data);
        inOrderTraversal(root.right, traversalList);
        return traversalList;
    }

    /**
     * 后序：左右根
     */
    public static List<Integer> postOrderTraversal(Node root, List<Integer> traversalList) {
        if (root == null) return traversalList;
        postOrderTraversal(root.left, traversalList);
        postOrderTraversal(root.right, traversalList);
        traversalList.add(root.data);
        return traversalList;
    }

    /**
     * 按层从上往下
     * 每层从左往右
     */
    public static List<List<Integer>> levelTraversal(Node root, int level, List<List<Integer>> traversalList) {
        if (root == null) return traversalList;
        if (traversalList.size() == level) {
            traversalList.add(new ArrayList<>());
        }
        traversalList.get(level).add(root.data);
        levelTraversal(root.left, level + 1, traversalList);
        levelTraversal(root.right, level + 1, traversalList);
        return traversalList;
    }

    public static void printPreOrder(Node root) {
        List<Integer> preTraversalList = preOrderTraversal(root, new ArrayList<>());
        BaseList.printList(preTraversalList);
    }

    public static void printInOrder(Node root) {
        List<Integer> inTraversalList = inOrderTraversal(root, new ArrayList<>());
        BaseList.printList(inTraversalList);
    }

    public static void printPostOrder(Node root) {
        List<Integer> postTraversalList = postOrderTraversal(root, new ArrayList<>());
        BaseList.printList(postTraversalList);
    }

    public static void printLevelOrder(Node root) {
        List<List<Integer>> levelTraversalList = levelTraversal(root, 0, new ArrayList<>());
        BaseList.printNestedList(levelTraversalList);
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
