package LeetCode;

import java.util.*;

@SuppressWarnings("unused")
public class TowSum {
    public static void main(String[] args) {
        int[] a = new int[]{2,7,11,5};
        int[] ints = twoSum(a, 9);
        assert ints != null;
        System.out.println(ints[0] + " " + ints[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] old = new int[nums.length];
        for (int i = 0; i < old.length; i++) {
            old[i] = nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            int j = Search(nums, t, i, nums.length - 1);
            if (j != -1)
                return positOf(old, new int[]{nums[i], nums[j]});
        }
        return null;
    }

    private static int[] positOf(int[] old, int[] ints) {
        ArrayList<Integer> re = new ArrayList<>();
        for (int i = 0; i < old.length; i++) {
            if (old[i] == ints[0] || old[i] == ints[1])
                re.add(i);
        }
        return new int[]{re.get(0),re.get(re.size()-1)};
    }

    @SuppressWarnings("unchecked")
    private static int Search(int[] nums, int obj, int lo, int hi) {
        if (hi < lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = obj - nums[mid];
        if (cmp > 0)
            return Search(nums, obj, mid + 1, hi);
        else if (cmp < 0)
            return Search(nums, obj, lo, mid - 1);
        else
            return mid;
    }
}

