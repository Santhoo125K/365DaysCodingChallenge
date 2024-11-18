class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n=code.length;
        int ans[] = new int[n];
        
        if(k==0){
            return ans;
        }
        
        int direction = k>0 ? 1 : -1;
        k=Math.abs(k);
        
        for(int i=0; i<n; i++){
            int sum=0;
            
            for(int j=1;j<=k;j++){
                int index = (i + direction * j + n) % n;
                sum = sum + code[index];
            }
            ans[i] = sum;
        }
        
        return ans;
    }
}