/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1){
            return lists[0];
        }
        
        if(lists.length == 0){
            return null;
        }
        
        int max = -99999, i=0;
        int LISID = 0;
        boolean flag = false;
        
        for (i=0;i<lists.length; i++){
            ListNode a = new ListNode(0);
            a = lists[i];
            while(lists[i] != null){
                if (max < lists[i].val){
                    max = lists[i].val;
                    LISID = i;
                }
                lists[i] = lists[i].next;
            }
            lists[i] = a;
        }
        if (max == -99999){
            return null;
        }
        
        ListNode a = new ListNode(0);
        ListNode initial = a;
        while (lists[LISID] != null){
            if (flag == true){
                a.next = new ListNode(0);
                a = a.next;
            }
            flag = true;
            a = smallValue(LISID,a,lists);
        }
        return initial;
    }
    
    public ListNode smallValue(int LISID, ListNode a, ListNode[] lists){
        a.val = lists[LISID].val;
        int lisID = LISID;
        for(int i=0; i<lists.length; i++){
            int val;
            if (lists[i] == null){
                //System.out.println("here"); 
                continue;
            }
            if(lists[i].val < a.val){
                //System.out.println(lists[i].val +"::::::"+ a.val); 
                a.val = lists[i].val;
                lisID=i;
            }
        }
        
        //System.out.println(lisID + ":" + a.val);
        
        if (lists[lisID].next != null){
            lists[lisID] = lists[lisID].next;
        }
        else{
            lists[lisID] = lists[lisID].next;
            //lists[lisID].val = 10000;
        }
        return a;
    }
    
}
