## Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
## Note:
## The solution set must not contain duplicate triplets.
## Example:
## Given array nums = [-1, 0, 1, 2, -1, -4],
## A solution set is:
## [
##   [-1, 0, 1],
##   [-1, -1, 2]
## ]
class Solution:
    
    def quickSort(self, nums, l, r):
        
        if(l<r):
            pi = self.partition(nums, l, r)
            self.quickSort(nums, l, pi-1)
            self.quickSort(nums, pi+1, r)
    
    def partition(self, nums, low, high):
        pivot = nums[high]
        j=low-1
        
        for i in range(low, high): 
            if nums[i] <= pivot:
                j += 1
                nums[i],nums[j] = nums[j],nums[i]
        
        nums[high],nums[j+1] = nums[j+1],nums[high]
        return (j+1)
    
    
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) <= 2:
            return []
        
        if len(nums) == 3:
            if sum(nums) == 0:
                lis = []
                lis.append(nums)
                return lis
        
        
        #self.quickSort(nums, 0 , len(nums)-1)
        nums.sort()
        lis =[]
        
        for m in range (1,len(nums)-1):
            l=0
            r=len(nums)-1
            
            if (m+2 <= r and nums[m] == nums[m+2]):
                k=m+3
                while(k<=r and nums[m] != nums[k]):
                    k = k + 1
                    if k > r:
                        break
                m=k-2
                l=k-3
                
            while (l<m and m<r):
                if (nums[l] + nums[m] + nums[r] == 0):
                    lis.append((nums[l],nums[m],nums[r]))
                    while(l<r and nums[l] == nums[l+1]):
                        l = l+1
                    while(l<r and nums[r] == nums[r-1]):
                        r = r-1
                        
                if (nums[l] + nums[m] + nums[r] < 0):
                    l = l + 1
                else:
                    r = r - 1
                
        lis = list(set(lis))
        return lis
                
            
