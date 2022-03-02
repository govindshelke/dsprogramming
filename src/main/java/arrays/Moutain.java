package arrays;

public class Moutain {

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
        int result = findLength(arr);
        System.out.println("Result :"+result);
    }

    //O(N)
    private static int findLength(int[] arr) {
        int maxLength = 0;
        int i=1;
        while(i<arr.length-1){

            // Find the peak
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int length = 1;
                // moving backwards
                int j = i;
                while(j>0 && arr[j]> arr[j-1]){
                    length++;
                    j--;
                }

                // moving forward
                while(i<arr.length-1 && arr[i]>arr[i+1]){
                    length++;
                    i++;
                }
                maxLength = Math.max(maxLength,length);
            }else{
                i++;
            }
        }
      return maxLength;
    }

}
