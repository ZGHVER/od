package LeetCode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MaxProfit {

    public static void main(String[] args) {
        int[] a = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(2,a));
    }

    public static int maxProfit(int k,int[] profit) {
        if (profit.length == 0) return 0;
        int[]ProfitList = new int[profit.length];
        int[] gap = new int[2];

        gap[0] = findMin(profit, 0);
        if(gap[0] == profit.length - 1){
            ProfitList[0]=0;
            return solve(k,ProfitList);
        }

        for(int i=0;(gap[1]=findMax(profit,gap[0]))!=profit.length-1;i++){
            ProfitList[i]=profit[gap[1]]-profit[gap[0]];
            gap[0]=findMin(profit,gap[1]);
        }
        ProfitList[ProfitList.length-1]=profit[gap[1]]-profit[gap[0]];
        return solve(k,ProfitList);
    }

    private static int solve(int k, int[] profitList) {
        int profit=0;
        Arrays.sort(profitList);
        for (int i = profitList.length-1; k >0 && i>0; i--,k--)
            profit+=profitList[i];
        return profit;
    }

    public static int findMin(int[] profit, int start) {
        for (int i = start; i < profit.length - 1; i++) {
            if (profit[i + 1] > profit[i])
                return i;
        }
        return profit.length - 1;
    }

    public static int findMax(int[] profit, int start) {
        for (int i = start; i < profit.length-1; i++) {
            if (profit[i + 1] < profit[i])
                return i;
        }
        return profit.length - 1;
    }
}