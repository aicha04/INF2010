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
			worstChild=item;
		}
    	else
    	{
	    	childs.insert(item); //=>Log(n)
    	}
    	money+=item.money;
    	if(item.worstChild !=null)
    	{
    		Integer value= Math.min(item.worstChild.getMoney(), item.getMoney());
    		if(worstChild.getMoney()>value)
	    	{
	    		worstChild=item;
	    	}
    	
    	}
    	
    	
    	
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
    	prefix="<";
    	builder=new StringBuilder();
    	builder.append(money);
    	builder.append(prefix);
    	builder.toString();
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
