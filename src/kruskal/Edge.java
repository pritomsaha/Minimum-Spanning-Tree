package kruskal;

public class Edge{
		
		public Vertex vertex1,vertex2;
		public int weight;
		
		public Edge(Vertex v1,Vertex v2,int w)
		{
			vertex1=v1;
			vertex2=v2;
			weight=w;
		}
	}