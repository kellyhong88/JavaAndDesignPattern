package com.learning.java.algorithm.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 图的数据结构实现（一）：邻接矩阵
 * 参考：resources/photos下的adjacency_matrix.png, adjacency_matrix_2.png
 */
public class AdjacencyMatrix {

    static class AMGraph {

        /**
         * 节点
         * 可用list存储节点，也可用array存储节点
         */
        private List<String> vertexes;

        /**
         * 边
         * 邻接矩阵中的边用矩阵（即二维数组）来存储
         * 二维数组中的横纵索引即为两个节点的索引（对应vertexes中的索引）
         * 若为有向图，则横索引是边的头节点的索引，纵索引是边的尾节点的索引
         * 二维数组中的值：若两个节点之间没有边，则值为0；若两个节点之间有边，则值为1或weight（权重值）
         */
        private int[][] edges;

        // 边的数目
        private int numOfEdges;

        // 初始化图
        public AMGraph(List<String> vertexes) {
            this.vertexes = vertexes;
            edges = new int[vertexes.size()][vertexes.size()];
            numOfEdges = 0;
        }

        // 获取节点数目
        public int getNumOfVertexes() {
            return vertexes.size();
        }

        // 获取边的数目
        public int getNumOfEdges() {
            return numOfEdges;
        }

        // 获取节点
        public String getVertex(int indexOfVertex) {
            if (indexOfVertex < 0 || indexOfVertex > vertexes.size()) return "NO SUCH VERTEX";
            return vertexes.get(indexOfVertex);
        }

        // 获取边的权重（0则代表无边）
        public int getWeight(int indexOfV1, int indexOfV2) {
            if (indexOfV1 < 0 || indexOfV1 > vertexes.size()
                    || indexOfV2 < 0 || indexOfV2 > vertexes.size())
                return 0;
            return edges[indexOfV1][indexOfV2];
        }

        // 插入边
        public void insertEdge(int v1, int v2, int weight) {
            edges[v1][v2] = weight;
            numOfEdges++;
        }

        // 删除边
        public void deleteEdge(int v1, int v2) {
            edges[v1][v2] = 0;
            numOfEdges--;
        }

        // 获取一个节点（索引）的第一个邻接节点（索引）
        public int getFirstNeighbor(int index) {
            for (int i = 0; i < vertexes.size(); i++) {
                if (edges[index][i] > 0) {
                    return i;
                }
            }
            return -1;
        }

        // 根据前一个邻接节点（索引）获取节点（索引）的下一个邻接节点（索引）
        public int getNextNeighbor(int index, int neighbor) {
            for (int i = neighbor + 1; i < vertexes.size(); i++) {
                if (edges[index][i] > 0) {
                    return i;
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        // 参考 resources/photos下的AMGraph.png
        List<String> vertexes = new LinkedList<String>() {{
            add("V1");
            add("V2");
            add("V3");
            add("V4");
        }};
        // 初始化图，给到4个节点
        AMGraph graph = new AMGraph(vertexes);
        // 插入4条有向边和每条边的权重
        graph.insertEdge(0, 1, 2);
        graph.insertEdge(0, 2, 5);
        graph.insertEdge(2, 3, 8);
        graph.insertEdge(3, 0, 7);

        System.out.println("number of vertexes: " + graph.getNumOfVertexes());
        System.out.println("number of edges: " + graph.getNumOfEdges());
        System.out.println("the first neighbor of " + "Vertex " + graph.getVertex(0)
                + " is " + graph.getVertex(graph.getFirstNeighbor(0)));
        System.out.println("the second neighbor of " + "Vertex " + graph.getVertex(0)
                + " is " + graph.getVertex(graph.getNextNeighbor(0, graph.getFirstNeighbor(0))));
        System.out.println("the weight of edge between Vertex " + graph.getVertex(2)
                + " and Vertex " + graph.getVertex(3) + " is " + graph.getWeight(2, 3));
        System.out.println("the weight of edge between Vertex " + graph.getVertex(3)
                + " and Vertex " + graph.getVertex(0) + " is " + graph.getWeight(3, 0));

        // 删除1条边
        graph.deleteEdge(0, 2);
        System.out.println("number of vertexes: " + graph.getNumOfVertexes());
        System.out.println("number of edges: " + graph.getNumOfEdges());
        System.out.println("the first neighbor of " + "Vertex " + graph.getVertex(0)
                + " is " + graph.getVertex(graph.getFirstNeighbor(0)));
        System.out.println("the second neighbor of " + "Vertex " + graph.getVertex(0)
                + " is " + graph.getVertex(graph.getNextNeighbor(0, graph.getFirstNeighbor(0))));
    }


}
