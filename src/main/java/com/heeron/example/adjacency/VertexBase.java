package com.heeron.example.adjacency;

public abstract class VertexBase {
  protected int vertexNo;

  public int getVertexNo() {
    return vertexNo;
  }

  public void setVertexNo(int vertexNo) {
    this.vertexNo = vertexNo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + vertexNo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VertexBase other = (VertexBase) obj;
    if (vertexNo != other.vertexNo)
      return false;
    return true;
  }

  
}
