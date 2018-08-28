/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
 
 /**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return sortedArrayToBSTRec(nums, 0, nums.size()-1);
    }
    TreeNode* sortedArrayToBSTRec(vector<int>& nums, int l , int r){
        if (l == r){
            //cout<<nums[l]<<endl;
            return new TreeNode(nums[l]);
        }
        int m = (r+l)/2;
        TreeNode* root = NULL;
        if (l<=r){
            root = new TreeNode(nums[m]);
            //cout<<nums[m]<<endl;
            root->left = sortedArrayToBSTRec(nums, l, m-1);
            root->right = sortedArrayToBSTRec(nums, m+1, r);
        }
        return root;
    }
};
