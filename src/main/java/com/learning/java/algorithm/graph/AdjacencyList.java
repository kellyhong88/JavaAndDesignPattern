package com.learning.java.algorithm.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 图的数据结构实现（二）：邻接表
 * 参考：resources/photos下的adjacency_list.png
 */
public class AdjacencyList {

    static class AJGraph {

        /**
         * 节点
         * 可用list来存储，也可用map来存储
         */
        Map<String, Vertex> vertexMap;

        public AJGraph(Map<String, Vertex> vertexMap) {
            this.vertexMap = vertexMap;
        }

        // 插入节点
        public void insertVertex(String vertexName) {
            Vertex vertex = new Vertex(vertexName, null);
            vertexMap.put(vertexName, vertex);
        }

        // 删除节点
        public void deleteVertex(String vertexName) {
            if (vertexMap.containsKey(vertexName)) {
                vertexMap.remove(vertexName);
                /**
                 * 删除该节点相关的边
                 * 该节点出发的边不用删除，因为节点已经不在vertexMap中了，不会再被遍历到了
                 * 但到达该节点的边仍需删除，因为其他节点不知道该节点被删除了，仍会保留到该节点的边
                 * */
                for (String vertexKey : vertexMap.keySet()) {
                    Vertex vertex = vertexMap.get(vertexKey);
                    Edge currentEdge = vertex.edge;
                    Edge preEdge = currentEdge;
                    Edge nextEdge = currentEdge == null ? null : currentEdge.next;
                    boolean fromHead = true;
                    while (currentEdge != null) {
                        if (currentEdge.vertex.equals(vertexName)) {
                            if (fromHead) {
                                vertex.edge = nextEdge;
                                currentEdge = vertex.edge;
                                preEdge = currentEdge;
                            } else {
                                preEdge.next = nextEdge;
                            }
                        } else {
                            fromHead = false;
                            preEdge = currentEdge;
                        }
                        currentEdge = nextEdge;
                        nextEdge = nextEdge == null ? null : nextEdge.next;
                    }
                }
            }
        }

        // 插入边
        public void insertEdge(String beginVertexName, String endVertexName, int weight) {
            Vertex beginVertex = vertexMap.get(beginVertexName);
            // 若begin节点不存在，则初始化begin节点
            if (beginVertex == null) {
                beginVertex = new Vertex(beginVertexName, null);
                vertexMap.put(beginVertexName, beginVertex);
            }
            // 新建这条边，从begin节点指向end节点，权重为weight
            Edge edge = new Edge(endVertexName, weight, null);
            // 若begin节点还没有邻接的边，则直接把新边串上去
            if (beginVertex.edge == null) {
                beginVertex.edge = edge;
            }
            // 若begin节点已有邻接的边，则需找到最后一条边，并把新边串在最后
            else {
                Edge laseEdge = beginVertex.edge;
                while (laseEdge.next != null) {
                    laseEdge = laseEdge.next;
                }
                laseEdge.next = edge;
            }
        }

        // 打印图
        public void print() {
            Iterator<Map.Entry<String, Vertex>> iterator = vertexMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Vertex> entry = iterator.next();
                Vertex vertex = entry.getValue();
                System.out.println("Here we reach Vertex " + vertex.name);
                Edge edge = vertex.edge;
                if (edge == null) System.out.println("Vertex " + vertex.name + " doesn't have any edges going out");
                else {
                    System.out.println("Vertex " + vertex.name + " has edges below: ");
                    while (edge != null) {
                        System.out.println("Vertex " + vertex.name + " goes to Vertex " + edge.vertex
                                + " with the weight of " + edge.weight);
                        edge = edge.next;
                    }
                }
            }
        }

    }

    static class Vertex {

        /**
         * 节点名称
         * vertexMap中的key
         */
        private String name;

        /**
         * 节点的第一条边
         * 邻接表中的边用list来存储
         */
        private Edge edge;

        public Vertex(String name, Edge edge) {
            this.name = name;
            this.edge = edge;
        }
    }

    static class Edge {

        /**
         * 边的另一个尾/头节点名称
         * 若用邻接表，则此处为尾节点
         * 若用逆邻接表，则此处为头节点
         */
        private String vertex;

        /**
         * 边的权重值
         */
        private int weight;

        /**
         * 节点的下一条边
         * 邻接表中的边用list来存储
         */
        private Edge next;

        public Edge(String vertex, int weight, Edge next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 参考 resources/photos下的AJGraph.png
        Map<String, Vertex> vertexMap = new HashMap<String, Vertex>() {
            {
                put("A", new Vertex("A", null));
                put("B", new Vertex("B", null));
                put("C", new Vertex("C", null));
                put("D", new Vertex("D", null));
            }
        };
        // 初始化图，给到4个节点
        AJGraph graph = new AJGraph(vertexMap);
        // 再插入2个节点
        graph.insertVertex("E");
        graph.insertVertex("F");
        // 插入7条有向边和每条边的权重
        graph.insertEdge("A", "B", 4);
        graph.insertEdge("A", "D", 5);
        graph.insertEdge("C", "A", 1);
        graph.insertEdge("D", "E", 3);
        graph.insertEdge("D", "F", 4);
        graph.insertEdge("E", "B", 2);
        graph.insertEdge("F", "C", 2);

        // 打印图中的节点和边
        graph.print();

        // 删除1个节点
        graph.deleteVertex("F");
        System.out.println("************************");
        System.out.println("After deleting Vertex F:");
        graph.print();

        // 再删除1个节点
        graph.deleteVertex("D");
        System.out.println("************************");
        System.out.println("After deleting Vertex D:");
        graph.print();
    }

}
