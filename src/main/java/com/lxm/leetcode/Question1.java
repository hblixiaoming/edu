package com.lxm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LXM on 2019/6/21.
 */
public class Question1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSumImp1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return null;
    }

    public int[] twoSumImp2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                for (int z = y + 1; z < nums.length; z++) {
                    if ((nums[x] + nums[y] + nums[z]) == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[x]);
                        temp.add(nums[y]);
                        temp.add(nums[z]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Question1 question1 = new Question1();
        int[] nums = {3,2,4};
        int[] result = question1.twoSum(nums, 6);
        System.out.println(result);

        int[] result1 = question1.twoSumImp1(nums, 6);
        System.out.println(result1);
    }
}
