class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, currGas = 0, start_ind = 0;
        for (int i=0; i<gas.length; i++){
            gas[i] = gas[i] - cost[i];
            sum += gas[i];
            
            if (currGas > 0){
                currGas += gas[i];
            }
            if (gas[i] > 0 && currGas <= 0){
                start_ind = i;
                currGas = gas[i];
            }
        }
        
        if (sum < 0){
            return -1;
        }
        
        return start_ind;
    }
}
