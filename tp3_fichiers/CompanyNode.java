package tp3;
import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    // TODO: initialisation
    // O(1)
    public CompanyNode(Integer data) {
    		money=data;
    		worstChild=null;
    		childs= null;
    }

    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {
    	
    	if(childs==null)
		{
			childs=new BinarySearchTree<CompanyNode>(item);
			if (item.worstChild!=null && item.getMoney().compareTo(item.worstChild.getMoney())==1) {
				
				worstChild=item.worstChild;
			}
			else {
				worstChild=item;
			}
		}
    	else
    	{
	    	childs.insert(item); //=>Log(n)
	    	if(item.worstChild !=null && item.worstChild!=null)
	    	{
	    		
	    		if (item.getMoney().compareTo(item.worstChild.getMoney())==-1) {
	    			if(worstChild.getMoney()>item.getMoney())
	    	    	{
	    	    		worstChild=item;
	    	    	}
	    		}
	    		else {
	    			if(worstChild.getMoney()>item.worstChild.getMoney())
	    	    	{
	    	    		worstChild=item.worstChild;
	    	    	}
	    		}
	    		
	    		
	    	}
	    	else if (item.worstChild !=null && item.worstChild==null) {
	    		if(worstChild.getMoney()>item.getMoney())
		    	{
		    		worstChild=item;
		    	}
	    	}
    	}
    	money+=item.money;
    	
    	
	}
    // TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
        //return Integer.MIN_VALUE;??
    	return money;
    }

    // TODO: on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint)
    // O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {
    	if(childs!=null) {
    		
    		for(int i=childs.getItemsInOrder().size()-1;i>=0;i--) {
    			builder.append(prefix);
    			
    			builder.append(childs.getItemsInOrder().get(i).getData().getMoney().toString()+"\n");
    			
    			childs.getItemsInOrder().get(i).getData().fillStringBuilderInOrder(builder, prefix+" > ");
    			
    		}
    		
    		
    	}
    	
    }

    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) 
    {
    	int value=money.compareTo(item.money);
        if( value<0)
        {
        	return -1;
        }
        else if(value >0)
        {
        	return 1;
        }
        return 0;
    }
     
}
