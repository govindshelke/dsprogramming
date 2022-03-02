package arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArraySum(arr);
        System.out.println("Result :"+result);
    }

    private static int maxSubArraySum(int[] arr) {
        int maxSum = 0;
        int currentSum = 0;
        for(int i=0; i<arr.length; i++){
            currentSum = Math.max(currentSum + arr[i],arr[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
