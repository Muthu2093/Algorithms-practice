class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int r = arr.length;
        int m = r/2;
        int index = findCloseRec(arr, x, 0, r-1);
        //System.out.println(index);
        List<Integer> result = new ArrayList<Integer>(k);
        int v=k-1, i=0, j=0;
        while (v>0){
            //System.out.println(v);
            if (index-i>0 && v>0){
                i++;
                v--;
            }
            if (index+j<r-1 && v>0){
                //System.out.println("here");
                j++;
                v--;
            }
        }
        //System.out.println(i + ":" + j);
        for (v=index-i;v<=index+j;v++){
            result.add(arr[v]);
        }
        return result;
    }
    public int findCloseRec(int[] nums, int x, int l, int r){
        if (l<=r){
            int m = l + (r-l)/2;
            if (nums[m] == x){
                return m;
            }
            else if(nums[m]> x) {
                return findCloseRec(nums, x, l, m-1); 
            }
            return findCloseRec(nums, x, m+1, r);
        }
        return 0;
    }
}
