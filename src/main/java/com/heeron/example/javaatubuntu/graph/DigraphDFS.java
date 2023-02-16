package com.heeron.example.javaatubuntu.graph;

public class DigraphDFS {
  private boolean[] marked; // 是否标记过

  /**
   * 图中从某个顶点出发的所有顶点
   * @param digraph 图
   * @param start 顶点
   */
  public DigraphDFS(Digraph digraph, int start) {
    marked = new boolean[digraph.getV()];
    dfs(digraph, start);
  }

  /**
   * 图中从某些顶点出发的所有顶点
   * @param digraph
   * @param startSet
   */
  public DigraphDFS(Digraph digraph, Iterable<Integer> startSet) {
    marked = new boolean[digraph.getV()];
    for (int w : startSet) {
      dfs(digraph, w);
    }
  }

  /**
   * 查询某个顶点是否可达<被标记过即为可达>
   * @param v
   * @return
   */
  public boolean marked(int v) {
    return marked[v];
  }

  /**
   * 标记图中从 v 出发的所有顶点
   * @param digraph
   * @param v
   */
  private void dfs(Digraph digraph, int v) {
    marked[v] = true;
    for (int w : digraph.adj(v)) {
      if (!marked(w)) dfs(digraph, w); // 如w顶点未到达过（未标记过），则继续从w开始dfs
    }
  }
}
