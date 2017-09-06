/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]); // 根节点
        TreeNode last = root; // 上一节点
        TreeNode tmp = null; // 当前节点
        TreeNode targetLeft = root; // 插入位置
        TreeNode lastParent = root; // 上一节点父节点
        TreeNode targetLeftParent = null; // 插入位置父节点 
        for(int i = 1; i < nums.length; i++) {
            // System.out.println("上一节点：" + last.val);
            tmp = new TreeNode(nums[i]);
            // System.out.println("当前节点: " + tmp.val);
            if(nums[i] > nums[i - 1]) { // 当前值大于上一个值
                if(tmp.val > root.val) { // 当前值大于根节点
                    // System.out.println("插入新的根节点" + tmp.val);
                    tmp.left = root;
                    root = tmp;
                } else { // 当前值小于根节点
                    if(last == lastParent.right) { // 上一节点是其父节点的右儿子
                        // System.out.println("上一节点是其父节点的右儿子");
                        // 寻找插入位置
                        targetLeft = root;
                        while(targetLeft.val > tmp.val) {
                            targetLeftParent = targetLeft;
                            targetLeft = targetLeft.right;
                        }
                        // System.out.println("找到插入位置：" + targetLeft.val);
                        // 插入当前节点
                        tmp.left = targetLeft;
                        targetLeftParent.right = tmp; 
                        // 更新相关节点
                        lastParent = targetLeftParent;
                    } else { // 上一节点是其父节点的左儿子
                        if(tmp.val < lastParent.val) { // 当前节点值小于上一节点的父节点
                            lastParent.left = tmp;
                            tmp.left = lastParent.left;
                        } else { // 当前节点值大于上一节点的父节点
                            // 寻找插入位置
                            targetLeft = root; 
                            while(targetLeft.val > tmp.val) {
                                targetLeftParent = targetLeft;
                                targetLeft = targetLeft.right;
                            }
                            // 插入当前节点
                            tmp.left = targetLeft;
                            targetLeftParent.right = tmp;
                            // 更新相关节点
                            lastParent = targetLeftParent;
                        }
                        tmp.left = last;
                        lastParent.left = tmp;
                    }
                }
            } else { // 当前值小于上一个值
                last.right = tmp;
                lastParent = last;
                // System.out.println("插入" + tmp.val + ", 父节点" + last.val);
            }
            last = tmp;
        }
        return root;
    }
}
