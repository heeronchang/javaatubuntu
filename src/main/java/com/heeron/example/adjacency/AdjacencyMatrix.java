package com.heeron.example.adjacency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 邻接矩阵
 */
public class AdjacencyMatrix<T extends VertexBase> {
  private ArrayList<T> vertexes; // 顶点表
  private int[][] egdes; // 边表
  int numVertexes, numEdges;
  // int numEdges;
  boolean[] visited;

  public AdjacencyMatrix(int numVertexes, int numEdges) {
    this.numVertexes = numVertexes;
    this.numEdges = numEdges;
    this.vertexes = new ArrayList<>(numVertexes);
    this.egdes = new int[numVertexes][numVertexes];
    this.visited = new boolean[numVertexes];
  }

  public void insertVex(T v) {
    v.setVertexNo(vertexes.size());
    vertexes.add(v);
  }

  public void insertEdge(int v1,int v2, int weight) {
    egdes[v1][v2] = weight;
  }

  public void insertEdge(T v1, T v2, int weight) {
    egdes[v1.getVertexNo()][v2.getVertexNo()] = weight;
  }

  public AdjacencyMatrix<T> reverse() {
    AdjacencyMatrix<T> adjMatrix = new AdjacencyMatrix<>(numVertexes, numEdges);
    for (int i = 0; i < numVertexes; i++) {
      for (int j = 0; j < numVertexes; j++) {
        adjMatrix.egdes[i][j] = egdes[j][i];
      }
    }

    return adjMatrix;
  }

  public boolean isAdjacent(int v1, int v2) {
    return egdes[v1][v2] > 0;
  }

  public boolean isAdjacent(T v1, T v2) {
    return egdes[v1.getVertexNo()][v2.getVertexNo()] > 0;
  }

  public void show() {
    for (int[] link : egdes) {
      System.out.println(Arrays.toString(link));
    }
  }

  public void DFS(int i) {
    visited[i] = true;
    System.out.print(vertexes.get(i) + " ");
    for (int j = 0; j < numVertexes; j++) {
      if (egdes[i][j] > 0 && !visited[j]) {
        DFS(j);
      }
    }
  }

  public void DFSTraverse() {
    int i;
    for (i = 0; i < numVertexes; i++) {
      visited[i] = false;
    }

    for (i = 0; i < numVertexes; i++) {
      if (!visited[i]) {
        DFS(i);
      }
    }
  }

  public void BFSTraverse() {
    int i,j;
    LinkedList<Integer> queue = new LinkedList<Integer>();

    for (i = 0; i < numVertexes; i++) {
      visited[i] = false;
    }

    for (i = 0; i < numVertexes; i++) {
      if (!visited[i]) {
        visited[i] = true;
        System.out.print(vertexes.get(i) + " ");
        queue.addLast(i);
        while(!queue.isEmpty()) {
          i = queue.removeFirst();
          for (j = 0; j < numVertexes; j++) {
            if (egdes[i][j] > 0 && !visited[j]) {
              visited[j] = true;
              System.out.print(vertexes.get(j) + " ");
              queue.addLast(j);
            }
          }
        }
      }
    }
  }
}
