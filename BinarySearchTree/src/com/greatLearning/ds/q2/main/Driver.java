package com.greatLearning.ds.q2.main;

import java.util.HashSet;

class Node {
    int data;
    Node left, right;
    
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    Node root;
    HashSet<Integer> set;

    public BST() {
        root = null;
        set = new HashSet<>();
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    boolean findPair(Node root, int sum, HashSet<Integer> set, int[] pair) {
        if (root == null)
            return false;

        if (findPair(root.left, sum, set, pair))
            return true;

        if (set.contains(sum - root.data)) {
            pair[0] = root.data;
            pair[1] = sum - root.data;
            return true;
        } else
            set.add(root.data);

        return findPair(root.right, sum, set, pair);
    }

    void findPairWrapper(int sum) {
        int[] pair = new int[2];
        HashSet<Integer> set = new HashSet<>();
        boolean found = findPair(root, sum, set, pair);
        if (found)
            System.out.println("Pair is (" + pair[0] + "," + pair[1]+")");
        else
            System.out.println("Nodes are not found");
    }
}

public class Driver {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);

        int Sum = 450;
        tree.findPairWrapper(Sum);
    }
}