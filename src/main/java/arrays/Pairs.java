package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pairs {

    public static void main(String[] args) {
        int[] arr = new int[]{10,5,2,3,-6,9,11};
        int targetSum = 4;
        int[] result = findPair(arr,targetSum);
        System.out.println("Result :"+ Arrays.toString(result));

        int[] result1 = findPair1(arr,targetSum);
        System.out.println("Result1 :"+ Arrays.toString(result1));
    }

    // O(N)
    private static int[] findPair(int[] arr, int targetSum) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();

        for (int j : arr) {
            if (set.contains(targetSum - j)) {
                result[0] = targetSum - j;
                result[1] = j;
                return result;
            } else {
                set.add(j);
            }
        }
        return result;
    }

    //O(NLogN)
    private static int[] findPair1(int[] arr, int targetSum) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            if(arr[left]+arr[right] == targetSum) {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            }else if((arr[left]+arr[right]) < targetSum){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }



}
