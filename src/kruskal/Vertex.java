package kruskal;

public class Vertex{
		
		public char name;
		public Vertex parent;
		public int rank;
		
		public Vertex(char n)
		{
			name=n;
		}
}