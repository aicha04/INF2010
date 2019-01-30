package Sac;

public class Sac1 <T> implements Iterable<T> {
	private int taille; //taille du sac
	private Noeud <T> debut; //noeud representant le premier element du sac
	private Noeud <T> fin;  //noeud representant le dernier element du sac
	 
	public int taille() //getter taile su sac
	{
		return taille;
	}
	
	public boolean estVide() //retourne vrai si le sac est vide
	{
		return (taille==0);
	}
	
	public Noeud<T> getNode (int position)           //retourne le noeud � la position indiqu�e
	{
		Noeud <T> noeudCherche= debut.itemSuivant; //on se positionne au d�but de la liste
		if( position >0 && position< taille)      // la position doit �tre  positive et inf�rieure � la taille
			
			if(position< (taille/2))          //si l'element se trouve dans la deuxi�me moiti� dans 
			{                                  //la liste ,on commene la recherce par la fin
				for( int i=0;i <position; i++)
				{
					noeudCherche=noeudCherche.itemSuivant;
				}
			}
			else                                 //si l'element se trouve dans la premi�re moiti� dans
			{                                       //la liste ,on commene la recherche par le d�but
				for( int i=position; i> taille; i--)
				{
					noeudCherche=noeudCherche.itemPrecedent;
				}
			}
		else
		{
			throw new IndexOutOfBoundsException(); //si le param�tre index donn� n'est pas pris en compte
		}
		
		return noeudCherche;
		
	}
	public void ajouterItem(Noeud <T> noeudAvant, T itemAajouter)  //jouter un item dans la liste 
	{
		Noeud <T> noeudAajouter=new Noeud <T> (itemAajouter , noeudAvant.itemPrecedent, noeudAvant); //on cr�� un noeuveau noeud
		
		noeudAajouter.itemPrecedent.itemSuivant=noeudAajouter; 
		
		noeudAvant.itemPrecedent=noeudAajouter; //le noeud suivant celui  pr�c�dant le noeudAvant devient  nouvel item
		taille++;
	}
	
	
	private static class Noeud<T> //la classe statique comportant les donn�esd'un noeud
	{
		
		public Noeud( T item, Noeud<T> precedent, Noeud<T> suivant)
		{
			itemSuivant=suivant; 
			itemPrecedent=precedent;
			this.item=item;
		}
		public T item;
		public Noeud<T> itemPrecedent;
		public Noeud <T> itemSuivant;
		
	}
	private class LinkedListIterator implements java.util.Iterator<T> //la classe facilitant l'it�ration sur les �l�ments de la liste
	{
		private Noeud <T> itemCourant=debut.suivant;
		public boolean hasNext() //indique s'il existe un item apr�s celui courant sur lequel pointe l'it�rateur
		{
			return itemCourant !=fin;
		}
		
		public T next() //retourne l'element suivant  ou le noeud courant 
		{
			if(hasNext())
			{
				T suivant=itemCourant.item;
				itemCourant=itemCourant.itemSuivant;
				return suivant;
			}
			else
			{
				throw new java.util.NoSuchElementException(); //si l'element n'a pas de suivant et donc est le dernier
			}
		}
	}
}
