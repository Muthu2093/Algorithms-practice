public class Solution {
    public static void main(String args[] ) throws Exception {
        
        // Example Code of Reader for fast I/O
        Reader s=new Reader();
        int n = s.nextInt(); // stores number of modules
        int k = s.nextInt(); // stores number of dependencies
        
        /**
         * Topological sorting can be used for the Scheduling of modules
         * The algorithm used here is adapted from Kahn's algorithm with modification for choosing lexigraphically smallest element
         * An array of lists are used for storing adjancecy_list and dependency_list
         * Two lists are maintained - a Priority Queue and a LinkedList
         * The Priority Queue stores the modules that are ready for execution - no depencies
         * The Priority Queue helps us in executing modules in lexicographical order
         * The LinkedList stores the final order of the modules;
         * LinkedList are used for their constant O(1) time for removal, insertion and addition.
         * Time Complexity - O(n+k)
         * Space Complexity - O(n), where n is the total number of modules
         */
        
        /**
         * References
         * https://en.wikipedia.org/wiki/Topological_sorting
         * https://www.cs.usfca.edu/~galles/visualization/TopoSortDFS.html
         */
        
        /**
         * Possible solutions:
         * A Depth First Search can be used in a similiar manner for ordering modules
         * Instead of storing the dependency_list, an int[] array containing indegree of each node can be maintained - for less memory
         */
        
        // Convert edges list to adjacency list //
        List<Integer>[] adj_list = new LinkedList[n+1]; // stores all outgoing edges ie. modules dependent of a module
        List<Integer>[] dep_list = new LinkedList[n+1]; // stores all incoming edges ie. dependencies of a module
        
        // Initialize lists //
        for (int i=1; i<=n; i++){
            adj_list[i] = new LinkedList<Integer>();                     
            dep_list[i] = new LinkedList<Integer>();
        }
        
        // Converting the input edges to adjaceny list and dependency list //
        for (int i=0; i<k; i++){
            int child = s.nextInt();
            int parent = s.nextInt();
            adj_list[parent].add(child);
            dep_list[child].add(parent);
        }
        
        // Add modules without a dependency to the queue /
        // Priority queue is used to store only the module ready for execution - no depenedencies or all dependencies are executed
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=1; i<=n; i++){
            if (dep_list[i].size() == 0){
                queue.offer(i);
            }
        }
        
        // Remove the smallest element from queue available for execution and update the dependency list //
        List<Integer> ordered_modules = new LinkedList<>();
        while(!queue.isEmpty()){
            int parent = queue.poll();
            ordered_modules.add(parent);
            for (Integer child: adj_list[parent]){
                dep_list[child].remove(Integer.valueOf(parent));
                if (dep_list[child].isEmpty()){
                    queue.offer(child);
                }
            }
        }
        
        // Checked if there are still edges present //
        if (ordered_modules.size() != n){
            System.out.println("No valid ordering exists");
            return;
        }
        
        //Printing the Valid Topological order of the modules with the smallest module first
        for (Integer node: ordered_modules){
            System.out.print(node + " ");
        }
        
        return;     
    }
}
