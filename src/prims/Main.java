package prims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Character> vertices =new ArrayList<>(Arrays.asList('a','b','c','d','e','f'));
		List<Edge> edges = new ArrayList<>();
		
		edges.add(new Edge('a','b',4));
		edges.add(new Edge('a','f',2));
		edges.add(new Edge('f','b',5));
		edges.add(new Edge('c','b',6));
		edges.add(new Edge('c','f',1));
		edges.add(new Edge('f','e',4));
		edges.add(new Edge('d','e',2));
		edges.add(new Edge('d','c',3));
		
		Graph graph = new Graph(vertices, edges);
		
		List<Edge> MST=graph.Prims();
		
		for(Edge e : MST)
		{
			System.out.println(e.vertex1+" "+e.weight+" "+e.vertex2);
		}
	}

}
