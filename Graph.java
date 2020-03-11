package com.ambrin.pdc.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class Graph {

    public static HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    public static class Node{
        public int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        public Node (int id){
            this.id=id;

        }
    }

    public void addNode(int id) {
        nodeHashMap.put(id, new Node(id));
    }

    private Node getNode(Integer id) {

        return nodeHashMap.get(id);

    }

    public void addEdge(Node source,Node destination){

        source.adjacent.add(destination);

    }

    public boolean hasPathDFS(Node source, Node destination){

        HashSet<Integer> visited = new HashSet<>();
        if(!visited.contains(source.id)){
            visited.add(source.id);
        }

        if(source==destination){
            return true;
        }

        for (Node child:source.adjacent){
            if(hasPathDFS(child,destination)){
                return true;
            }
        }
        return false;

    }

    public boolean hasPathBFS(Node source, Node destination){

        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();

            if (node == destination) {
                return true;
            }

            if (!visited.contains(node.id)) {

                visited.add(node.id);

                for (Node child : node.adjacent) {
                    nextToVisit.add(child);
                }
            }
        }
        return false;

    }


}
