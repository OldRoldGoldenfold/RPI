package tree;

import atcs.KeyValuePair;

public class BinaryTree {

	TreeNode root;
	int size;
	long add;
	long find;
	
	public long getAC() { return add; }
	public long getFC() { return find;}
	
	public void resetComparisons(){
		add = 0;
		find = 0;
	}
	
	public BinaryTree() {
		root = null;
		find = 0;
		add = 0;
		size = 0;
	}
	
	public void add(KeyValuePair kvp){
			root = add(kvp, root);
	}
	
	private TreeNode add(KeyValuePair kvp, TreeNode n) {
		if (n == null) {
			size++;
			return new TreeNode(kvp);
		}
		else {
			add++;
			int diff = kvp.compareTo(n.getkvp());
			if  (diff > 0){
				n.setRight(add(kvp, n.getRight()));
			}
			else if (diff < 0) {
				n.setLeft(add(kvp, n.getLeft()));
			}
			return n;
		}
	}
	
	public KeyValuePair find(KeyValuePair kvp){
			return find(kvp, root);
	}
	
	private KeyValuePair find(KeyValuePair kvp, TreeNode n){
		if (n == null) {
			return null;
		}
		find++;
		int diff = kvp.compareTo(n.getkvp());
		if (diff == 0) {
			return n.getkvp();
		}
		else {
			return find(kvp, (diff > 0)? n.getRight() : n.getLeft());
		}
	}
	
	public String toString(){
			return toString("", root);
			
	}
	
	private String toString(String out, TreeNode node){
		if (node != null) {
			out = toString(out, node.getLeft());
			out = out + node.getkvp() + "\n";
			out = toString(out, node.getRight());
		}
		return out;
	}
	
}