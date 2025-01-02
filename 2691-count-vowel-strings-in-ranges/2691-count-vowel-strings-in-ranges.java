class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowel(words[i]) ? 1 : 0);
        }

        int qLen = queries.length;
        int[] ans = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] query = queries[i];
            ans[i] = prefix[query[1] + 1] - prefix[query[0]];
        }
        return ans;
    }

    public boolean isVowel(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    public boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
}