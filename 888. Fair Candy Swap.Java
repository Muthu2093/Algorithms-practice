/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 */
 
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> setA = new HashSet<Integer>();
        HashSet<Integer> setB = new HashSet<Integer>();
        int sumA = 0, sumB = 0;
        int[] result = new int[2];
        
        for (Integer candy: A){
            sumA += candy;
            setA.add(candy);
        }
        for (Integer candy: B){
            sumB += candy;
            setB.add(candy);
        }
        
        for (Integer candyA: setA){
            if (sumA > sumB){
                if (setB.contains(candyA-(sumA-sumB)/2)){
                    result[0] = candyA;
                    result[1] = candyA-(sumA-sumB)/2;
                }
            }
            else{
                if (setB.contains(candyA+(sumB-sumA)/2)){
                    result[0] = candyA;
                    result[1] = candyA+(sumB-sumA)/2;
                }
            }
        }
        
        return result;
    }
}
