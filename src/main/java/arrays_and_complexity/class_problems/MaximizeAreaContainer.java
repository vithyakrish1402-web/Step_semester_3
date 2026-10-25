package arrays_and_complexity.class_problems;

public class MaximizeAreaContainer {

    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int hLeft = heights[left];
            int hRight = heights[right];
            int currentArea = Math.min(hLeft, hRight) * width;
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int maxContainerAreaBruteForce(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
        System.out.println(maxContainerAreaBruteForce(heights));
    }
}
