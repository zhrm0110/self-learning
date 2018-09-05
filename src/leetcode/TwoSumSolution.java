package leetcode;

import java.util.HashMap;
import java.util.Map;


public class TwoSumSolution {
    /**
     * Time complexity : O(n^2)
     * For each element, we try to find its complement by looping through the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2)
     * Space complexity : O(1)*/
    public int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if (target==nums[i]+nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /**
     * Time complexity : O(n). We traverse the list containing n elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n)O.
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.*/
    public int[] twoSumTwoPassHashTable(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)&&map.get(complement)!=i) {
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }
    /**
     * Time complexity : O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.*/
    public int[] twoSumOnePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] exampleArray =new int[]{2,7,11,15};
        int target =9;
        TwoSumSolution twoSum = new TwoSumSolution();
        int[] result = twoSum.twoSum(exampleArray,target);
        int[] result2 = twoSum.twoSumTwoPassHashTable(exampleArray,target);
        int[] result3 = twoSum.twoSumOnePassHashTable(exampleArray, target);
        if (result != null) {
            System.out.println("two sum of {2,7,11,15} for target 9 is: "+ result[0] + ","+result[1]);
        }
        if (result2 != null) {
            System.out.println("two sum of {2,7,11,15} for target 9 is: "+ result2[0] + ","+result2[1]);
        }
        if (result3 != null) {
            System.out.println("two sum of {2,7,11,15} for target 9 is: "+ result3[0] + ","+result3[1]);
        }
    }

}
