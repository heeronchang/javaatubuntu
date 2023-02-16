package com.heeron.example.javaatubuntu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heeron.example.javaatubuntu.bag.Bag;
import com.heeron.example.javaatubuntu.graph.Digraph;
import com.heeron.example.javaatubuntu.graph.DigraphDFS;

@SuppressWarnings("unchecked")
@SpringBootApplication
public class JavaatubuntuApplication {

	public static void main(String[] args) {
		// test();
		test2();
		SpringApplication.run(JavaatubuntuApplication.class, args);
	}

	public static void test() {
		Bag<String> bags = new Bag();
		bags.add("hello");
		bags.add("yeah");
		bags.add("heeron");
		bags.add("apple");
		bags.add("alibaba");
		System.out.println(bags.size());
		
		for (String a : bags) {
			System.out.println(a);
		}
	}

	public static void test2() {
		Digraph d = new Digraph(5);
		d.addEdge(0, 1);
		d.addEdge(0, 2);
		d.addEdge(0, 4);
		d.addEdge(1, 0);
		d.addEdge(1, 4);
		System.out.println(d);

		DigraphDFS reachable = new DigraphDFS(d, 1);
		for (int v = 0; v < d.getV(); v++) {
			if (reachable.marked(v)) {
				System.out.println(v);
			}
		}
		System.out.println("reverse");

		Digraph rd = d.reverse();
		DigraphDFS reachable2 = new DigraphDFS(rd, 1);
		for (int v = 0; v < d.getV(); v++) {
			if (reachable2.marked(v)) {
				System.out.println(v);
			}
		}
	}
}
