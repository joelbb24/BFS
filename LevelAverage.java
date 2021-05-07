package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {
	
	private static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if(root == null)
			return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int levelSize = q.size();
			double levelSum = 0;
			for(int i=0; i<levelSize; i++) {
				TreeNode curr = q.poll();
				levelSum += curr.val;
				
				if(curr.left != null)
					q.offer(curr.left);
				if(curr.right != null)
					q.offer(curr.right);
			}
			result.add(levelSum / levelSize);
		}
					
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(10);
//		root.right.left.left = new TreeNode(20);
//		root.right.left.right = new TreeNode(17);
		List<Double> result = LevelAverage.findLevelAverages(root);
		System.out.println("Level averages: " + result);
	}
}
