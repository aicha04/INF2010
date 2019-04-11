package tp5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath (Node s, Node d) {

		int nNodes=graph.getNodes().size();
		dijkstraTable = new HashMap[nNodes];
		path = new Stack<Edge>();
		// A compléter
		Map<Node, Edge> debut=new HashMap<Node, Edge>();
		int min=0;
		debut.put(s,new Edge(s,s,min));
		dijkstraTable[0]=debut;
		Node current=s;
		
		for(int i=1; i<nNodes; i++)
		{
			Map<Node, Edge> retVal=new HashMap<Node, Edge>();
			List<Edge> arcSuivants=graph.getEdgesGoingFrom(current);
			for(Edge edge: arcSuivants)
			{
				retVal.put(current,new Edge(edge.getSource(), edge.getDestination(), edge.getDistance()+min));
				
			}
			
			dijkstraTable[i]=retVal;
			current=getMinimum(retVal) ;
			min=dijkstraTable[i].get(current).getDistance();
			path.push(dijkstraTable[i].get(current));
			
		}
		
		
		
		
		
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		return e1;
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
	}

	public void afficherTable () {
		// A completer
		
	}
}
