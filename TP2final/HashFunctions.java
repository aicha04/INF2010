/************************************************************
* TP2: Hachage												*
* classe HashFunctions pour tester les fonctions de hashage	*
* Auteures: Aicha miloudi et Gloria Sohou					*
* matricules: 1872134 1832523								*
* Date: 11 fevrier 2019										*
*************************************************************/

package tp2;

import java.util.ArrayList;
import java.util.Random;

public class HashFunctions 
{   
   public static void main(String[] args) 
   {
      // Donnees brutes
      Integer[] array = { 100, 75,  64,  25,  36, 101,  11,  92,  
            200, 175, 164, 125, 136, 201, 111, 192,
            300, 275, 264, 225, 236, 301, 311, 292};

      // Les donnees sont inserees dans un ArrayList
      ArrayList<Integer> al = new ArrayList<Integer>(array.length);

      for(Integer item : array) al.add( item );

      /**
       * Questions 1.1.1
       */
      // On cree un QuadraticSpacePerfectHashing et insere les donnees
      System.out.println( "QuadraticSpacePerfectHashing:");
      System.out.println();

      QuadraticSpacePerfectHashing<Integer> e = new QuadraticSpacePerfectHashing<Integer>( al ); 

      // Verifie les proprietes d'occupation d'espace
      System.out.println( "Number of elements: " + e.size() );
      System.out.println( "Memory size: " + e.memorySize() );
      System.out.println();

      // Verifie qu'il fonctionne comme prevu
      System.out.println( 100 + " est present: " + e.contains(100) );
      System.out.println(  99 + " est present: " + e.contains( 99) );
      System.out.println( 200 + " est present: " + e.contains(200) );
      System.out.println( 199 + " est present: " + e.contains(199) );
      System.out.println( 300 + " est present: " + e.contains(300) );
      System.out.println( 299 + " est present: " + e.contains(299) );
      System.out.println();
      

      // Affichage de pfhash
      System.out.println(e);

      /**
       * Questions 1.2.1
       */
      // On cree un LinearSpacePerfectHashing et insere les memes donnees
      System.out.println();
      System.out.println( "LinearSpacePerfectHashing:");
      System.out.println();

      LinearSpacePerfectHashing<Integer> pfhash = new LinearSpacePerfectHashing<Integer>( al );

      // Verifie les proprietes d'occupation d'espace
      System.out.println( "Number of elements: " + pfhash.size() );
      System.out.println( "Memory size: " + pfhash.memorySize() );
      System.out.println();

      // Verifie qu'il fonctionne comme prevu
      System.out.println( 100 + " est present: " + pfhash.contains(100) );
      System.out.println(  99 + " est present: " + pfhash.contains( 99) );
      System.out.println( 200 + " est present: " + pfhash.contains(200) );
      System.out.println( 199 + " est present: " + pfhash.contains(199) );
      System.out.println( 300 + " est present: " + pfhash.contains(300) );
      System.out.println( 299 + " est present: " + pfhash.contains(299) );
      System.out.println();
      
      // Affichage de pfhash
      System.out.println(pfhash);

      /**
       * Question 1.3.1 (confirmation des resultats ) 
       */
      // Effectue des tests aleatoires pour verifier les proprietes de taille
      pfhash = new LinearSpacePerfectHashing<Integer>();
      System.out.println("Tests aleatoires");
      System.out.println();

      for(int i=0, nbElements = 10; i<40; ++i, nbElements += 10)
      {
         pfhash.setArray( randomIntegers( nbElements ) );			
         System.out.println( nbElements + "\t" + pfhash.memorySize() );
      }
   }

   /**
    * Question 1.3.1
    */
   
   public static ArrayList<Integer> randomIntegers(int length)
   {
	  
      Random generator = new Random( System.nanoTime() );
      
      ArrayList<Integer> al = new ArrayList<Integer>(length);
      int nIntegers=0;
      // thant que la liste n'est pas compl�te
      while(nIntegers < length)
      {
    	  
    	  boolean isPresent=false;
    	  //generer un entier al�atoirements
    	  int integer=generator.nextInt(46337);
    	  // pour tout les element d�ja contenue dans la liste
    	  for(int i=0;i<al.size();i++)
    	  {
    		  //verifier si l'entier g�n�r� existe deja
    		  if(al.get(i) !=null && al.get(i).equals(integer))
    		  {
    			  isPresent=true;
    		  }
    	  }
    	  // si l'entier est unique
    	  if(!isPresent)
    	  {
    		  //ajouter l'entier � la liste et incr�menter le nombre d'entier total
    		  al.add(integer);
    		  nIntegers++;
    	  }
      }
      return al;
   }
}


