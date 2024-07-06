// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> st = new Stack<>();
        
//         Map<Character, Character> mp = new HashMap<>();
//         mp.put('(',')');
//         mp.put('{','}');
//         mp.put('[',']');
        
//         for(char c : s.toCharArray()){
//             if(mp.containsKey(c)){
//                 st.push(c);
//             }else if(mp.containsValue(c)){
//                 if(st.isEmpty()){
//                     return false;
//                 }
                
//                 char top = st.pop();
                
//                 if(mp.get(top)!=c){
//                     return false;
//                 }
//             }
//         }
//         return st.isEmpty();
//     }
// }




class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char c: s.toCharArray()){
            if((c == ')' && !st.isEmpty() && st.peek() == '(') || (c == '}' && !st.isEmpty() && st.peek() == '{') || (c == ']' && !st.isEmpty() && st.peek() == '[')){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        
        return st.isEmpty();
 
    }
}