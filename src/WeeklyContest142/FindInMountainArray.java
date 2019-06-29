package WeeklyContest142;

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index) {
    }

    public int length() {
    }
}

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        int begin = 0, end = length, middle;
        int lastBegin = 0, lastEnd = length;
        while (true) {
            middle = (begin + end) / 2;
            int beginNum = mountainArr.get(begin);
            int endNum = mountainArr.get(end);
            int middleNum = mountainArr.get(middle);
            if (beginNum >= middleNum && beginNum >= endNum) {
                begin = lastBegin;
                end = middle;
            } else if (endNum >= beginNum && endNum >= middleNum) {
                begin = middle;
                end = lastEnd;
            } else {
                lastBegin = begin;
                lastEnd = end;
            }
        }
    }
