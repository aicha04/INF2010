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
   public class Position<Anytype>
   {
	   Position()
	   {
		   value=0;
		   found=false;
	   }
	   int value;
	   boolean found;
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
	   generator=new Random();
	   a=generator.nextInt(p); 
  		b=generator.nextInt(p);
      clear();
      
      if(array == null || array.size() == 0) return;

      n    = array.size();
      data = new QuadraticSpacePerfectHashing[n];
      for(int i=0;i<n;i++)
      {
    	  data[i]=new QuadraticSpacePerfectHashing();
      }
      
      if(n == 1)
      {
         data[0].setArray(array);
         return;
      }
      else
      {
    	 Position<AnyType>[] position=new Position[n];
    	  for(int i=0;i<array.size();i++)
    	  {
    		  position[i]=new Position();
    		position[i].value=findPos(array.get(i)); 
    	  }
    	  for(int i=0;i<n&& !(position[i].found);i++)
    	  {
    		  AnyType[] valeurs=(AnyType[])new Object[n];
    		 
    		  int nValeurs=0;
    		  for(int j=0;j<n;j++)
    		  {
    			  if(findPos(array.get(j))==position[i].value  )
    			  {
    				  valeurs[nValeurs]=array.get(j);
    				  position[i].found=true;
    				  nValeurs++;
    			  }
    		  }
    		  ArrayList <AnyType> tabValeurs=new ArrayList<AnyType>(nValeurs);
    		  for(int k=0;k<nValeurs;k++)
    		  {
    			  tabValeurs.add(valeurs[k]);
    		  }
    		  memorySize+=(nValeurs*nValeurs);
    		  data[position[i].value].setArray(tabValeurs);
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
      for(int i=0; i<n;i++) 
          if( data[i] != null )  
        	  sb.append(i+"->"+data[i].toString());
      return sb.toString();
            	       
   
    }
}
