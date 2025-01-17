package tp4;
import java.util.*; 
import java.lang.*;


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min )
    {
	this.min = min;
	currentSize = 0;
	array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min )
    {
		this.min = min;
		
		// COMPLETEZ
		// invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
		array=(AnyType[]) new Comparable[ items.length + 1];
		
		for (int i=0;i<items.length;i++) {
			array[i+1]=items[i];
		}
		currentSize=items.length;
	
		if (min) {
			buildMinHeap();
		}
		else {
			buildMaxHeap();
		}
    }
    
    public boolean offer( AnyType x )
    {
	if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	if( currentSize + 1 == array.length )
	    doubleArray();
	// COMPLETEZ
	if (min) {
		int i = ++currentSize;
		for( ; i > 1 && x.compareTo( array[ i / 2 ] ) < 0; i /= 2) {
			array[ i ] = array[ i / 2 ];
	
		}
		array[i]=x;
	}
	else {
		int i = ++currentSize;
		for( ; i > 1 && x.compareTo( array[ i / 2 ] ) > 0; i /= 2) {
			array[ i ] = array[ i / 2 ]; 
	
		}
		array[i]=x;
		if (min) {
			buildMinHeap();
		}
		else {
			buildMaxHeap();
		}
	}
		
	modifications++;
	
	return true;
    }
    
    public AnyType peek()
    {
	if(!isEmpty())
	    return array[1];
	
	return null;
    }
    
    public AnyType poll()
    {
    	
    	AnyType minMaxItem =  array[ 1 ];
	    swapReferences(1,currentSize-- );
		try {
	    	if(min)
	    	{
	    		percolateDownMinHeap( 1, currentSize );	
	    	}
	    	else
	    	{
	    		percolateDownMaxHeap( 1, currentSize );
	    	}
	    	modifications++;
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		
    	return minMaxItem;
    }
    
    public Iterator<AnyType> iterator()
    {
	return new HeapIterator();
    }
    
    private void buildMinHeap()
    {
		//COMPLETEZ
    	for( int i = currentSize / 2; i > 0; i-- ) 
    		percolateDownMinHeap( i,currentSize );

    }
    
    private void buildMaxHeap()
    {
	//COMPLETEZ
	for( int i = currentSize / 2; i > 0; i-- ) 
    		percolateDownMaxHeap( i,currentSize );
    }
    
    public boolean isEmpty()
    {
	return currentSize == 0;
    }
    
    public int size()
    {
	return currentSize;
    }
    
    public void clear()
    {
	currentSize = 0;
	modifications = 0;
	array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing )
    {
	return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 )
    {
	swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 )
    {
	AnyType tmp = array[ index1 ];
	array[ index1 ] = array[ index2 ];
	array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray()
    {
	AnyType [ ] newArray;
	
	newArray = (AnyType []) new Comparable[ array.length * 2 ];
	for( int i = 0; i < array.length; i++ )
	    newArray[ i ] = array[ i ];
	array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size )
    {
	percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
    	int child=0;
    	AnyType temp=array[hole];
    	if (heapIndexing) {
    		for (;hole*2<=size;hole=child) {
    			child=hole*2;
        		if (child!=size &&array[child+1].compareTo(array[child])<0) {
        			child++;
        		}
        		if (array[child].compareTo(temp)<0) {
        			array[hole]=array[child];
        		}
        		else {
        			break;}
        	
        	}array[hole]=temp;
    	}
    	else {
    		for (;hole*2<=size-1;hole=child) {
    			child=hole*2;
        		if (child!=size-1&&array[child+1].compareTo(array[child])<0) {
        			child++;
        		}
        		if (array[child].compareTo(temp)<0) {
        			array[hole]=array[child];
        			
        		}
        		else 
        			break;
        	}
    		array[hole]=temp;
    	}
    	
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size )
    {
	percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
    	//COMPLETEZ
    	int child=0;
    	AnyType temp=array[hole];
    	if (heapIndexing) {
    		for (;hole*2<size;hole=child) {
    			child=hole*2;
        		if (child!=size &&array[child+1].compareTo(array[child])>0) {
        			child++;
        		}
        		if (array[child].compareTo(temp)>0) {
        			array[hole]=array[child];
        		}
        		else {
        			break;}
        	
        	}array[hole]=temp;
    	}
    	else {
    		for (;hole*2<size-1;hole=child) {
    			child=hole*2;
        		if (child!=size-1&&array[child+1].compareTo(array[child])>0) {
        			child++;
        		}
        		if (array[child].compareTo(temp)>0) {
        			array[hole]=array[child];
        			
        		}
        		else 
        			break;
        	}
    		array[hole]=temp;
    	}
    	
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
    	/* buildHeap */
    	for( int i = (a.length / 2)-1; i >= 0; i-- )  
    		percolateDownMaxHeap( a, i, a.length,false);
    	
    	for( int i = a.length - 1; i > 0; i-- )
        {
            swapReferences( a, 0, i );            /* deleteMax */
            percolateDownMaxHeap( a, 0, i ,false);
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
    	/* buildHeap */
    	for( int i = (a.length / 2)-1; i >= 0; i-- )  
    		percolateDownMinHeap( a, i, a.length,false);
    	for( int i = a.length - 1; i > 0; i-- )
        {
            swapReferences( a, 0, i );            /* deleteMax */
            percolateDownMinHeap( a, 0, i ,false);
        }
	    }
	    
	    public String nonRecursivePrintFancyTree()
	    {
		String outputString = "";
		String prfix="|__";
		
		//COMPLETEZ 
		int hole = 1; 
		Stack<Integer> Temp = new Stack<Integer>(); 
		  
		Temp.push(hole);
		  
		while(!Temp.empty()){ 
		 
			hole = Temp.pop();
			Vector<Boolean> left = new Vector<Boolean>();
		  
			if(leftChild(hole, true) <= currentSize){
			  Temp.push(leftChild(hole, true) + 1); 
			  Temp.push(leftChild(hole, true));
			  
			}
			
			for (int i = hole; i > 0; i /= 2){
				
				if(i % 2 == 0)
					left.add(true);
				else
					left.add(false);
			}
	     
			for (int j = left.size() - 1; j > 0; j--){
				if(left.get(j))
					outputString += "|  ";
				else
					outputString += "   ";
			}
				  
			if (hole <= currentSize)
				outputString +=  "|__" + array[hole] + "\n";
		  
			else 
				outputString += "|__" + "null" + "\n";
	   }
		
		
		return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
	String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
		boolean isLeaf = index > currentSize/2;
		
		outputString += array[ index ] + "\n";
		
		String _prefix = prefix;
		
		if( index%2 == 0 )
		    _prefix += "|  "; // un | et trois espace
		else
		    _prefix += "   " ; // quatre espaces
		
		if( !isLeaf ) {
		    outputString += printFancyTree( 2*index, _prefix);
		    outputString += printFancyTree( 2*index + 1, _prefix);
		}
	    }
	else
	    outputString += "null\n";
	
	return outputString;
    }
    
    private class HeapIterator implements Iterator {
	
    	int current = 0; //position de l'element courant dans le tableau
        int modCount=modifications; //nbre de modifications en debut d'iterations
        public boolean hasNext( )
         {
             return current != size();
         }

        
   	public Object next() throws NoSuchElementException, 
   				    ConcurrentModificationException, 
   				    UnsupportedOperationException {
   		 if( hasNext() && modCount==modifications ) {
                return array[ ++current ];
                }
          else if( hasNext()&&modCount!=modifications ) {
                throw new ConcurrentModificationException();
          }
          else {
        	  throw new NoSuchElementException();
          }
       }
   	
   	public void remove() {
   	    throw new UnsupportedOperationException();
   	}
   }
}
