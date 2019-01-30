package POO;

import java.util.Comparator;

public class Etudiant {
	final int N = 10;
	private String Matr;
	private String nom;
	private String prenom;	
	private String email; 
	private int section; 
	
    private int n_des_notes;
	private NoteCours [] notes;
	
	//constructeurs
	 public Etudiant(String Matr,String nom, int section) {
             this.Matr=Matr;
             this.nom=nom;
             this.section=section;
             notes=new NoteCours[N];
             n_des_notes=0;
	    }
        
         
	
	public void AjouterNote(String sigle, String titre, int note){ 
		if(this.n_des_notes< N) //vérifier si la taille permet un ajout
		{
			notes[n_des_notes] = new NoteCours(); //note de cours à ajouter
			notes[n_des_notes].note=note;
			notes[n_des_notes].sigle=sigle;
			notes[n_des_notes].titre=titre;
			n_des_notes++;
		}
	}
	
	//calcul de la moyenne
	public double NoteMoyenne(){
		int somme=0;
		for(int i=0;i<n_des_notes;i++)
		{
			somme+=notes[i].note;
		}
		double moyenne = (double)somme/ (double) n_des_notes;
		return moyenne;
	}

	//getter matricule
	public String getMatr() {
		return Matr;
	}

	//setter matricule
	public void setMatr(String matr) {
		this.Matr=matr;
	}

	//getter email
      public String getEmail() {
                   return this.email;
	}

      //setter email
	public void setEmail(String email) {
                      this.email=email;
	}

	//getter nom
	public String getNom() {
		return nom;
	}
    
	//setter nom
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	
	//getter et setter prenom et section
	public String getPrenom() {
		return this.prenom;	}

	public void setPrenom(String prenom) {
	this.prenom=prenom;
	}
	
	public int getSection() {
		return this.section;
		}
	
	//informations sur l'etudiant
    public String toString() {
    	return ("Nom de l'etudiant: " + this.nom +", "+ "Matricule: "+this.Matr +", "+ "Section:" +this.getSection() );
    }
    
    //vérifier l'égalité ente l' étudiant courant et un autre
    public boolean equals(Object etudiant_x) {
    	Etudiant etudiantRecu=(Etudiant) etudiant_x;
    	return (this.nom.equals(etudiantRecu.getNom()) && this.Matr.equals(etudiantRecu.getMatr()));
    }
           
    
   

}
