package tp5;
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		// Partie 1: A completer : Création du graphe
		
	  List<Node> listeNodes=new ArrayList <Node>();
		
		Node A=new Node(0,"A");
		Node B=new Node(1,"B");
		Node C=new Node(2,"C");
		Node D=new Node(3,"D");
		Node E=new Node(4,"E");
		Node F=new Node(5,"F");
		Node G=new Node(6,"G");
		
		listeNodes.add(A);
		listeNodes.add(B);
		listeNodes.add(C);
		listeNodes.add(D);
		listeNodes.add(E);
		listeNodes.add(F);
		listeNodes.add(G);
		//revoir les distances
		
		Edge edge1=new Edge (A,B,2);
		Edge edge2=new Edge (A,C,1);
		
		Edge edge3=new Edge (B,E,3);
		Edge edge4=new Edge (B,C,2);
		Edge edge5=new Edge (B,D,1);
		Edge edge6=new Edge (C,D,4);
		Edge edge7=new Edge (C,E,3);
		Edge edge8=new Edge (C,F,5);
		Edge edge9=new Edge (D,F,6);
		Edge edge10=new Edge (D,G,5);
		Edge edge11=new Edge (E,F,1);
		Edge edge12=new Edge (F,G,2);
		
		
		
		
		List <Edge> listeEdges=new ArrayList<Edge>();
		listeEdges.add(edge1);
		listeEdges.add(edge2);
		listeEdges.add(edge3);
		listeEdges.add(edge4);
		listeEdges.add(edge5);
		listeEdges.add(edge6);
		listeEdges.add(edge7);
		listeEdges.add(edge8);
		listeEdges.add(edge9);
		listeEdges.add(edge10);
		listeEdges.add(edge11);
		listeEdges.add(edge12);
		
		g.setEdges(listeEdges);
		g.setNodes(listeNodes);
	
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(A,G);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(A,G));
	
	}
}
