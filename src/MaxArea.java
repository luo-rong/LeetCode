public class MaxArea {
    public int maxArea1(int[] height) {
        int result = 0;
        int n = height.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
        }
        return result;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea.maxArea(new int[]{1, 1}));
        System.out.println(maxArea.maxArea(new int[]{1, 1, 110}));
    }
}
