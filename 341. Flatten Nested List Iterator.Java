/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, 
 *              the order of elements returned by next should be: [1,4,6].
 */            

public class NestedIterator implements Iterator<Integer> {
    List<Integer> flattenedList;
    int index, size;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<Integer>();
        index = 0;
        recurse(nestedList);
        size = flattenedList.size();
    }
    
    public void recurse(List<NestedInteger> nestedList){
        for(NestedInteger elem: nestedList){
            if (elem.isInteger()){
                flattenedList.add(elem.getInteger());
            }
            else{
                recurse(elem.getList());
            }
        }
        
        return;
    }
        
    @Override
    public Integer next() {
        return flattenedList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }
}
