package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {
    public static void main(String[] args) {
        int[] arr = new int[]{1,9,3,0,18,5,2,4,10,7,12,6};
        int result = lengthOfLongestBand(arr);
        System.out.println("Result :"+result);
    }

    private static int lengthOfLongestBand(int[] arr) {
        //put all ele in Set
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int maxLength = 0;
        for(int i=0; i<arr.length; i++){
            if(!set.contains(arr[i]-1)){
                int length = 1;
                int nextEle = arr[i]+1;
                while(set.contains(nextEle)){
                    length++;
                    nextEle++;
                }
                maxLength = Math.max(maxLength,length);
            }
        }
        return maxLength;
    }
}
