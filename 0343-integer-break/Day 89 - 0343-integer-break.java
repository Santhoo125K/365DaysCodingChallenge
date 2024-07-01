class Solution {
    public int integerBreak(int n) {
        
        int ans = 1;
        if(n==2) return 1;
        if(n==3) return 2;
        
        while(n>=3 && n-3>1){
            ans=ans*3;
            n-=3;
        }
        
        if(n>0){
            ans*=n;
        }
        
        return ans;
        
    }
}
