package POO;

 public abstract class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;


        public Article(String NumProduit, String nom){
                   this.NumProduit=NumProduit;
                   this.nom=nom;
           
	}
	
	public Article(String np, String nom, double prix){		
		  this.NumProduit=np;
          this.nom=nom;
          this.Prix_net=prix;
  
		
	}
	///Commentaires !!!
	public String getNumProduit() {
		return NumProduit;
	}	
	public String getNom() {
		return  nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public double getPrixNet() {
		return this.Prix_net;}
		
		
	public void setPrixNet(double prix_net) {
		Prix_net=prix_net;
	}
	public double getPrix(int count)
	{
		return Prix_net; //Pas compris
	}

	//public abstract  double getVAT();
	
	public abstract String getArticleType();

}
