package kruskal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Graph {
	
	public static List<Vertex> vertices;
	public static List<Edge> edges;
	
	public Graph(List<Vertex> v, List<Edge> e){
		
		vertices=v;
		edges=e;
	}
	
	public static Vertex  Find(Vertex v){
		
		if(v.parent==v)
			return v.parent;
		else return Find(v.parent);
	}
	
	public static void Union(Vertex root1, Vertex root2){
		
		if(root1.rank>root2.rank)
			root2.parent=root1;
		else if(root1.rank<root2.rank)
			root1.parent=root2;
		
		else {
			root1.parent=root2;
			root2.rank++;
		}
	}
	
	public static void Kruskal(){
		
		List<Edge> A = new ArrayList<>();
		
		for(Vertex v : vertices){
			v.parent=v;
			v.rank=0;
		}
		
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge x, Edge y) {
				
				if(x.weight>y.weight)
					return 0;
				return -1;
			}
		});
		
		for(Edge e : edges){
			
			Vertex root1=Find(e.vertex1);
			Vertex root2=Find(e.vertex2);
			
			if(root1!=root2){
				A.add(e);
				Union(root1, root2);	
			}				
		}
		
		for(Edge e : A)
			System.out.println(e.vertex1.name+"==>"+e.vertex2.name+"="+e.weight);
	}
	
	public static void main(String[] args){
		
		List<Character> name =new ArrayList<>(Arrays.asList('a','b','c','d','e','f'));
		List<Vertex> vertex = new ArrayList<>();
		List<Edge> edge = new ArrayList<>();
		
		for(Character n : name)
			vertex.add(new Vertex(n));
		
		edge.add(new Edge(vertex.get(0),vertex.get(1),4));
		edge.add(new Edge(vertex.get(0),vertex.get(5),2));
		edge.add(new Edge(vertex.get(5),vertex.get(1),5));
		edge.add(new Edge(vertex.get(2),vertex.get(1),6));
		edge.add(new Edge(vertex.get(2),vertex.get(5),1));
		edge.add(new Edge(vertex.get(5),vertex.get(4),4));
		edge.add(new Edge(vertex.get(3),vertex.get(4),2));
		edge.add(new Edge(vertex.get(3),vertex.get(2),3));

		new Graph(vertex, edge);
		Kruskal();	
	}
}
