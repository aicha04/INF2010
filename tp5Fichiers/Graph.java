package tp5;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		// A compléter 
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		// A complèter 
		List<Edge> liste= new ArrayList<Edge>();
		for (int i =0; i<edges.size();i++) {
			if (edges.get(i).getSource()==source) {
				liste.add(edges.get(i));
			}
		}
		return liste;
	}
	public List<Edge> getEdgesGoingTo(Node dest) {
		// A complèter
		List<Edge> liste= new ArrayList<Edge>();
		for (int i =0; i<edges.size();i++) {
			if (edges.get(i).getDestination()==dest) {
				liste.add(edges.get(i));
			}
		}
		return liste;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
