/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
 
/**
 * Refer Link below for more elegant and good algorithms
 * https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60309/C++-PartitionMax-Heappriority_queuemultiset
 */
 
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        ListNode* ptr = new ListNode(0);
        ListNode* curr;
        int size = nums.size();
        for (int i=0; i<size; i++){
            curr = ptr;
            while(curr != NULL){
                if (curr->next == NULL){
                    curr->next = new ListNode(nums[i]);
                    break;
                }
                else if (nums[i] >= curr->next->val ){
                    ListNode* temp = new ListNode(nums[i]);
                    temp->next = curr->next;
                    curr->next = temp;
                    break;
                }
                else{
                    curr = curr->next;
                }
            }
            //cout<<i<<endl;
        }
        //while(ptr!=NULL){
        //    cout<<ptr->val;
        //    ptr = ptr->next;
        //}
        while(k>0){
            ptr = ptr->next;
            k--;
        }
        return ptr->val;
    }
};

// Using Java - for reference //

/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
*/
