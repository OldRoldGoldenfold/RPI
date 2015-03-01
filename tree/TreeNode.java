package tree;

import atcs.KeyValuePair;

public class TreeNode {

	private KeyValuePair kvp;
	private TreeNode right;
	private TreeNode left;

	public TreeNode(KeyValuePair kvp) {
		this.kvp = kvp;
	}

	public TreeNode getRight() {
		return right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode setRight(TreeNode newRight){
		right = newRight;
		return right;
	}

	public TreeNode setLeft(TreeNode newLeft) {
		left = newLeft;
		return left;
	}

	public KeyValuePair getkvp() {
		return kvp;
	}

	public void setkvp(KeyValuePair kvp){
		this.kvp = kvp;
	}
}
