package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {
	
	private static int findDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int minimumTreeDepth = 0;
		while(!q.isEmpty()) {
			minimumTreeDepth++;
			int levelSize = q.size();
			for(int i=0; i<levelSize; i++) {
				TreeNode curr = q.poll();
				
				if(curr.left == null && curr.right == null) 
					return minimumTreeDepth;
				
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
			}
		}
		
		return minimumTreeDepth;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	}
}
