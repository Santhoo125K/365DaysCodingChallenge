import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int sorted[] = arr.clone();
        Arrays.sort(sorted);
        
        Map<Integer, Integer> mp = new HashMap<>();
        int rank = 1;
        
        for(int num : sorted){
            if(!mp.containsKey(num)){
                mp.put(num,rank++);
            }
        }
        
        for(int i=0;i<arr.length;i++){
            arr[i] = mp.get(arr[i]);
        }
        
        return arr;
    }
}