class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) break;
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i+1);
            path.removeLast();
        }
    }
}
//O(n * 2^n)
//O(n)
