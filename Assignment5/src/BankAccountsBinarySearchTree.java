
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	//for testBalance
	//clears this tree to an Empty Tree
	public void clear(){
		if (!isEmpty())
			this.root=null;
	}
	public void balance(){
		if (!isEmpty()) {
			List<BankAccount> listInOrder = new LinkedList<>();
			Iterator<BankAccount> itr = new BinaryTreeInOrderIterator<>(root);
			while (itr.hasNext())
				listInOrder.add(itr.next());
			root=null;
			buildBalancedTree(listInOrder, 0, listInOrder.size() - 1);
		}
	}
	    
	private void buildBalancedTree(List<BankAccount> list, int low, int high) {
		if (low<=high) {
			int middle =(high+low)/2; //'low' middle
			BankAccount midData=list.get(middle);
			insert(midData);
			buildBalancedTree(list,low, middle-1);
			buildBalancedTree(list, middle +1,high);
		}
	}
}
