package com.heeron.example.javaatubuntu.graph;

import com.heeron.example.javaatubuntu.bag.Bag;

@SuppressWarnings("unchecked")
public class Digraph {
  private final int V; // 顶点总数
  private int E; // 边总数
  private Bag<Integer>[] adj; // [邻接表]顶点为数组下标，值为当前下标为顶点值所连通的顶点

  public Digraph(int V) {
    this.V = V;
    this.E = 0;
    adj = new Bag[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new Bag<Integer>();
    }
  }

  public int getV() {
    return V;
  }

  public int getE() {
    return E;
  }

  /**
   * 返回一个顶点的连通顶点集合的迭代器
   * @param v 顶点
   * @return 顶点的连通顶点集合Bag
   */
  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    E++;
  }

  /**
   * 将图中所有边方向反转
   * @return 返回一个图将所有方向反转后的副本
   */
  public Digraph reverse() {
    Digraph r = new Digraph(V);
    for (int v = 0; v < V; v++) {
      for (int w : adj[v]) {
        r.addEdge(w, v);
      }
    }
    return r;
  }

  /**
   * 按照邻接表数组结构输出有向图内容
   */
  public String toString() {
    String s = V + " vertices, " + E + " edges\n";
    for (int v = 0; v < V; v++) {
      s += v + ": ";
      for (int w : this.adj(v)) {
        s += w + " ";
      }
      s += "\n";
    }
    return s;
  }
  
}
