package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        String str = "aabaabaa";
        String pattern = "aaba";
        int count = countAnagrams(str,pattern);
        System.out.println(count);
    }

    private static int countAnagrams(String str, String pattern) {
        char[] arr = str.toCharArray();
        int k = pattern.length();
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        int i=0;
        int j=0;
        int count = freqMap.size();
        int ans = 0;
        while(j<arr.length){
            //calculations
            if(freqMap.containsKey(arr[j])){
                freqMap.put(arr[j],freqMap.get(arr[j])-1);
                if(freqMap.get(arr[j]) == 0){
                    count--;
                }
            }
            //meet window condition
            if(j-i+1 == k){
                // find ans
                if(count == 0){
                    ans++;
                }
                //slide the window
                if(freqMap.containsKey(arr[i])){
                    freqMap.put(arr[i],freqMap.get(arr[i])+1);

                    if(freqMap.get(arr[i]) == 1){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }

}
