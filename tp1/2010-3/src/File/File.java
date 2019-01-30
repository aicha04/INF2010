package File;


public class File <T> {

	private int theSize_; 
	private Node<T> begginMarker_; 
	private Node<T> endMarker_;

	// classe node
	private static class Node<T> { 
		public Node(T d, Node<T> p, Node<T> n) {
			item_ = d; prev_ = p; next_ = n; 
		}
		public T item_; 
		public Node<T>   prev_; 
		public Node<T>   next_;
	}
	//constucteur
	public File() {
		begginMarker_ = new Node<T>(null, null, null); 
		endMarker_ = new Node<T>(null, begginMarker_, null);
		begginMarker_.next_ = endMarker_;
	
		theSize_ = 0;
	}
	
	// methode pour rajouter un element au début de la file
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
	public boolean isEmpty( ) { 
		return size() == 0; 
	}
//la classe facilitant l'itération sur les éléments de la liste
	private class LinkedListIterator implements java.util.Iterator<T>
	{
		private Node <T> itemCourant=begginMarker_.next_;
		public boolean hasNext() //indique s'il existe un item après celui courant sur lequel pointe l'itérateur
		{
			return itemCourant !=endMarker_;
		}
		
		public T next() //retourne l'element suivant  ou le noeud courant 
		{
			if(hasNext())
			{
				T suivant=itemCourant.item_;
				itemCourant=itemCourant.next_;
				return suivant;
			}
			else
			{
				throw new java.util.NoSuchElementException(); //si l'element n'a pas de suivant et donc est le dernier
			}
		}
	}
}
