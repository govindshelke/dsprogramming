package arrays;

import java.util.Arrays;

public class MinimumDistance {
    public static void main(String[] args) {
        int[] arr1 = new int[]{23,5,10,17,30};
        int[] arr2 = new int[]{26,134,135,14,19};
        int[] result = pairWithMinDist(arr1,arr2);
        System.out.println("Result :"+ Arrays.toString(result));
    }

    // O(NLogN)
    private static int[] pairWithMinDist(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int a1 = 0;
        int a2 = 0;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(a1<arr1.length && a2<arr2.length){
            int currentMin = Math.abs(arr1[a1]-arr2[a2]);
            if(currentMin < min){
                result[0] = arr1[a1];
                result[1] = arr2[a2];
                min = currentMin;
            }
            if(arr1[a1] < arr2[a2]){
                a1++;
            }else{
                a2++;
            }
        }
        return result;
    }
}
