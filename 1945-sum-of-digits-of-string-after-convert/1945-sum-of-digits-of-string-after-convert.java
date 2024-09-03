class Solution {
    public int getLucky(String s, int k) {
        
        String hlp = "";
        
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            hlp=hlp+ (temp - 96);
        }
        return helper(hlp,k);
    }
    
    public int helper(String hlp, int k){
        int sum=0;
        for(int i=0;i<k;i++){
            sum=0;
            
            for(int j=0;j<hlp.length();j++){
                sum=sum + Character.getNumericValue(hlp.charAt(j));
            }
            hlp=Integer.toString(sum);
        }
        
        return sum;
    }
}