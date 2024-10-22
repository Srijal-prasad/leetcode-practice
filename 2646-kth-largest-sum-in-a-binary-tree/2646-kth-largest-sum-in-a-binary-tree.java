/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void bfs(TreeNode root,PriorityQueue<Long> minHeap,int k)
    {
        Queue<TreeNode> queue=new LinkedList<>();
       if(root==null)
         return;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int levelSize=queue.size();
            long levelSum=0;
            for(int i=0;i<levelSize;i++)
            {
                TreeNode currNode=queue.poll();
                levelSum+=currNode.val;
                if(currNode.left!=null)
                {
                    queue.add(currNode.left);
                }
                if(currNode.right!=null)
                {
                   queue.add(currNode.right);
                }

            }
            if(minHeap.size()<k)
            {
                minHeap.add(levelSum);
            }
            else if(levelSum>minHeap.peek())
            {
                long val=minHeap.poll();
                minHeap.add(levelSum);
            }

        }
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minHeap=new PriorityQueue<>();
        bfs(root,minHeap,k);
         if(minHeap.size()<k)
           return -1;
         return minHeap.peek();
    }
}