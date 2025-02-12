
public class Solution
{
    public int MaximumSum(int[] nums)
    {
        return nums.GroupBy(DigSums)
            .Where(x => x.Count() > 1)
            .Select(x => x.OrderDescending().Take(2).Sum())
            .Union([-1])
            .Max();
    }

    public int DigSums(int num)
    {
        int ans = 0;
        while (num > 0)
        {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}