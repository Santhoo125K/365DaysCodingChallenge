class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        
        int i;
        long sum=0;
        
        for(int j=0;j<chalk.length;j++){
            sum+=chalk[j];
        }
        
        k= (int)(k % sum);
        
        for( i=0;i<chalk.length;i++){
            if(chalk[i] > k){
                return i;
            }
            
            k=k-chalk[i];
        }
        
        return -1;
    }
}