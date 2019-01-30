package ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
         this.nom=id;
    } 

   
    public void increment() {
        this.compteur++;
    } 

   
    public int score() {
         // retourne le rseultat d'un esemble d'essais
    	return compteur;
    } 

   
    public String toString() {
         return ("Le compteur "+ this.nom + " est � "+ this.compteur);
    } 
  
    public int compareTo(Compteur x)  //compare deux compteurs
    {            
    	if(this.compteur < x.compteur)
    	{
    		return -1;
    	
    	}
    	else if(this.compteur > x.compteur)
    	{
    		return 1;
    	}
    	else
    	{
    		return 0;
    	}
    	
    }
	  
    private static Random random=new Random(10000);
    
      //Retourne un nombre entier aléatoire uniformément dans [0,n[
	 public static int uniform(int n) 
	 {
	          return (int)(Math.random()*n);
	 }
	 
    public static void main(String[] args) 
    { 
        int n = 6;
        int essais = 60000;

        // Creation n compteurs
        Compteur [] tabCompteur=new Compteur[n];
        tabCompteur[0]=new Compteur("A");
        tabCompteur[1]=new Compteur("B");
        tabCompteur[2]=new Compteur("C");
        tabCompteur[3]=new Compteur("D");
        tabCompteur[4]=new Compteur("E");
        tabCompteur[5]=new Compteur("F");
       
 
         // incrémente les compteurs d'essais au hasard
        int [] valeurRandom= new int [60000];
        for(int i=0;i<essais; i++)
        {
        	valeurRandom[i]=uniform(5);
        	tabCompteur[valeurRandom[i]].increment();
        }

        // Affichage des resultats
        for(int i=0;i<5; i++)
        {
        	System.out.print(tabCompteur[i].toString() + "\n");
        
        }
    }
} 
