import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrayCode {
    private int maxNum;
    private List<Integer> codeList, result;
    private HashMap<Integer, Integer> codeHashMap;

    private boolean isOneBitDifferent(int x, int y) {
        int z = x ^ y;
        return (z & (z - 1)) == 0;
    }

    private void getGrayCode(int x) {
        if (result != null) return;
        if (x == maxNum) {
            result = new ArrayList<>(codeList);
            return;
        }
        int lastCode = codeList.get(x - 1);
        for (int i = 1; i < maxNum; ++i) {
            if (codeHashMap.get(i) == null && isOneBitDifferent(lastCode, i)) {
                codeHashMap.put(i, i);
                codeList.add(i);
                getGrayCode(x + 1);
                codeHashMap.remove(i);
                codeList.remove(x);
            }
        }
    }

    public List<Integer> grayCode(int n) {
        result = null;
        codeList = new ArrayList<>();
        codeList.add(0);
        codeHashMap = new HashMap<>();
        codeHashMap.put(0, 0);
        maxNum = (int) Math.pow(2, n);
        getGrayCode(1);
        return result;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> result = grayCode.grayCode(10);
        for (int num : result) {
            System.out.println(Integer.toBinaryString(num));
        }
    }
}
