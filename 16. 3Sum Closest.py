## Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
## Example:
## Given array nums = [-1, 2, 1, -4], and target = 1.
## The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums)<=3:
            return sum(nums)
        nums.sort()
        sums = -999
        for m in range(1, len(nums)-1):
            l = 0
            r = len(nums)-1 
            while (l<m and m<r):       
                temp = nums[l] + nums[m] + nums[r]
                if (temp == target ):
                    return target
                if (abs(target-temp) < abs(target-sums)):
                    sums = temp
                if (temp > target):
                    r = r-1
                if (temp < target):
                    l = l+1
        return sums
                
            
                
            
