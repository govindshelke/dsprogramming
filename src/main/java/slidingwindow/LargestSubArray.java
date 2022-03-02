package slidingwindow;

public class LargestSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,1,1,2,3,5};
        int k = 5;
        int size = largestSubArrayOfSumK(arr,k);
        System.out.println("Largest Sub Array of length :"+size);
    }

    private static int largestSubArrayOfSumK(int[] arr, int k) {
        int i=0;
        int j=0;
        int sum=0;
        int max =0;
        while(j<arr.length){
            //calculation
            sum = sum +arr[j];

            while(sum>k){
                sum-=arr[i];
                i++;
            }

            if(sum == k){
                int currentLen = j-i+1;
                max = Math.max(currentLen,max);
            }

            j++;
        }
        return max;
    }
}
