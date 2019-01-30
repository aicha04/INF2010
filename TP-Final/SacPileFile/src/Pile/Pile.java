package Pile;

import java.util.Iterator;

public class Pile<T> implements Iterable <T>  {
	private int theSize_; 
	private Node<T> topMarker_; 
	private Node<T> endMarker_;

	private static class Node<T> { 
		public Node(T d, Node<T> p, Node<T> n) {
		item_ = d; prev_ = p; next_ = n; }
		public T item_; 
		public Node<T>   prev_; 
		public Node<T>   next_;
	}
	public Pile() {
		topMarker_ = new Node<T>(null, null, null); 
		endMarker_ = new Node<T>(null, topMarker_, null);
		topMarker_.next_ = endMarker_;
	
		theSize_ = 0;
	}
	
	public void empiler (T data) {
		Node<T> newNode = new Node<T>(data, topMarker_, topMarker_.next_);
		topMarker_.next_.prev_=newNode;
		topMarker_.next_= newNode;
		theSize_++;
	}
	public T depiler () {
		
		T elementADepiler=topMarker_.next_.item_;
		if (theSize_!=0) {
		topMarker_.next_=topMarker_.next_.next_;
		topMarker_.next_.next_.prev_=topMarker_;
		theSize_--;
		}
		return elementADepiler;
	
		}
	public T getElementTete() {
		return topMarker_.next_.item_;
	}
	
	public int size( ) { return theSize_; }
	public boolean isEmpty( ) { return size() == 0; }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
	
	
	
	
	
		



	