package ADT;

import java.util.Random;

public class Simulation {
	 private static Random random;  

	 //Retourne un nombre reel aleatoire uniformement dans [0,1[
	    public static double uniform()
	    {
	    	 return Math.random();
	        
	    }

	 
	 //Retourne un nombre entier aleatoire uniformement dans [0,n[
	    public static int uniform(int n)
	    {
	    	if (n <= 0L)
	    		{
	    			throw new IllegalArgumentException("Argument doit etre positive: " + n);
	    		}
	       return ((int)(Math.random()*n));
	    }

	    
	//Retourne un entier long aleatoire uniformement dans [0, n[.
    // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n)
    {
        if (n <= 0L) throw new IllegalArgumentException("Argument doit etre positive: " + n);

        long r = random.nextLong();
        long m = n - 1;

        
        if ((n & m) == 0L) {
            return r & m;
        } 
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }
    
    //Retourne avec succ√®s un bool√©en true si p suit d'une distribution de Bernoulli
    public static boolean bernoulli(double p) 
    {
	    if(p <0 || p>= 1)
	    {
   			throw new IllegalArgumentException("L'argument doit etre positif et infÈrieur ‡ 1 " );
   		}
	    else if(p> 0.5 ) //si le nombre p est supÈrieur ‡ 0.5
	    {
		    return true;
	    }
	    else
	    {
		    return false; //si le nombre p est infÈrieur ‡ 0.5
	    }
		   
	}
    
   //Cette mÈthode retourne le maximum entre deux compteurs d'entiers
    public static Compteur max(Compteur x, Compteur y) 
    {
        Compteur max=x;
    	if(x.compareTo(y)>0)  
    		{
    		max=x;
    		}
    	else if(x.compareTo(y)<0)
    	{
    		max=y;
    	}
    	return max;
    	
   }
	
    public static void main(String[] args) 
    {
	    int n = 10;
	    Compteur pile = new Compteur("pile"); //on crÈÈ deux compteurs 
	    Compteur face = new Compteur("face");
	    double [] simulation =new double [n]; //un tableau o˚ on stocke le rÈsultat de chaque essai
	    
	      //Les instructions de la  simulation
	    for(int i=0;i<n;i++)
	    {
	    	simulation[i]=uniform();
	    	if(bernoulli(simulation[i]))
	    	{
	    		pile.increment();
	    	}
	    	else
	    	{
	    		face.increment();
	    	}
	    	
		}
		//afficher la diff√©rence entre les score des compteurs
		System.out.println("Score pile:" + pile.score() + "\n" + "Score face: " + face.score() );
		
		
		Compteur pile_c = new Compteur("pile");
		Compteur face_c = new Compteur("face");
		        
		      //Les instructions du simulation
		      //completer
		      //afficher le maximum entre les score des compteur
		for(int i=0;i<n;i++)
		{
			
			if(bernoulli(uniform()))
			{
				pile_c.increment();
			}
			else
			{
				face_c.increment();
			}
			
		}
		System.out.println("Score pile_c : " +pile_c.score() );
		System.out.println(""
			+ "Score face_c: " +face_c.score());
		System.out.println("Le maximun est:" + max(pile_c, face_c));


    }
    
        
 }



