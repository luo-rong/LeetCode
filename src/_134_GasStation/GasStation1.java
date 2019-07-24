package _134_GasStation;

public class GasStation1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ++i) {
            if (gas[i] >= cost[i]) {
                int rest = 0;
                for (int j = 0; j < gas.length; ++j) {
                    rest = rest + gas[(i + j) % gas.length] - cost[(i + j) % gas.length];
                    if (rest < 0) {
                        break;
                    }
                }
                if (rest >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
