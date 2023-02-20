package com.heeron.example.adjacency;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 邻接表
 */
public class AdjacencyList<T> {
  private ArrayList<VertexNode<T>> vertexes;
  int numVertexes;
  int numEdges;
  boolean[] visited;

  public AdjacencyList(int numVertexes, int numEdges) {
    this.numVertexes = numVertexes;
    this.numEdges = numEdges;
    this.vertexes = new ArrayList<>(numVertexes);
    this.visited = new boolean[numVertexes];
  }

  public void insertVex(VertexNode<T> v) {
    vertexes.add(v);
  }

  public void addEdge(EdgeNode e) {
    int i = e.vex; // 顶点表中对应节点的下标
    VertexNode<T> vexi = vertexes.get(i);
    e.next = vexi.firstEdge;
    vexi.firstEdge = e;
    
    // 无向图，边是双向的
    int j = e.adjvex; // 邻接点在顶点表中对应的下标
    VertexNode<T> vexj = vertexes.get(j);
    EdgeNode e2 = new EdgeNode(j, i, 1);
    e2.next = vexj.firstEdge;
    vexj.firstEdge = e2;
  }

  public void show() {
    for (int i = 0; i < numVertexes; i++) {
      VertexNode<T> vex = vertexes.get(i);
      System.out.print("[" + vex.data + "]->");
      EdgeNode node = vex.firstEdge;
      while(node != null) {
        System.out.print(vertexes.get(node.adjvex).data + "(" + node.adjvex + ")" + "->");
        node = node.next;
      }

      System.out.print("null");
      System.out.println();
    }
  }

  public void DFS(int i) {
    visited[i] = true;
    System.out.print(vertexes.get(i).data + " ");
    EdgeNode p = vertexes.get(i).firstEdge;
    while (p != null) {
      if (!visited[p.adjvex]) {
        DFS(p.adjvex);
      }
      p = p.next;
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
    EdgeNode p;
    int i;
    LinkedList<Integer> queue = new LinkedList<Integer>();
    for (i = 0; i < numVertexes; i++) {
      visited[i] = false;
    }

    for (i = 0; i < numVertexes; i++) {
      visited[i] = true;
      System.out.print(vertexes.get(i).data + " ");
      queue.addLast(i);
      while(!queue.isEmpty()) {
        i = queue.removeFirst();
        p = vertexes.get(i).firstEdge;
        while(p != null) {
          if (!visited[p.adjvex]) {
            visited[p.adjvex] = true;
            System.out.print(vertexes.get(p.adjvex).data + " ");
            queue.addLast(p.adjvex);
          }
          p = p.next;
        }
      }
    }
  }
}

class EdgeNode {
  int vex;// 顶点表中对应节点的下标
  int adjvex;// 邻接点在顶点表中对应的下标
  int weight;
  EdgeNode next;

  public EdgeNode(int vex, int adjvex, int weight) {
    this.vex = vex;
    this.adjvex = adjvex;
    this.weight = weight;
    this.next = null;
  }
}

class VertexNode<T> {
  T data;
  EdgeNode firstEdge; // 当前顶点对应的边表的第一个节点

  public VertexNode(T data) {
    this.data = data;
    this.firstEdge = null;
  }
}