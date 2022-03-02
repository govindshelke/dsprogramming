package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,15};
        int targetSum = 18;
        List<List<Integer>> result = findTriplets(arr,targetSum);
        System.out.println("Result :"+ result);
    }

    //O(N2)
    private static List<List<Integer>> findTriplets(int[] arr, int targetSum) {
        Arrays.sort(arr); //O(Nlogn)
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<arr.length-3; i++){  // O(N2)
            int left =i+1;
            int right = arr.length-1;

            while(left<right){
                if(arr[i]+arr[left]+arr[right] == targetSum){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    result.add(triplet);
                    left++;
                    right--;
                }else if(arr[i]+arr[left]+arr[right] <targetSum){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }

}
