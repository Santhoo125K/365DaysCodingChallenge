class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        int n1 = words1.length, n2 = words2.length;
        int i = 0, j = 0;
        
        // Compare prefix words (from the beginning)
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }
        
        // Compare suffix words (from the end)
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }
        
        // After matching the prefix and suffix, the remaining words must either form the middle sentence or be empty.
        return i + j == Math.min(n1, n2);
    }
}
