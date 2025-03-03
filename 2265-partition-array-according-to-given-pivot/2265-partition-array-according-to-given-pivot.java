class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        int count = 0, index = 0;
        for(int num:nums){
            if(num<pivot){
                answer[index++] = num;
            }else if(num==pivot){
                count++;
            }
        }
        while(count-- > 0){
            answer[index++] = pivot;
        }
        for(int num:nums){
            if(num>pivot){
                answer[index++] = num;
            }
        }
        return answer;
    }
}