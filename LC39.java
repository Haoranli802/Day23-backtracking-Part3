class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(candidates, target, 0);
        return result;
    }
    private void backTracking(int[] candidates, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //if(target < 0) return;
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) continue;
            path.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
// O(S), 其中S为所有可行解的长度之和，O(n * 2^n) 是一个比较松的上界，但是实际情况会远远小于此
// O(target) 在最差情况下，递归深度为target层
