package ADT;

import java.util.Random;

public class Simulation {
	 private static Random random;  

	 //Retourne un nombre réel aléatoire uniformément dans [0,1[
	    public static double uniform() {
	    	 return Math.random();
	        
	    }

	 
	 //Retourne un nombre entier aléatoire uniformément dans [0,n[
	    public static int uniform(int n) {
	    	if (n <= 0L)
	    		{
	    			throw new IllegalArgumentException("Argument doit etre positive: " + n);
	    		}
	       return ((int)(Math.random()*n));
	    }

	//Retourne un entier long aléatoire uniformément dans [0, n[.
        // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n) {
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
    
    //Retourne avec succès un booléen true si p suit d'une distribution de Bernoulli
   /* public static boolean bernoulli(double p) {
       //completer
    }*/
    
    public static Compteur max(Compteur x, Compteur y) {
      Compteur max=x;
    	if(x.compareTo(y)==1)  
    		{
    		max=x;
    		}
    	else if(x.compareTo(y)== -1)
    	{
    		max=y;
    	}
    	return max;
    	
  }
	
	 public static void main(String[] args) {
        int n = 10;
        Compteur pile = new Compteur("pile");
        Compteur face = new Compteur("face");
        int [] simulation =new int [n];
          //Les instructions du simulation completers
        for(int i=0;i<n;i++)
        {
        	simulation[i]=uniform(2);
        	if(simulation[i]==1)
        	{
        		pile.increment();
        	}
        	else
        	{
        		face.increment();
        	}
        	
        }
          //afficher la différence entre les score des compteurs
        System.out.println("Score pile:" + pile.score() + "\n" + "Score face: " + face.score() );
        
        
       Compteur pile_c = new Compteur("pile");
		Compteur face_c = new Compteur("face");
		        
	          //Les instructions du simulation
                   //completer
                   //afficher le maximum entre les score des compteur
		  for(int i=0;i<n;i++)
	        {
	        	
	        	if(uniform(2)==1)
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



