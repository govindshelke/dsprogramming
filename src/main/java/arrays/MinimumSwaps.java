package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps {

    static class Pair{
        int oldIndex;
        int val;

        public Pair(int index, int val) {
            this.oldIndex = index;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,5,4};
        int result = countMinimumSwaps(arr);
        System.out.println("Result :"+result);
    }

    private static int countMinimumSwaps(int[] arr) {
        Pair[] inputPairs = new Pair[arr.length];
        for(int i=0; i<arr.length; i++){
            inputPairs[i] = new Pair(i,arr[i]);
        }
        Arrays.sort(inputPairs,(o1, o2) -> {
            return o1.val - o2.val;
        });
        boolean[] visited = new boolean[arr.length];
        int ans = 0;
        for(int i=0; i<inputPairs.length; i++){
            int nextIndex = inputPairs[i].oldIndex;
            if(visited[i] || nextIndex == i){
                continue;
            }

            int cycle = 0;
            while(!visited[nextIndex]){
                visited[nextIndex] = true;
                cycle++;
                nextIndex = inputPairs[nextIndex].oldIndex;
            }
            ans +=cycle-1;
        }
        return ans;
    }
}
