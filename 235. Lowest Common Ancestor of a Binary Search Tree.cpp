/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
 *              according to the LCA definition.
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
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
    TreeNode* result;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (p == root || q == root){
            return root;
        }
        searchRec(root, p, q);
        return result;
    }
    bool searchRec(TreeNode* root, TreeNode* p, TreeNode* q){
        if (root == NULL){
            return false;
        }
        bool left = searchRec(root->left, p, q);
        bool right = searchRec(root->right, p, q);
        //cout<< root->val<< ":"<<"left:"<<left<<"right:"<<right<<endl;
        if (left == 1 && right == 1){
            cout<<"here1"<<endl;
            result = root;
        }
        else if ((left != right) && (root == p || root == q)) {
            cout<<"here2"<<endl;
            result = root;
        }
        else if(root == p || root == q || left != right){
            cout<<"here3"<<endl;
            return true;
        }
        return false;
    }

};
