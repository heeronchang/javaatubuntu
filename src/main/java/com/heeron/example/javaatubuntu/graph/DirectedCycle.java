package com.heeron.example.javaatubuntu.graph;

import java.util.Stack;

// 寻找有向环
public class DirectedCycle {
  private boolean[] marked; // 以頂点为索引，值代表该顶点是否标记过（是否可达）
  private Stack<Integer> cycle; // 存储有向环顶点
}
