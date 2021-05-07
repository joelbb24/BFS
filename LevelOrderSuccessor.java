package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

	private static TreeNode findSuccessor(TreeNode root, int key) {
		if(root == null)
			return null;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr.left != null) 
				q.offer(curr.left);
			if(curr.right != null)
				q.offer(curr.right);
			
			
			if(curr.val == key)
				break;
		}
		
		
		return q.peek();
	}

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		System.out.println(result.val+" ");
		
	}
}
