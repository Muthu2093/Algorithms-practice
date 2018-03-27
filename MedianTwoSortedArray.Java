class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int i=0,j=0,k=0;
    	int[] arr = new int[nums1.length()+nums2.length()];
    	while((k<((num1.length()+nums2.length())/2)+1) && i < nums1.length() && j<){
    		if(nums1[i]<nums2[j]){
    			arr[k]=nums1[i];
    			i=i+1;
    			k=k+1;
    		}
    		else{
    			arr[k]=nums2[j];
    			j=j+1;
    			k=k+1; 
    		}
    	}      
    }
}
