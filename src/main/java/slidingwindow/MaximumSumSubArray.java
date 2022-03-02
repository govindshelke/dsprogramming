package slidingwindow;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 200, 300, 400};
        int k = 2;
        int sum = maxSumSubArray(arr,k);
        System.out.println("Sum :"+sum);
    }

    private static int maxSumSubArray(int[] arr, int k) {

        int i=0;
        int j=0;
        int maxSum = 0;
        int currentSum = 0;
        while(j<arr.length){
            currentSum = currentSum + arr[j];
            if(j-i+1 == k){
                maxSum = Math.max(maxSum,currentSum);
                currentSum = currentSum - arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
