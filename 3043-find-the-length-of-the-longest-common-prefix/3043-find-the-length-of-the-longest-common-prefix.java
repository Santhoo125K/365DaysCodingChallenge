import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> mp = new HashMap<>();
        
        for(int num: arr1){
            String st=Integer.toString(num);
            String prefix="";
            
            for(char c: st.toCharArray()){
                prefix+=c;
                mp.put(prefix, mp.getOrDefault(prefix,0)+1);
            }
        }
        
        int len=0;
        
        for(int num: arr2){
            String st=Integer.toString(num);
            String prefix="";
            
            for(char c: st.toCharArray()){
                prefix+=c;
                
                if(mp.containsKey(prefix)){
                    len=Math.max(len,prefix.length());
                }
            }
            
        }
        
        return len;
        
    }
}