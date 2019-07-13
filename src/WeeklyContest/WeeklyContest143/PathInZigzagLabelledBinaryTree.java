package WeeklyContest.WeeklyContest143;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    private int getLine(int label) {
        int line = 0;
        while ((label >>= 1) > 0) {
            ++line;
        }
        return line;
    }

    private int getZigzagLabel(int line, int label) {
        return (1 << line) + (1 << (line + 1)) - 1 - label;
    }

    public List<Integer> pathInZigZagTree(int label) {
        int line = getLine(label);
        List<Integer> labelList = new ArrayList<>(line + 1);
        int[] labels = new int[line + 1];
        label = line % 2 == 1 ? getZigzagLabel(line, label) : label;
        for (int i = line; i >= 0; --i) {
            labels[i] = i % 2 == 1 ? getZigzagLabel(i, label) : label;
            label >>= 1;
        }
        for (int lab : labels) {
            labelList.add(lab);
        }
        return labelList;
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree tree = new PathInZigzagLabelledBinaryTree();
        System.out.println(tree.pathInZigZagTree(1));
        System.out.println(tree.pathInZigZagTree(14));
        System.out.println(tree.pathInZigZagTree(26));

    }
}
