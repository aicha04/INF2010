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
       // calcul de la position
	   int j= ((a*x.hashCode() + b)% p)% n;
	   if (j>=0&&j<n)
		   return j;
	   else return -1;
   }
   
   public boolean contains(AnyType x)
   {      
      // completer
	   int j=findPos(x);
	   return data[j].contains(x);
       
   }
      
   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();
      
      if(array == null || array.size() == 0) return;

      n    = array.size();
      data = new QuadraticSpacePerfectHashing[n];
      
      if(n == 1)
      {
          // Completer
    	  
    	  data[0]= new QuadraticSpacePerfectHashing<AnyType>(array);
    	  memorySize=1;
          return;
      }
      
      // A completer 
      a=generator.nextInt();
      b=generator.nextInt();
      for (int i=0; i<n; i++) {
    	  if ()
    	  data[findPos(array.get(i))]
      }
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
}
