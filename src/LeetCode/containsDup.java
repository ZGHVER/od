package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class containsDup {
    public static void main(String[] args) {
        int[] a = {4, 9, 9, 5};
        int[] b = {9, 4, 9, 8, 4};
        int[] c = intersect(a, b);
        for (int w :
                c) {
            System.out.print(w + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] big, small;
        ArrayList<Integer> ret = new ArrayList<>();

        if (nums1.length > nums2.length) {
            big = nums1;
            small = nums2;
        } else {
            big = nums2;
            small = nums1;
        }

        for (int b = 0, s = 0; b < big.length && s < small.length; ) {
            if (big[b] == small[s]) {
                ret.add(small[s]);
                b++;
                s++;
            } else if (big[b] > small[s])
                while (s < small.length && big[b] > small[s])
                    s++;
            else if (big[b] < small[s])
                while (b < big.length && big[b] < small[s])
                    b++;
        }

        int[] o = new int[ret.size()];
        int z = 0;
        for (int a : ret) {
            o[z] = a;
            z++;
        }
        return o;
    }

}
