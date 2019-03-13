package tp3;
import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
    	this.data=data;
    	right = null;
    	left = null;

    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
    	
    	if (data.compareTo(item)>0) {
    		if (left == null) {
    			left = new BinaryNode<T>(item);
    		}
    		else {
    			left.insert(item);
    		}
    		
    	}
    	else {
    		if (right == null) {
    			right = new BinaryNode<T>(item);
    		}
    		else {
    			right.insert(item);
    		}
    	}

    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
		if(data.compareTo(item) >0)
	    {
			if( left!= null &&left.contains(item))
			{
				return true ;
			}
	    }
		else if(right !=null&& data.compareTo(item) <0 &&right.contains(item))
	    {
			return true ;
		}
		else
		{
			return true;
		}
    return false;
}
   
    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
    	int heightLeft =0;
		int heightRigth=0;
    	if (this !=null) 
    	{
    		if (this.left !=null) {
	    		 heightLeft =1 +left.getHeight();
    		}
    		if (this.right !=null) {
	    		 heightRigth=1+right.getHeight(); 
    		}

    		if(heightRigth> heightLeft)
    		{
    			return heightRigth;
    		}
    		else
    		{
    			return heightLeft;
    		}
	    }
   return -1; 
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {

	if( this !=null)
	{
       	if (left!=null) {
       		left.fillListInOrder(result);
       	}
   		result.add(this);
   		if (right!=null) {
   			right.fillListInOrder(result);
   		}
    }
   }
}
      	
  

//aquisition est un arbre binaire, arbre de compagnie enfant n'est pas binaire  



