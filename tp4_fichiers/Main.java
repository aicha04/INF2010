package tp4;
import java.util.*; 


public class Main 
{
   /**
     * Fonction principale
     */
   public static void main(String[] args) 
   {
	   test();
	   /**
	    *Tests poll() and iterator
	    *@param: aucun
	    **/
	 /* 
      // creer un monceau avec 22 elements et un tableau equivalent
     int numItems = 22;
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
      
      Integer [ ] items = new Integer[ numItems ];

      int i;
      int j;

      // en inserant les elements un a un
      for( i = 11, j = 0; j != numItems; i = ( i + 37 ), j++ )
      {
	  heap.offer( i );
	  items[ j ] = i;

	  i %=  numItems; 
      }

      // en construisant le monceau depuis le depart
      System.out.println("Monceau min contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(false);
      // en inserant les elements un a un
      for( Integer item : items)
	  heap.offer( item );

      // en construisant le monceau depuis le depart
      System.out.println("Monceau max contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,false);
      System.out.println("Monceau max contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,true);
      System.out.println("Monceau min contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      System.out.println();
      System.out.println("Affichage recursif:");
      System.out.println( heap.printFancyTree() );

      System.out.println("Affichage non recursif:");
      System.out.println( heap.nonRecursivePrintFancyTree() );

      System.out.println();
      System.out.println("Tableau d'origine:");
      System.out.println( printArray( items ) );
      
      BinaryHeap.heapSort( items );
      System.out.println("Tableau ordonne:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSortReverse( items );
      System.out.println("Tableau inversement ordonne:");
      System.out.println( printArray( items ) );
   }*/

      /*
       * Ajouter appels pour repondre a la question
       */
   }
   private static <AnyType> 
   String printArray(AnyType[] a)
   {
      String outputString = "";

      for(AnyType item : a)
      {
         outputString += item;
         outputString += ", ";
      }

      return outputString.substring(0,outputString.length()-2);
      
   }
   public  static void test()
   {
	   // nouveau priority queue 
       PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
       pQueue.add(10); 
       pQueue.add(5); 
       pQueue.add(1); 
       pQueue.add(6); 

       System.out.println("Test avec la classe de java:");
       System.out.println("Test d'insertion(offer() et d'iteration(iterator()");
       // Printing all elements 
       System.out.println("Les elements sont:"); 
       Iterator<Integer> itr = pQueue.iterator(); 
       int i=0;
       while (itr.hasNext()) { 
           System.out.println("Element"+i+": "+itr.next());
           i++;
           }
       //supprimer le plus petit element
       System.out.println("Test de suppression du plus grand element ou du plus petit (poll())");
       System.out.println("L'element min est:" +pQueue.poll());
       System.out.println("Les elements sont désormais  sont:"); 
       
       Iterator<Integer> itr1=pQueue.iterator(); 
       int j=0;
       while (itr1.hasNext()) { 
    	   System.out.println("Element"+j+": "+itr1.next());
           j++;
           } 
       Iterator<Integer> itr2 = pQueue.iterator();
       while (itr2.hasNext()) {
    	  System.out.println(itr2.next());
    	}
       try {
	       System.out.println("Test de l'iterateur:");
	       int pos=0;
	       Iterator<Integer> itr3 = pQueue.iterator(); 
	       while (itr3.hasNext()) { 
	        	   System.out.println("Element"+pos+": "+itr3.next());
	               pos++;
	           pQueue.add(3);
	           System.out.println("Après une modification en cours d'iteration:");
	       }
       }
       catch(Exception e)
       {
    	   System.out.println("Impossible d'itérer puisqu'il y a une modification en cours d'itération");
       }
       
       /**
        * Test de notre classe BinaryHeap
        * */
    public static void  testHeap(boolean min)
       {
       System.out.println("\n");
       System.out.println("Test avec notre classe MinBinaryHeap:(offer() et iterator()");
       BinaryHeap<Integer> heap1 = new BinaryHeap<Integer>(min);
       heap1.offer(10); 
       heap1.offer(5); 
       heap1.offer(1); 
       heap1.offer(6);
       heap1.offer(8); 
       heap1.offer(9); 
       heap1.offer(11); 
       heap1.offer(5);
       int k=0;
       System.out.println("Les elements sont:");
       Iterator<Integer> it=heap1.iterator(); 
       while (it.hasNext()) { 
           System.out.println("Element"+k+": "+it.next());
           k++;
        }
       //supprimer le plus petit element
       System.out.println("Test de suppression du plus petit element (poll())");
       System.out.println("L'element min est:" +heap1.poll());
       System.out.println("Les elements sont désormais  sont:"); 
       Iterator<Integer> it1=heap1.iterator(); 
       int l=0;
       while (it1.hasNext()) { 
    	   System.out.println("Element"+l+": "+it1.next());
           l++;
           } 
       
       try {
	       System.out.println("Test de l'iterateur:");
	       int pos=0;
	       Iterator<Integer> it2 = heap1.iterator(); 
	       while (it2.hasNext()) { 
	        	   System.out.println("Element"+pos+": "+it2.next());
	               pos++;
	           heap1.offer(3);
	           System.out.println("Après une modification en cours d'iteration:");
	       }
       }
       catch(Exception e)
       {
    	   System.out.println("Impossible d'itérer puisqu'il y a une modification en cours d'itération");
       }
       }
   
   }
   
}
