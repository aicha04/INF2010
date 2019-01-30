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
	
	
	//Constructeur
	public Etudiant(String Matr,String nom, int section) {
        this.Matr=Matr;
        this.nom=nom;
        this.section=section;
        notes=new NoteCours[N];
        n_des_notes=0;
    }
        
         
	//methode d'ajout d'une nouvelle note dans le tableau des notes de l'utidiant
	public void AjouterNote(String sigle, String titre, int note){ 
		if(this.n_des_notes< N)
		{
			// creer une nouvelle note
			notes[n_des_notes] = new NoteCours();
			// assigner la note le sigle et le titre 
			notes[n_des_notes].note=note;
			notes[n_des_notes].sigle=sigle;
			notes[n_des_notes].titre=titre;
			n_des_notes++;
		}
	}
	
	// calcule de la moyenne de l'etudiant
	public double NoteMoyenne(){
		int somme=0;
		for(int i=0;i<n_des_notes;i++) {
			somme+=notes[i].note;
		}
		double moyenne = (double)somme/ (double) n_des_notes;
		return moyenne;
	}

	
	public String getMatr() {
		return Matr;
	}

	public void setMatr(String matr) {
		this.Matr=matr;
	}

        public String getEmail() {
                   return this.email;
	}

	public void setEmail(String email) {
                      this.email=email;
	}

	public String getNom() {
		return nom;
	}
    
	
	public void setNom(String nom) {
		this.nom=nom;
	}

	public String getPrenom() {
		return this.prenom;	}

	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	
	public int getSection() {
		return this.section;
	}
	
	
    public String toString() {
    	return ("Nom de l'etudiant: " + this.nom +", "+ "Matricule: "
    			+this.Matr +", "+ "Section:" +this.getSection() );
    }
    
    public boolean equals(Object etudiant_x) {
    	Etudiant etudiantRecu=(Etudiant) etudiant_x;
    	return (this.nom.equals(etudiantRecu.getNom()) && this.Matr.equals(etudiantRecu.getMatr()));
    }
           
    
   

}
