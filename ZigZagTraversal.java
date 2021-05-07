package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
	
	private static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if( root == null) {
			return result;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean leftToRight = true;
		while(!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> currentLevel = new LinkedList<>();
			for(int i=0; i<levelSize; i++) {
				TreeNode curr = q.poll();
				
				//add the node to the current level based on  the traverse direction
				if(leftToRight)
					currentLevel.add(curr.val);
				else
					currentLevel.add(0, curr.val);
				
				//insert the children of the current node in the queue
				if(curr.left != null) 
					q.offer(curr.left);
				if(curr.right != null)
					q.offer(curr.right);
			}
			result.add(currentLevel);
			leftToRight = !leftToRight;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigZagTraversal.traverse(root);
		System.out.println("ZigZag Traversal : " + result);
	}
}
