package arrays;

import java.util.Arrays;

public class SubArraySort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,4,8,10,9,15};
        int[] result = findSubArray(arr);
        System.out.println("Result :"+ Arrays.toString(result));
    }

    private static int[] findSubArray(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(isOutOfOrder(arr,i)){
                smallest = Math.min(smallest,arr[i]);
                largest = Math.max(largest,arr[i]);
            }
        }
        if(smallest == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }

        int left = 0;
        while(smallest >= arr[left]){
            left++;
        }

        int right = arr.length-1;
        while(largest<=arr[right]){
            right--;
        }
        return new int[]{left,right};
    }

    private static boolean isOutOfOrder(int[] arr, int i) {
        if(i == 0){
            return arr[i] > arr[i+1];
        }
        else if(i == arr.length-1){
            return arr[i] < arr[i-1];
        }
        else{
            return arr[i] > arr[i+1] || arr[i] < arr[i-1];
        }
    }
}
