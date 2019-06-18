package _202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> numSet = new HashSet<>();
        int num = n;
        int nextNum = 0;
        numSet.add(num);
        while (num != 1) {
            while (num != 0) {
                nextNum += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = nextNum;
            nextNum = 0;
            if (numSet.contains(num)) {
                break;
            }
            numSet.add(num);
        }
        return num == 1;
    }
}
