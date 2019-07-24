package _134_GasStation;

/**
 * 题解：https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode/
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tot_rest = 0, curr_rest = 0;
        int start = 0;
        for (int i = 0; i < gas.length; ++i) {
            curr_rest += gas[i] - cost[i];
            tot_rest += gas[i] - cost[i];
            if (curr_rest < 0) {
                start = i + 1;
                curr_rest = 0;
            }
        }
        return tot_rest < 0 ? -1 : start;
    }
}
