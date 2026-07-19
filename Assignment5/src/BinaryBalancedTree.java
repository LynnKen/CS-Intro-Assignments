
public class BinaryBalancedTree<T> extends BinaryNode<T> {
	
	public BinaryBalancedTree(T element){
		super(element);
}
	
	public boolean isBalanced(BinaryNode<T> node) {
		if(node==null || (node.left==null & node.right==null))
			return true;
		int lh=-1,rh=-1;
		if(node.left==null) 
			rh=node.right.height();
		else if(node.right==null) 
			lh=node.left.height();
		else {
			lh=node.left.height();
			rh=node.right.height();
		}
		boolean balanaced=Math.abs(lh-rh)<=1;
		return  balanaced && isBalanced(node.right) && isBalanced(node.left);
	}
	
	
	
}
