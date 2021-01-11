package com.learning.java.algorithm.tree;

import com.learning.java.algorithm.list.BaseList;
import com.learning.java.algorithm.tree.BinaryTree.*;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTreeZigzag {

    public static List<List<Integer>> zigzagTraverseUsingQueue(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(Arrays.asList(root.data));
            return result;
        }

        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        // 层数 0：第一层  1：第二层 ...
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> resultOfCurrentLevel = new LinkedList();
            int sizeOfCurrentLevel = queue.size();
            while (sizeOfCurrentLevel > 0) {
                Node node = queue.poll();
                if (level % 2 == 0) {
                    // 在list尾部添加节点
                    resultOfCurrentLevel.add(node.data);
                } else {
                    // 在list首部添加节点（参考：https://blog.csdn.net/qq_38304320/article/details/103737343）
                    resultOfCurrentLevel.add(0, node.data);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                sizeOfCurrentLevel--;
            }
            result.add(resultOfCurrentLevel);
            level++;
        }
        return result;
    }

    public static List<List<Integer>> zigzagTraverseUsingStack(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(Arrays.asList(root.data));
            return result;
        }

        Stack<Node> stackA = new Stack<>();
        Stack<Node> stackB = new Stack<>();
        stackA.push(root);

        while (!stackA.empty() || !stackB.empty()) {
            if (!stackA.empty()) {
                List<Integer> resultOfCurrentLevel = new LinkedList<>();
                while (!stackA.empty()) {
                    Node node = stackA.pop();
                    resultOfCurrentLevel.add(node.data);
                    if (node.left != null) stackB.push(node.left);
                    if (node.right != null) stackB.push(node.right);
                }
                result.add(resultOfCurrentLevel);
            }
            if (!stackB.empty()) {
                List<Integer> resultOfCurrentLevel = new LinkedList<>();
                while (!stackB.empty()) {
                    Node node = stackB.pop();
                    resultOfCurrentLevel.add(node.data);
                    if (node.right != null) stackA.push(node.right);
                    if (node.left != null) stackA.push(node.left);
                }
                result.add(resultOfCurrentLevel);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node binaryTree = BinaryTree.createBinaryTree();
        BaseList.printNestedList(zigzagTraverseUsingQueue(binaryTree));
        binaryTree = BinaryTree.createBinaryTree();
        BaseList.printNestedList(zigzagTraverseUsingStack(binaryTree));
    }

}
