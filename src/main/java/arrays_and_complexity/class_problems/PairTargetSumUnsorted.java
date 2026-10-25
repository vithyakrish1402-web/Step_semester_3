package arrays_and_complexity.class_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairTargetSumUnsorted {

    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static int[] findPairIndices(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(hasPairWithSum(nums1, target1));
        System.out.println(Arrays.toString(findPairIndices(nums1, target1)));

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println(hasPairWithSum(nums2, target2));
        System.out.println(Arrays.toString(findPairIndices(nums2, target2)));
    }
}
