// PriorityQueue to record and reorder all the chars we have 
// int array to to record how many of each char
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Queue<Character> q=  new PriorityQueue<>((a,b)->b-a);
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for(char c:s.toCharArray()) {
            count[c-'a']++;
            if(count[c-'a']==1) q.offer(c);
        }

        while(!q.isEmpty()){
            char c = q.poll();
            int curr=0;
			// add the current char to stringbuidler
			// meanwhile updating the count array
            while(count[c-'a']>0&&curr<repeatLimit){
                sb.append(c);
                curr++;
                count[c-'a']--;
            }
			// if there's still char remaining but we hit repeat limit
			// we just use next char in priorityqueue
            if(count[c-'a']>0 && q.peek()!=null){
                char next = q.peek();
                sb.append(next);
                count[next-'a']--;
                if(count[next-'a']==0) q.poll();
				// don't forget to current char back
                q.offer(c);
            }
        }
        
        return sb.toString();
    }
}