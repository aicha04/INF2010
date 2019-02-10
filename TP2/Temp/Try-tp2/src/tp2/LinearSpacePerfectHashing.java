package tp2;

import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
   static int p = 46337;
   
   int a, b, n, memorySize;
   QuadraticSpacePerfectHashing<AnyType>[] data;
   Random generator;
   
   LinearSpacePerfectHashing()
   {
      clear();
   }
   
   LinearSpacePerfectHashing(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }
   
   public void setArray(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }
   
   public int size()
   {
      return n;
   }

   public void clear()
   {
      generator = new Random( System.nanoTime() );
      a = b = n = memorySize = 0; 
      data = null;
   }

   private int findPos(AnyType x)
   {
      // completer j = mod(mod(ax + b; p); n)
       int position=(((a*x.hashCode()+b)%p)%n);
       if(position>=0 && position<n)
       {
    	   return position;
       }
       else
       {
    	   return -1;
       }
   }
   
   public boolean contains(AnyType x)
   {    
	    int position=findPos(x);
	    return (data[position].contains(x));
   }
      
   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
	   a=generator.nextInt(p); 
  		b=generator.nextInt(p);
      clear();
      
      if(array == null || array.size() == 0) return;

      n    = array.size();
      data = new QuadraticSpacePerfectHashing[n];
      
      if(n == 1)
      {
         data[0].setArray(array);
         return;
      }
      else
      {
    	  int[] position=new int[n];
    	  for(int i=0;i<array.size();i++)
    	  {
    		position[i]=findPos(array.get(i)); 
    	  }
    	  for(int i=0;i<n;i++)
    	  {
    		  ArrayList <AnyType> tabValeurs=new ArrayList<AnyType>(n);
    		  int nValeurs=0;
    		  for(int j=0;j<n;j++)
    		  {
    			  if(position[i]==findPos(array.get(i)))
    			  {
    				  tabValeurs.add(array.get(i));
    				  nValeurs++;
    			  }
    		  }
    		  data[position[i]].setArray(tabValeurs);
    	  }
    	  
      }
      
      // A completer
   }
   
   public int memorySize() 
   {
      return memorySize;
   }
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
      
      // completer
      
      return sb.toString();
   }
   public boolean foundElement(AnyType[] array, AnyType x )
   {
	   boolean resultat=false;
	   for(int i=0;i< array.length; i++)
	   {
		   if( array[i].equals(x))
		   {
			   resultat=true;
		   }
		 
	   }
     return resultat;
   }
}
