class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        for(int[] i : prerequisites) {        
            List<Integer> tmp = preReqMap.getOrDefault(i[0], new ArrayList<Integer>());
            tmp.add(i[1]);
            preReqMap.put(i[0], tmp);
        }

        Set<Integer> completed = new HashSet<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(!completed.contains(i) && isCycle(preReqMap, i, new HashSet<Integer>(), completed)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isCycle(Map<Integer, List<Integer>> preReqMap, int course, Set<Integer> visited, Set<Integer> completed) {
        if(!preReqMap.containsKey(course)) return false;
        visited.add(course);
        completed.add(course);        
        
        boolean cycle = false;
        for(Integer next : preReqMap.get(course)) {
            if(visited.contains(next) || (!completed.contains(next) && isCycle(preReqMap, next, visited, completed))) {
                cycle = true;
                break;
            }
        }
        visited.remove(course);
        return cycle;
    }
    
}