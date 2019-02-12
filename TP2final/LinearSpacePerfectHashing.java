/****************************************************
* TP2: Hachage										*
* Classe de hashage lineaire						*
* Auteures: Aicha miloudi et Gloria Sohou			*
* matricules: 1872134 1832523						*
* Date: 11 fevrier 2019								*
*****************************************************/

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
   public static int uniform(int n)
   {
   	if (n <= 0L)
   		{
   			throw new IllegalArgumentException("Argument doit etre positive: " + n);
   		}
      return ((int)(Math.random()*n));
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
	   
	   // j = mod(mod(ax + b; p); n)
       int position=((a*x.hashCode()+b)%p)%n;
       // si la postion est entre n et 0 retourner la position 
       if(position>=0 && position<n)
       {
    	   return position;
       }
       //sinon retourner -1 (erreur)
       else
       {
    	   return -1;
       }
   }
   
   public boolean contains(AnyType x)
   {    //trouver la position de x 
	    int position=findPos(x);
	    // retourne vrai si il existe déjà sinon faux
	    return (data[position].contains(x));
   }
      
   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
	   clear();
	   a=uniform(p); 
	   b=uniform(p);
   
       // si array est vide 
	   if(array == null || array.size() == 0) return;

	   //allouer un tableau de n QuadraticSpacePerfectHashing
	   n    = array.size();
	   data = new QuadraticSpacePerfectHashing[n];
	   for(int i=0;i<n;i++)
	   {
		   data[i]=new QuadraticSpacePerfectHashing<AnyType>();
	   }
      
	   // si la taille de array est eguale a 1 
	   if(n == 1)
	   {
		   //mettre cette élément dans data
		   data[0].setArray(array);
		   return;
	   }
	   // si array a plus d'un élément
	   else
	   {
		   //creer un tableau pour contenir les position des element
		   int[] position=new int [n];
		   //pour chaque element de array
		   for(int i=0;i<array.size();i++) {
    	  
			   //trouver sa position et le mettre dans le tableau de positions
			   position[i]=findPos(array.get(i)); 
		   }
		   
		   //pour chaque position
		   for(int i=0;i<n;i++)
		   {
			   //si l'element n'existe pas deja dans data
			   if (!contains(array.get(i))) {
				   //creer un tableau pour contenir les element en collisions
				   AnyType[] valeurs=(AnyType[])new Object[n];
    		 
				   int nValeurs=0;
			   
				   //pour chaque elements de array
				   for(int j=0;j<n;j++)
				   {
					   //si un element et en collison avec l'element a la position i
					   if(findPos(array.get(j))==position[i])
					   {
						   //mettre cette element dans le tableau des element en collisions 
						   //et incrementer le compteur d'elements en collision 
						   valeurs[nValeurs]=array.get(j);
						   nValeurs++;
					   }
				   }
				   //crer et remplir une liste des elements en collisions 
				   ArrayList <AnyType> tabValeurs=new ArrayList<AnyType>(nValeurs);
				   for(int k=0;k<nValeurs;k++)
				   {
					   tabValeurs.add(valeurs[k]);
				   }
				   //calculer la taille de la memoire 
				   memorySize+=(nValeurs*nValeurs);
				   //ajouter la liste d'element dans data a la postion i 
				   data[position[i]].setArray(tabValeurs);
			   }
		   }
    	  
	   }
   }
      
  
   
   public int memorySize() 
   {
      return memorySize;
   }
   
   public String toString(){
	   	StringBuilder sb = new StringBuilder();
      
	   	if(n == 0) 
	   		return "";
	   	//pour tout les elements de data 
	   	for(int i=0;i<n;i++)
       	{
	   		sb.append(i + "->" + data[i].toString()+ "\n");
            
       	}
	   	return sb.toString();
   }
  
 
}
