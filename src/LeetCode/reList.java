package LeetCode;

public class reList {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
        for (int s : a)
            System.out.print(s + " ");
    }

    private static void rotate(int[] nums, int k) {
        if(nums.length <= 1) return;
            k=k%nums.length;
        int[] temp = new int[k];
        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++)
            temp[j] = nums[i];
        for (int i = nums.length - 1; i > k - 1; i--)
            nums[i] = nums[i - k];
        for (int i = 0; i < k; i++)
            nums[i] = temp[i];

    }
}
