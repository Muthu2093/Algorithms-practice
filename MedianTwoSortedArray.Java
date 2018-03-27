// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int i=0,j=0,k=0;
    	int[] arr = new int[nums1.length+nums2.length];
        if (nums1.length==0){
            if (nums2.length%2==0){
                float a=(nums2[(nums2.length/2)-1]+nums2[(nums2.length/2)]);
                return (a/2);
            }
            else{
                return nums2[nums2.length/2];
            }
        }
        if (nums2.length==0){
            if (nums1.length%2==0){
                float a= (nums1[(nums1.length/2)-1]+nums1[(nums1.length/2)]);
                return (a/2);
            }
            else{
                return nums1[nums1.length/2];
            }
        }
    	while(k<((nums1.length+nums2.length)/2)+1){
    		if(nums1[i]<nums2[j]){
    			arr[k]=nums1[i];
    			i=i+1;
    			k=k+1;
                if (i == nums1.length){
                    while (k<((nums1.length+nums2.length)/2)+1){
                    arr[k]=nums2[j];
    			    j=j+1;
    			    k=k+1;
                    }
                break;
                }
    		}
    		else{
    			arr[k]=nums2[j];
    			j=j+1;
    			k=k+1; 
                if (j == nums2.length){
                    while (k<((nums1.length+nums2.length)/2)+1){
                    arr[k]=nums1[i];
    			    i=i+1;
    			    k=k+1;
                    }
                break;
                }
    		}
    
    	}    
        if ((nums1.length+nums2.length)%2==0){
            float a=((arr[k-2]+arr[k-1]));
            return a/2;
        }
        else{
            return arr[k-1];
        }
    }
}
