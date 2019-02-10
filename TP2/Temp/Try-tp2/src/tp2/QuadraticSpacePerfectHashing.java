package tp2;

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
   static int p = 46337;

   int a, b, m, n;
   AnyType[] items;
   Random generator;

   QuadraticSpacePerfectHashing()
   {
      clear();
   }

   QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
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
      a = b = m = n = 0; 
      items = null;
   }

   private int findPos(AnyType x) // retourne la position d'un �l�ment x donn�
   {  
	   int position=(((x.hashCode()*a)+b)%p)% m;
	   if (position >=0 && position<m) {
		   return position;
	   }
	   else {
		   return -1;
	   }
   }

   public boolean contains(AnyType x )
   {
      if( n == 0 ) return false; 
     
      int index = findPos(x);

      return ( ( items[index] != null ) && ( items[index].equals(x) ) );
   }

   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();

      if(array == null || array.size() == 0) return;

      n = array.size();
      m = n*n;

      if(n == 1)
      {
         items = (AnyType[]) new Object[m];
         items[0]	= array.get(0);
         return;
      }

      while( unsuccessfulMemoryAllocation( array ) );
   }

   @SuppressWarnings("unchecked")
   private boolean unsuccessfulMemoryAllocation(ArrayList<AnyType> array)
   {
	  generator=new Random(); //g�n�rateur de nombres al�atoires
	  
	  a=generator.nextInt(p); 
	 
	  b=generator.nextInt(p);
	  boolean sucess=false;
	  items = (AnyType[]) new Object[m];
      for (int i=0;i < array.size() ; i++)
      {
    	  AnyType x=array.get(i);
    	  int position=findPos(x);
    	  if(contains(x))
    	  {
    		  sucess=true;	 	  
    	  }
    	  else
		  {
		  	items[position]=x;
		  }
      }
     return sucess;
   }
   
   public int memorySize() 
   {
      return m;
   }
   
   public String toString(){
      if(n == 0) 
         return "";
      
      StringBuilder sb = new StringBuilder();
      
      for(AnyType item : items) 
         if( item != null ) 
            sb.append(item + ", ");
      
      return sb.toString();
   }
}
