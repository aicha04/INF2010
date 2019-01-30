package File;

import java.util.Iterator;

public class File <T> implements Iterable <T> {

	private int theSize_; 
	private Node<T> begginMarker_; 
	private Node<T> endMarker_;

	private static class Node<T> { 
		public Node(T d, Node<T> p, Node<T> n) {
		item_ = d; prev_ = p; next_ = n; }
		public T item_; 
		public Node<T>   prev_; 
		public Node<T>   next_;
	}
	public File() {
		begginMarker_ = new Node<T>(null, null, null); 
		endMarker_ = new Node<T>(null, begginMarker_, null);
		begginMarker_.next_ = endMarker_;
	
		theSize_ = 0;
	}
	
	public void emfiler (T data) {
		Node<T> newNode = new Node<T>(data, begginMarker_, begginMarker_.next_);
		begginMarker_.next_.prev_=newNode;
		begginMarker_.next_= newNode;
		theSize_++;
	}
	public T defiler () {
		
		T elementADefiler=endMarker_.prev_.item_;
		if (theSize_!=0) {
			endMarker_.prev_.prev_.next_=endMarker_;
			endMarker_.prev_=endMarker_.prev_.prev_;
			theSize_--;
		}
		return elementADefiler;
	
		}
	public T getElementDeFin() {
		return endMarker_.prev_.item_;
	}
	
	public int size( ) { return theSize_; }
	public boolean isEmpty( ) { return size() == 0; }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
