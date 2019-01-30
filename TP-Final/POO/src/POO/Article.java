package POO;

 public abstract class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;

	//constructeurs 
    public Article(String NumProduit, String nom){
                   this.NumProduit=NumProduit;
                   this.nom=nom;
           
	}
	
	public Article(String np, String nom, double prix){		
		  this.NumProduit=np;
          this.nom=nom;
          this.Prix_net=prix;
  
		
	}
	//retourne le numéro du produit
	public String getNumProduit() {
		return NumProduit;
	}	
	//retourner le nom du produit
	public String getNom() {
		return  nom;
	}
	
	//modifier le nom du prduit
	public void setNom(String nom) {
		this.nom=nom;
	}
	//retourner le prix du produit
	public double getPrixNet() {
		return this.Prix_net;}
		
	//modifier  le prix du produit
	public void setPrixNet(double prix_net) {
		Prix_net=prix_net;
	}
	
	public double getPrix(int count)
	{
		return Prix_net; 
	}

	//public abstract  double getVAT();
	
	public abstract String getArticleType();
}
