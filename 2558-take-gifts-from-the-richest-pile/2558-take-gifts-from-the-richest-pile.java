class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int gift : gifts){
            maxHeap.add(gift);
        }
        
        for(int i=0; i<k; i++){
            
            int maxGift = maxHeap.poll();
            
            int remGift = (int) Math.floor(Math.sqrt(maxGift));
            
            maxHeap.add(remGift);
        }
        
        long sum=0;
        for(int val : maxHeap){
            sum+=val;
        }
        
        return sum;
    }
}