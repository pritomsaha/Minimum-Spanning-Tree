package prims;

import prims.Edge;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	public static List<Character> vertices;
	public static List<Edge> edges;
	
	public Graph(List<Character> v, List<Edge> e){
		
		vertices=v;
		edges=e;		
	}
	
	public static int getWeight(char v1,char v2){
		
		for(Edge e : edges){
			if((e.vertex1==v1&&e.vertex2==v2)||(e.vertex2==v1&&e.vertex1==v2))
				return e.weight;
		}	
		return 0;
	}
	
	public static Edge getMinimumWeightEdge(List<Character> v1, List<Character> v2 ){
		
		Edge e;

		int min=Integer.MAX_VALUE;
		
		char vertex1 = 0,vertex2 = 0;
		
		for(Character visted : v1){
			
			for(Character Nonvisted : v2){
				
				int temp=getWeight(visted, Nonvisted);
				if(temp!=0){
					if(temp<min){
						min=temp;
						vertex1=visted;
						vertex2=Nonvisted;
					}
				}
			}	
		}
		e=new Edge(vertex1, vertex2, min);
		
		return e;
	}
	
	public  List<Edge> Prims(){
		
		List<Edge> MintreeEdge = new ArrayList<>();
		
		List<Character> VistedVertex=new ArrayList<Character>();
		List<Character> NonVisitedVertex = new ArrayList<>();
		
		NonVisitedVertex=vertices;
		
		Character start=NonVisitedVertex.remove(0);
		VistedVertex.add(start);
		
		while(!NonVisitedVertex.isEmpty()){
			
			Edge temp=getMinimumWeightEdge(VistedVertex, NonVisitedVertex);
			MintreeEdge.add(temp);		
			VistedVertex.add(NonVisitedVertex.remove(NonVisitedVertex.indexOf(temp.vertex2)));			
		}		
		return MintreeEdge;
	}	
}


