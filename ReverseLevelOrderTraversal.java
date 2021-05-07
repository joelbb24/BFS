package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	
//	TreeNode(int x) {
//		val = x;
//	}
//}


public class ReverseLevelOrderTraversal {
	
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) 
			return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);
			for(int i=0; i<levelSize; i++) {
				TreeNode curr = q.poll();
				currentLevel.add(curr.val);
				
				if(curr.left != null)
					q.offer(curr.left);
				if(curr.right != null) 
					q.offer(curr.right);
			}
			result.add(0, currentLevel);
		}
		
		
		return result;
	}
	
	
	public static void main(String [] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
		System.out.println("Level order traversal: " + result);
	}

}