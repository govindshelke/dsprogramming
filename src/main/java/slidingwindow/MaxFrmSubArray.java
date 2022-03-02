package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxFrmSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxFrmSubArrayOfK(arr,k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] maxFrmSubArrayOfK(int[] arr, int k) {

        int i=0;
        int j=0;
        int[] result = new int[arr.length-k+1];
        int index =0;
        Deque<Integer> deque = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        while(j<arr.length){
            //calculation4
            while(!deque.isEmpty() && deque.peek()<arr[j]){
                deque.pop();
            }
            deque.add(arr[j]);

            if(j-i+1 == k){
                // find the answer
                result[index] = deque.peek();
                index++;
                //slide the window
                if(arr[i] == deque.peek()){
                    deque.pop();
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
