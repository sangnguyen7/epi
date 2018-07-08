// Write a program that returns the size of the largest substree that is complete
/*
	public TreeNode{
		int val;
		TreeNode left, right;
		public TreeNode(int value){
			this.val = value;
		}
	}

*/

public int findLargestCompleteSubtree(TreeNode root){
	if (root == null) return 0;
	if (root.left == null && root.right == null) 
		return 1;
	
	int left = findLargestCompleteSubtree(root.left);
	int right = findLargestCompleteSubtree(root.right);
	
	return (left == right) ? Math.max(left, right)+1 : Math.max(left, right);
}