package _118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        List<Integer> lastLine = new ArrayList<>(1);
        lastLine.add(1);
        triangle.add(lastLine);
        for (int i = 2; i <= numRows; ++i) {
            List<Integer> currLine = new ArrayList<>(i);
            currLine.add(1);
            for (int j = 1; j < i - 1; ++j) {
                currLine.add(lastLine.get(j - 1) + lastLine.get(j));
            }
            currLine.add(1);
            lastLine = currLine;
            triangle.add(lastLine);
        }
        return triangle;
    }
}
