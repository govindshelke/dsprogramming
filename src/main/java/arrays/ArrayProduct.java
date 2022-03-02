package arrays;

import java.util.Arrays;

public class ArrayProduct {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int[] result = arrayProduct(arr);
        System.out.println("Result :"+ Arrays.toString(result));

        int[] result1 = arrayProduct1(arr);
        System.out.println("Result1 :"+ Arrays.toString(result1));
    }

    // O(N2)
    private static int[] arrayProduct(int[] arr) {
        int[] productArray = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int product = 1;
            for(int j=0; j<arr.length; j++){
                if(i != j){
                    product = product*arr[j];
                }
            }
            productArray[i] = product;
        }
        return productArray;
    }

    //O(N)
    private static int[] arrayProduct1(int[] arr) {
        int n = arr.length;
        int[] productArray = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        //calculate left product
        leftProduct[0] = arr[0];
        for(int i=1; i<n; i++){
            leftProduct[i] = leftProduct[i-1]*arr[i];
        }

        //calculate right product
        rightProduct[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1]*arr[i];
        }
        productArray[0] = rightProduct[1];
        productArray[n-1] = leftProduct[n-2];
        for(int i=1; i<n-1; i++){
            productArray[i] = leftProduct[i-1]*rightProduct[i+1];
        }
        return productArray;
    }
}
