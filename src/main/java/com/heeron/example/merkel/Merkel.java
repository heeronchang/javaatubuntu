package com.heeron.example.merkel;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Merkel {
  private String merkelHash;
  private List<String> list;

  public Merkel(List<String> list) {
    this.list = list;
    this.merkelHash = genMerkelHash(list);
  }

  private String genMerkelHash(List<String> list) {
    String result = "";
    if (list.isEmpty()) return result;
    if (list.size() == 1) {
      String s = list.get(0);
      result = Sm3Utils.encrypt(s);
      return result;
    }

    int mid = list.size() / 2;
    List<String> li1 = list.subList(0, mid);
    List<String> li2 = list.subList(mid, list.size());

    List<String> li = new ArrayList<String>();
    li.add(genMerkelHash(li1) + genMerkelHash(li2));
    result = genMerkelHash(li);

    return result;
  }
}


