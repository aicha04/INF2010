package Sac;

public class Sac1 <T> implements Iterable<T> {
	private int taille;
	private Noeud <T> debut;
	private Noeud <T> fin;
	
	public int taille()
	{
		return taille;
	}
	
	public boolean estVide()
	{
		return (taille==0);
	}
	
	public Noeud<T> getNode (int position)
	{
		Noeud <T> noeudCherche= debut.itemSuivant;
		if( position >0 && position< taille)
			if(position< (taille/2))
			{
				for( int i=0;i <position; i++)
				{
					noeudCherche=noeudCherche.itemSuivant;
				}
			}
			else
			{
				for( int i=position; i> taille; i--)
				{
					noeudCherche=noeudCherche.itemPrecedent;
				}
			}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		
		return noeudCherche;
		
	}
	public void ajouterItem(Noeud <T> noeudAvant, T itemAajouter)
	{
		Noeud <T> noeudAajouter=new Noeud <T> (itemAajouter , noeudAvant.itemPrecedent, noeudAvant);
		noeudAajouter.itemPrecedent.itemSuivant=noeudAajouter;
		
		noeudAvant.itemPrecedent=noeudAajouter;
		taille++;
	}
	
	
	private static class Noeud<T>
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
	private class LinkedListIterator implements java.util.Iterator<T>
	{
		private Noeud <T> itemCourant;
		public boolean hasNext()
		{
			return itemCourant !=fin;
		}
		
		public T next()
		{
			if(hasNext())
			{
				T suivant=itemCourant.item;
				itemCourant=itemCourant.itemSuivant;
				return suivant;
			}
			else
			{
				throw new java.util.NoSuchElementException();
			}
		}
	}
}
