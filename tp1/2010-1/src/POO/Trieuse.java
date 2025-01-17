package POO;


import java.util.Arrays;
import java.util.Comparator;


public class Trieuse {
   
    public static final Comparator<Etudiant> Par_nom    = new NomOrdre();
    public static final Comparator<Etudiant> Par_section = new SectionOrdre();


    private static class NomOrdre implements Comparator<Etudiant> {
        public int compare(Etudiant x, Etudiant y) {
        	return (x.getNom().compareToIgnoreCase(y.getNom()));
        }
    }


    private static class SectionOrdre implements Comparator<Etudiant> {
        public int compare(Etudiant x, Etudiant y) {
             if( x.getSection()<y.getSection()) {
            	 return -1;
             }
             else if(x.getSection() < y.getSection()) {
                 return 1; 
             }
             else {
            	 return 0;
             }
        }
    }

                
    // methode de tri  ParNom et ParSection
    public static void trierParNom(Etudiant [] etudiants) {
    	Arrays.sort(etudiants, Par_nom);
    }
    
    public static void trierParSection(Etudiant [] etudiants) {
    	Arrays.sort(etudiants, Par_section);
	}
    
    //methode d'affichage
    public static  void afficher (Etudiant [] etudiants) {
		for(int i=0;i< etudiants.length; i++) {
		System.out.println(etudiants[i].toString());
		}
    
    }
    
   
    public static void main(String[] args) {

       
        Etudiant e = new Etudiant("1897453","John",3);
        e.AjouterNote("INF2010", "Structures de données et algorithmes", 4);		
        e.AjouterNote("LOG2810", "Structures discrètes", 5);
        e.AjouterNote("INF2610", "Noyau d'un système d'exploitation", 3);
	    System.out.println(e.NoteMoyenne());

        Etudiant john     = new Etudiant("1797453","john",  2);
        Etudiant Caroline = new Etudiant("1897053","Caroline",    1);
        Etudiant Antoine  = new Etudiant("1297453","Antoine",  2);
        Etudiant Karl     = new Etudiant("1797433","Karl",   1);
        Etudiant Ahmed    = new Etudiant("1897453","Ahmed",    2);
        Etudiant Sam      = new Etudiant("1977411","Sam",  3);
        Etudiant[] etudiants = {
            john, Caroline, Karl, Ahmed, Sam};

        // trier par nom et afficher le tableau d'etudiants
        System.out.println("Par le nom ");
        System.out.println("----------");
       	trierParNom(etudiants);
        afficher(etudiants);
        System.out.println("----------");
        
     // trier par section et afficher le tableau d'etudiants
        System.out.println("Par section");
        System.out.println("----------");    
        Arrays.sort(etudiants,Par_section);
        afficher(etudiants);
        Etudiant carlos = new Etudiant("1698853","carlos", 3);
        Etudiant Ines = new Etudiant("1897456","Ines", 2);
        System.out.println("----------"); 

        System.out.println("carlos == Ines:        " + (carlos == Ines));
        System.out.println("carlos.equals(Ines):   " + (carlos.equals(Ines)));

       

    }

}

