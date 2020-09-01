package com.learning.java.algorithm.tree;

import com.learning.java.algorithm.list.BaseList;

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

    /**
     * 前序：根左右
     */
    static void preOrderTraversal(Node root, List<Integer> answers) {
        if (root == null) return;
        answers.add(root.data);
        preOrderTraversal(root.left, answers);
        preOrderTraversal(root.right, answers);
    }

    /**
     * 中序：左根右
     */
    static void inOrderTraversal(Node root, List<Integer> answers) {
        if (root == null) return;
        inOrderTraversal(root.left, answers);
        answers.add(root.data);
        inOrderTraversal(root.right, answers);
    }

    /**
     * 后序：左右根
     */
    static void postOrderTraversal(Node root, List<Integer> answers) {
        if (root == null) return;
        postOrderTraversal(root.left, answers);
        postOrderTraversal(root.right, answers);
        answers.add(root.data);
    }

    public static void main(String[] args) {
        List<Integer> preAnswer = new ArrayList<>();
        List<Integer> inAnswer = new ArrayList<>();
        List<Integer> postAnswer = new ArrayList<>();
        BinaryTree tree = new BinaryTree();
        Node root = tree.new Node(1);
        Node n2 = tree.new Node(2);
        Node n3 = tree.new Node(3);
        Node n4 = tree.new Node(4);
        Node n5 = tree.new Node(5);
        Node n6 = tree.new Node(6);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        preOrderTraversal(root, preAnswer);
        inOrderTraversal(root, inAnswer);
        postOrderTraversal(root, postAnswer);

        BaseList.printList(preAnswer);
        BaseList.printList(inAnswer);
        BaseList.printList(postAnswer);
    }

}
