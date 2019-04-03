package tp4;
import java.util.*; 


public class Main 
{
   /**
     * Fonction principale
     */
   public static void main(String[] args) 
   {
	
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
      
      /**
	    *Tests poll() and iterator
	    *@param: aucun
	    **/
	   testProrityQueueJava();
	   System.out.println("\n" + "Binary MinHeap");
	   testBinaryHeap(true, "min ");
	   System.out.println("\n"+"Binary Max Heap");
	   testBinaryHeap(false,"max ");
	   
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
   
   /***
    ** Tester les methodes offer , poll et iterator() 
    *sur la classe Priority Queue de Java
    *On fera les même operations dans le testBinaryHeap pour
    *determiner la concordance
    */
   public  static void testProrityQueueJava()
   {
	   // nouveau priority queue 
       PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
       pQueue.offer(10); 
       pQueue.offer(5); 
       pQueue.offer(1); 
       pQueue.offer(6); 
       pQueue.offer(8); 
       pQueue.offer(9); 
       pQueue.offer(11); 


       System.out.println("\n" +"Test avec la classe de java:");
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
       try {
    	   
	       System.out.println("Test de l'iterateur:");
	       System.out.println("Les elements sont:");
	       int pos=0;
	       Iterator<Integer> itr3 = pQueue.iterator(); 
	       while (itr3.hasNext()) { 
	        	   System.out.println("Element"+pos+": "+itr3.next());
	               pos++;
	           pQueue.add(3); //modification en cours d'iteration
	           System.out.println("Après une modification en cours d'iteration:");
	       }
       }
       catch(Exception e)
       {
    	   System.out.println("Impossible d'itérer puisqu'il y a une modification en cours d'itération");
       }
   }   
       /**
        * Test de notre classe BinaryHeap
        * On insere des elements un par un. On supprime le root(Pooll())
        * On utilise l'iterator() une première fois pour afficher tous les elements
        * On reutilise un autre iterateur pour afficher les elements
        * Cette fois on ecupère l'exception générée puis on affiche un message d'erreur
        * Ceci evite de laisser propager l'exception qui pourrait  arreter l'exécution 
        * du code
        * */
    public static void  testBinaryHeap(boolean min, String buffer)
 {
  
       System.out.println("Test avec notre classe BinaryHeap:(offer() et iterator()");
       BinaryHeap<Integer> heap1 = new BinaryHeap<Integer>(min);
       heap1.offer(10); 
       heap1.offer(5); 
       heap1.offer(1); 
       heap1.offer(6);
       heap1.offer(8); 
       heap1.offer(9); 
       heap1.offer(11); 
       int k=0;
       System.out.println("Les elements sont:");
       Iterator<Integer> it=heap1.iterator(); 
       while (it.hasNext()) { 
           System.out.println("Element"+k+": "+it.next());
           k++;
        }
       //supprimer le plus petit element
       System.out.println("Test de suppression du plus petit/grand element (poll())");
       System.out.println("L'element "+ buffer+ "est:" +heap1.poll());
       System.out.println("Les elements sont désormais  sont:"); 
       Iterator<Integer> it1=heap1.iterator(); 
       int l=0;
       while (it1.hasNext()) { 
    	   System.out.println("Element"+l+": "+it1.next());
           l++;
           } 
       
       try {
	       System.out.println("Test de l'iterateur:");
	       System.out.println("Les elements sont:");
	       int pos=0;
	       Iterator<Integer> it2 = heap1.iterator(); 
	       while (it2.hasNext()) { 
	        	   System.out.println("Element"+pos+": "+it2.next());
	               pos++;
	           heap1.offer(3); //modification en cours d'iteration !
	           System.out.println("Après une modification en cours d'iteration:");
	       }
       }
       catch(Exception e)
       {
    	   System.out.println("Impossible d'itérer puisqu'il y a une modification en cours d'itération");
       }
     }
   
   }
   

