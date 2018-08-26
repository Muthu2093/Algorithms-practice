/** 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        vector<int> row;
        queue <TreeNode*> queue;
        TreeNode* marker = (TreeNode*) malloc(sizeof(TreeNode));
        queue.push(root);
        queue.push(marker);
        while(!queue.empty()){
            TreeNode* curr = queue.front();
            queue.pop();
            if (curr != NULL){
                row.push_back(curr->val);
                queue.push(curr->left);
                queue.push(curr->right);
            }
            while (queue.front() == marker){
                queue.pop();
                if (row.size() != 0){
                    result.push_back(row);
                }
                row.clear();
                if (!queue.empty()){
                    queue.push(marker);
                }
            }
        }
        return result;
    }
};
