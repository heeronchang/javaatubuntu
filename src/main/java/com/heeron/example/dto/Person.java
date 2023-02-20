package com.heeron.example.dto;

import com.heeron.example.adjacency.VertexBase;

public class Person extends VertexBase {
  // private int vertexNo; // 顶点编号
  private String name;
  private int age;

  public Person(int vertexNo, String name, int age) {
    this.vertexNo = vertexNo;
    this.name = name;
    this.age = age;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getVertexNo() {
    return vertexNo;
  }

  public void setVertexNo(int vertexNo) {
    this.vertexNo = vertexNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String toString() {
    return "vertex no:" + vertexNo + " name:" + name + " age:" + age;
  }
}
