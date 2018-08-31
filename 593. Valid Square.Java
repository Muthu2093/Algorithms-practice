/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * Example:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * Note:
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
 
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1,p2) || Arrays.equals(p1,p3) || Arrays.equals(p1,p4) || Arrays.equals(p2,p3) || Arrays.equals(p2,p4) || Arrays.equals(p3,p4)){
            return false;
        }
        double dist[] = new double[6];
        dist[0] = distance(p1,p2);
        dist[1] = distance(p1,p3);
        dist[2] = distance(p1,p4);
        dist[3] = distance(p2,p3);
        dist[4] = distance(p2,p4);
        dist[5] = distance(p3,p4);
        
        double temp1 = -1, temp2 = -1;
        int count1 = 0, count2 = 0;
        for (int i=0; i<6; i++){
            if (dist[i] == temp1){
                count1 += 1;
            }
            else if (dist[i] == temp2){
                count2 += 1;
            }
            else if (temp1 == -1){
                temp1 = dist[i];
                count1+=1;
            }
            else if (temp2 == -1){
                temp2 = dist[i];
                count2+=1;
            }
            else{
                return false;
            }
        }
        
        if (!((count1 == 4 && count2 == 2) || (count1 == 2 && count2 ==4))){
            return false;
        }
        return true;
        
    }
    
    public double distance(int[] p1, int[] p2){
        return Math.sqrt(Math.pow((double)(p1[0])-(double)(p2[0]), 2) + Math.pow((double)(p1[1])-(double)(p2[1]), 2));
    }
}

// Code for reference - Nice solutions from discussion //

def validSquare(self, p1, p2, p3, p4):
    if p1 == p2 == p3 == p4: return False

    p1,p2,p3,p4 = sorted([p1,p2,p3,p4])
    if p2[1] < p3[1]: p2,p3 = p3,p2

    return p3 == [p1[0] + (p2[1]-p1[1]), p1[1] - (p2[0]-p1[0])]\
       and p4 == [p2[0] + (p2[1]-p1[1]), p2[1] - (p2[0]-p1[0])]
