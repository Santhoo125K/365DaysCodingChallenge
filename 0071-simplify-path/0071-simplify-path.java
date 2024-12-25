class Solution {
    public String simplifyPath(String path) {
        
        if(path == null) return "/";
        
        Stack<String> st = new Stack<>();
        
        for(String s: path.split("/")){
            
            if(s.equals(".") || s.isEmpty()) continue;
            
            if(s.equals("..")){
                if(st.size()>0) st.pop();
                continue;
            }
            
            st.push(s);
        }
        
        if(st.isEmpty()) return "/";
        
        return "/" + String.join("/", st);
        
    }
}
