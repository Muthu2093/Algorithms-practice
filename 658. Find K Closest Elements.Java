class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> lis = new ArrayList<>();
        int l=0,r=arr.length-1, m=0;
        boolean flag = false;
        if (k<arr[0]){
            flag = true;
            r=k;
        }
        if (k>arr[0]){
            flag = true;
            l=r-k;
        }
        if (flag){
            while(l<=r){
                System.out.println(l);
                lis.add(arr[l]);
                l++;
            }
        }
        while (l<=r){
            m = (r+l) / 2;
            if(arr[m] == x){
                break;
            }
            else if(arr[m] < x){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        int i = 1;
        l=m;
        r=m;
        if (arr[m] > x){
            i=0;
            r=m-1;
        }
        else if (arr[m] < x){
            i=0;
            l=m+1;
        }
        while(i<k){
            System.out.println(l + ":" + m + ":" + r);
            if (l <= 0){
                
                r++;
            }
            else if (r >= arr.length-1){
                l--;
            }
            else if (x - arr[l-1] <= arr[r+1] - x) {
                l--;
            }
            else {
                r++;
            }
            i += 1;
        }
        while(l<=r){
            lis.add(arr[l]);
            l++;
        }
        return lis;
    }
}
