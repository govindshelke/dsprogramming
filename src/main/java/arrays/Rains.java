package arrays;

import java.util.Arrays;

public class Rains {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappedWater(arr);
        System.out.println("Result :"+result);
    }

    private static int trappedWater(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        right[n-1] = arr[n-1];
        for(int i=1; i<n; i++){
            left[i] = Math.max(arr[i],left[i-1]);
            right[n-i-1] = Math.max(arr[n-i-1],right[n-i]);
        }

        int totalRain = 0;
        for(int k =0; k<n; k++){
            totalRain +=Math.min(left[k],right[k]) - arr[k];
        }
        return totalRain;
    }

}
