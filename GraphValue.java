package com.ambrin.pdc.tree;

import linkedlist.Node;

public class GraphValue {
    public static void main(String[] args) {
        Graph test = new Graph();

        Graph.Node A = new Graph.Node(0);
        Graph.Node B= new Graph.Node(1);
        Graph.Node C= new Graph.Node(2);
        Graph.Node D= new Graph.Node(3);

        test.addEdge(A,B);
        test.addEdge(A,C);
        test.addEdge(B,C);
        test.addEdge(B,D);

        System.out.println("The path is:" + test.hasPathDFS(A,D));
        System.out.println("The Breadth first search result is :" + test.hasPathBFS(C,B));

    }
}
