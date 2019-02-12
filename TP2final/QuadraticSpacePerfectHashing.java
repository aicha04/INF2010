/****************************************************
* TP2: Hachage										*
* Classe de hashage quadratique						*
* Auteures: Aicha miloudi et Gloria Sohou			*
* matricules: 1872134 1832523						*
* Date: 11 fevrier 2019								*
*****************************************************/
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

    private int findPos(AnyType x) // retourne la position d'un élément x donné
    {  
    	int position=(((x.hashCode()*a)+b)%p)% m;
    	// si la position se trouve entre m et 0 retourner la position
    	if (position >=0 && position<m) {
    		return position;
    	}
    	//sinon retourner -1 (erreur)
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
	    //générateur de nombres aléatoires
	    generator=new Random(); 
	  
	    a=generator.nextInt(p); 
	 
	    b=generator.nextInt(p);
	  
	  
	    //creer un nouveau tableau d'items
		items = (AnyType[]) new Object[m];
		//pour chaque element de array
		for (int i=0;i < array.size() ; i++)
		{
			// trouver la position de l'ement 
			AnyType x=array.get(i);
			int position=findPos(x);
			// si l'element existe deja retourner vrai 
			if(contains(x))
			{
			  return true;	 	  
			 
			}
		  
			//sinon ajouter l'element au tableau items
		    	else
		    	{
		    		items[position]=x;
		    	}
		}
		return false;
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
