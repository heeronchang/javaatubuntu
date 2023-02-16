package com.heeron.example.javaatubuntu.bag;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

  private class BagNode<T> {
    T item;
    BagNode<T> next;
  }

  BagNode<Item> head;
  int size;

  public Bag() {
    head = new BagNode<>();
    size = 0;
  }

  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      BagNode<Item> node = head;

      @Override
      public boolean hasNext() {
        return node.next != null;
      }

      @Override
      public Item next() {
        Item item = (Item) node.item;
        node = node.next;
        return item;
      }

    };
  }

  public void add(Item item) {
    BagNode<Item> temp = new BagNode<>();
    temp.next = head.next;
    temp.item = head.item;
    head.item = item;
    head.next = temp;
    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return this.size;
  }
}
