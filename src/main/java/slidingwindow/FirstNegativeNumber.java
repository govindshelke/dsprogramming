package slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        firstNegativeNumbers(arr,k);
    }

    private static void firstNegativeNumbers(int[] arr, int k) {

        int i=0;
        int j=0;
        List<Integer> negativeList = new LinkedList<>();
        while(j<arr.length){
            if(arr[j]<0){
                negativeList.add(arr[j]);
            }
            if(j-i+1 == k){
                if(negativeList.size() == 0){
                    System.out.print(0+" ");
                }else{
                    System.out.print(negativeList.get(0)+" ");
                    if(arr[i] == negativeList.get(0)){
                        negativeList.remove(0);
                    }
                }
                i++;
            }
            j++;
        }
    }
}
