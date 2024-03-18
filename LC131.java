class Solution {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(s, 0);
        return result;
    }
    private void backTracking(String s, int index){
        if(index >= s.length()){
            result.add(new ArrayList<>(path));
        }
        for(int i = index; i < s.length(); i++){
            if(check(s, index, i)){
                path.add(s.substring(index, i + 1));
                backTracking(s, i + 1);
                path.removeLast();
            }
        }
    }
    private boolean check(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start ++;
            end --;
        }
        return true;
    }
}

//时间复杂度: O(n * 2^n)
//空间复杂度: O(n^2)
