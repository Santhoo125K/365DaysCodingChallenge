class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int[] candidates, int target, int index, List<Integer> tmp, List<List<Integer>> ans) {
        if(target < 0) return;
        if(target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] > target) continue;
            tmp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }
    }
}