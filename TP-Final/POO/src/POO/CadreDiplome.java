package POO;

public class CadreDiplome extends Article {
	private String categorie;
	private String couleur;
	
	//Constructeurs
	public CadreDiplome(String NumProduit, String nom, double prix, String couleur,String categorie)
	{
		super(NumProduit, nom, prix);
		this.couleur=couleur;
		this.categorie=categorie; 
	}
	
	public CadreDiplome(String NumProduit, String nom, double prix,String categorie)
	{
		super(NumProduit, nom, prix);
		this.categorie=categorie;
	}
	
	//m�thodes h�rit�es red�finies
	@Override
	public String getArticleType() 
	{
		return "Cadre Dipl�me"; 
	}
	
	//getters

	public String getCategorie()
	{
		return this.categorie;
	}

	public void setCategorie(String categorie) 
	{
             this.categorie=categorie;
    }
	
}
