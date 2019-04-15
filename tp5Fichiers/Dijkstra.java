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
		ArrayList<Node> ListeNoeudsSelectionees = new ArrayList<Node>(); 
		ListeNoeudsSelectionees.add(current);
		
		int i=1;
		while(current!=d) {
			dijkstraTable[i]=new HashMap<Node, Edge>(dijkstraTable[i-1]);
			dijkstraTable[i].remove(current);
			for (Edge edge: graph.getEdgesGoingFrom(current)) {
				int distance=edge.getDistance()+dijkstraTable[i-1].get(current).getDistance();
				Edge edgeIncident=new Edge(edge.getSource(),edge.getDestination(),distance);
				
				if (ListeNoeudsSelectionees.contains(edge.getDestination())|| 
						dijkstraTable[i].containsKey(edge.getDestination())&& 
						getMinimum(dijkstraTable[i].get(edge.getDestination()),edgeIncident)==dijkstraTable[i].get(edge.getDestination())) 
				{
					
				}
				else {
					dijkstraTable[i].put(edgeIncident.getDestination(), edgeIncident);
					
				}
			}
			
			current=getMinimum(dijkstraTable[i]);
			
			
			ListeNoeudsSelectionees.add(current);
			if (current==d) {
				
				
				path.push(dijkstraTable[i].get(d));
				Node nextNode=dijkstraTable[i].get(d).getSource();
				int j=1;
				while (j<ListeNoeudsSelectionees.size()) {
					if (ListeNoeudsSelectionees.get(j)==nextNode) {
						
						path.push(dijkstraTable[j].get(nextNode));
						
						nextNode=dijkstraTable[j].get(nextNode).getSource();
						
						j=1;
					}
					else {
						j++;
					}
				}
				
			}
			
			i++;
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
		if (e1==null || e2==null) {
			return null;
		}
		
		else {
			if (e1.getDistance()<e2.getDistance()) {
				return e1;
			}
			
			else {
				return e2;
			}
		}
		
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
		String string="le chemin le plus court de "+source.getName()+" a "+destination.getName()+" est : ";
		string+=source.getName();
		int size=path.size();
		for (int i=0;i<size;i++) {
			Edge edge =path.pop();
			string+=" => "+edge.getDestination().getName();
		}
		return string;
		
	}

	public void afficherTable () {
		// A completer
		StringBuilder builder = new StringBuilder();
		builder.append("Table:\n");
		
		for (Node node: graph.getNodes()) {
			builder.append(node.getName()+"\t");
			
		}
		builder.append("\n");
		for (int i=0;i<dijkstraTable.length;i++) {
			for (Node node:graph.getNodes()) {
				if (dijkstraTable[i].containsKey(node)) {
					builder.append(dijkstraTable[i].get(node).getDistance());
					builder.append(dijkstraTable[i].get(node).getSource().getName()+"\t");
				}
				else {
					builder.append("\t");
				}
			
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
}

