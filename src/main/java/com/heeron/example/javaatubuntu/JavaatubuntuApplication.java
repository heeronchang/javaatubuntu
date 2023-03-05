package com.heeron.example.javaatubuntu;

import java.util.ArrayList;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heeron.example.adjacency.AdjacencyMatrix;
import com.heeron.example.dto.Person;
import com.heeron.example.javaatubuntu.bag.Bag;
import com.heeron.example.javaatubuntu.graph.Digraph;
import com.heeron.example.javaatubuntu.graph.DigraphDFS;
import com.heeron.example.merkel.Merkel;
import com.heeron.example.merkel.Sm3Utils;

@SuppressWarnings("unchecked")
@SpringBootApplication
public class JavaatubuntuApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaatubuntuApplication.class, args);
		// test();
		// test2();
		// test3();
		// test4();
		// testSM3();
		testMerkel();
		System.out.println();
		testMerkel2();
	}

	public static void testMerkel2() {
		String e0 = Sm3Utils.encrypt("0");
		String e1 = Sm3Utils.encrypt("1");
		String e2 = Sm3Utils.encrypt("2");
		String e3 = Sm3Utils.encrypt("3");
		String e4 = Sm3Utils.encrypt("4");
		String e01 = Sm3Utils.encrypt(e0+e1);
		String e34 = Sm3Utils.encrypt(e3+e4);
		String e234 = Sm3Utils.encrypt(e2 + e34);
		String e01234 = Sm3Utils.encrypt(e01+e234);
		System.out.println(e01234);
	}

	public static void testMerkel() {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("0");
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");

		Merkel merkel = new Merkel(arr);
		String hash = merkel.getMerkelHash();
		System.out.println(hash);
	}

	public static void testSM3() {
		String text = "0";
		String encrypt = Sm3Utils.encrypt(text);
		System.out.println("密文：" + encrypt);
		System.out.println("验证结果：" + Sm3Utils.verify(text, encrypt));
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

	public static void test3() {
		int numVertexes = 9;
		int numEdges = 15;
		AdjacencyMatrix<Person> graph = new AdjacencyMatrix<Person>(numVertexes, numEdges);
		Person A = new Person(0, "A", 18);
		graph.insertVex(A);
		Person B = new Person(1, "B", 18);
		graph.insertVex(B);
		graph.insertVex(new Person(2, "C", 18));
		graph.insertVex(new Person(3, "D", 18));
		graph.insertVex(new Person(4, "E", 18));
		graph.insertVex(new Person(5, "F", 18));
		graph.insertVex(new Person(6, "G", 18));
		graph.insertVex(new Person(7, "H", 18));
		graph.insertVex(new Person(8, "I", 18));
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 5, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 6, 1);
		graph.insertEdge(1, 8, 1);
		graph.insertEdge(2, 3, 1);
		graph.insertEdge(2, 8, 1);
		graph.insertEdge(3, 4, 1);
		graph.insertEdge(3, 6, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(3, 8, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(4, 5, 1);
		graph.insertEdge(5, 6, 1);
		graph.insertEdge(6, 7, 1);
		System.out.println("邻接矩阵");
		graph.show();
		System.out.print("深度优先遍历：");
		graph.DFSTraverse();
		System.out.println();
		System.out.print("广度优先遍历：");
		graph.BFSTraverse();

		System.out.println();
		System.out.println("A-->B可达状态: " + graph.isAdjacent(A, B));
	}

	public static void test4() {
		int numVertexes = 9;
		int numEdges = 15;
		AdjacencyMatrix<Person> graph = new AdjacencyMatrix<Person>(numVertexes, numEdges);
		Person A = new Person("A", 18);
		graph.insertVex(A);
		Person B = new Person("B", 18);
		graph.insertVex(B);
		graph.insertVex(new Person("C", 18));
		graph.insertVex(new Person("D", 18));
		graph.insertVex(new Person("E", 18));
		graph.insertVex(new Person("F", 18));
		graph.insertVex(new Person("G", 18));
		graph.insertVex(new Person("H", 18));
		graph.insertVex(new Person("I", 18));
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 5, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 6, 1);
		graph.insertEdge(1, 8, 1);
		graph.insertEdge(2, 3, 1);
		graph.insertEdge(2, 8, 1);
		graph.insertEdge(3, 4, 1);
		graph.insertEdge(3, 6, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(3, 8, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(4, 5, 1);
		graph.insertEdge(5, 6, 1);
		graph.insertEdge(6, 7, 1);
		System.out.println("邻接矩阵");
		graph.show();
		System.out.print("深度优先遍历：");
		graph.DFSTraverse();
		System.out.println();
		System.out.print("广度优先遍历：");
		graph.BFSTraverse();

		System.out.println();
		System.out.println("A-->B可达状态: " + graph.isAdjacent(A, B));
	}
}
