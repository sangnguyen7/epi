/*
	Define a node in a binary tree to be k-balanced if the difference in the number of nodes in its left and right subtrees is no more than k. Design an algorithm that takes as input a binary tree and posisitive integer k, and returns a node in the binary tree such that the node is not k-balanced, but all of its descendants are k-balanced. For example, when applied to the binary tree in Figure 9.1 on Page 123, if k = 3, your algorithm should return Node J.
*/

class K-BalancedNode{
	boolean balanced;
	int numOfNode;
	TreeNode node;
	
	public K-BalancedNode(boolean balanced, int num, TreeNode node){
		this.balanced = balanced;
		this.numOfNode = num;
		this.node = node;
	}
}

public TreeNode findNotKBalancedNode(TreeNode root, int k){
	K-BalancedNode result = getNotKBalancedNode(root, k);
	if (!result.balanced) return null;
	
	return result.node;
}

public K-BalancedNode getNotKBalancedNode(TreeNode root, int k){
	if (root == null) 
		return new K-BalancedNode(true, 0, null);
	K-BalancedNode left = getNotKBalancedNode(root.left, k);
	if (!left.balanced)
		return left;
	K-BalancedNode right = getNotKBalancedNode(root.right, k);
	if(!right.balanced)
		return right;
	
	boolean balanced = Math.abs(left.numOfNode - right.numOfNode) <= k;
	
	int num = left.numOfNode + right.numOfNode + 1;
	
	return new K-BalancedNode(balanced, num, root);
}