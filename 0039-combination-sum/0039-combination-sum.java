class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
           HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            set.add(candidates[i]);
        }
        List<Integer> l2 = new ArrayList<>(set);
        List<Integer> l1 = new ArrayList<>();
        List<List<Integer>> L1 = new ArrayList<>();
        f(0, l2.size(), l2, target, 0, l1, L1);
        return L1;
    }
    public static void f(int i, int n,List<Integer> l2 , int k, int sum, List<Integer> l1, List<List<Integer>> myList) {
        if ((i >= n) || (sum >= k)) {
            if (sum == k)
                myList.add(new ArrayList<>(l1));
            return;
        }
        l1.add(l2.get(i));
        f(i, n, l2, k, sum+l2.get(i), l1, myList);
        l1.remove(l1.size() - 1);
        f(i+1, n, l2, k, sum, l1, myList);
    }
}