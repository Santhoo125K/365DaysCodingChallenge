class Solution {
    public String compressedString(String word) {
        if (word == null || word.isEmpty()) return "";

        StringBuilder st = new StringBuilder();
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            if ((word.charAt(i) == word.charAt(i - 1)) && count <9)  {
                count++;
            } else {
                st.append(count).append(word.charAt(i - 1));
                count = 1;  // Reset count for the new character
            }
        }
        
        // Append the last character and its count
        st.append(count).append(word.charAt(word.length() - 1));

        return st.toString();
    }
}
