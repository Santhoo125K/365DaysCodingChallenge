public class Solution {
    public string RemoveOccurrences(string s, string part) {
        while(true)
        {
            var idx = s.IndexOf(part);
            if(idx == -1)
                break;
            var myList = s.ToList();
            myList.RemoveRange(idx, part.Length);
            s = new string(myList.ToArray());
        }
        return s;
    }
}