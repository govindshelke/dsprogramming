package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        /*String str = "aabacbebebe";
        int k = 3;
        int size = longestSubString(str,k);
        System.out.println("Result: "+size);*/

        String str = "pwwkew";
        int result = lengthOfLongestSubstring(str);
        System.out.println("Result: "+result);

    }

    private static int lengthOfLongestSubstring(String str) {

        int i=0;
        int j=0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int max = 0;
        while(j<str.length()){
            //calculation
            char ch = str.charAt(j);
            if(freqMap.containsKey(ch)){
                freqMap.put(ch,freqMap.get(ch)+1);
            }else{
                freqMap.put(ch,1);
            }

            while(j-i+1 > freqMap.size()){
                char removechar = str.charAt(i);
                freqMap.put(removechar,freqMap.get(removechar)-1);
                if(freqMap.get(removechar) == 0){
                    freqMap.remove(removechar);
                }
                i++;
            }

            if(freqMap.size() == j-i+1){
                System.out.println(">>"+str.substring(i,j+1));
                max = Math.max(max,freqMap.size());
            }
            j++;
        }
        return max;
    }

    private static int longestSubString(String str, int k) {

        int i=0;
        int j=0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int max = 0;
        while(j<str.length()){
            //calculation
            char ch = str.charAt(j);
            if(freqMap.containsKey(ch)){
                freqMap.put(ch,freqMap.get(ch)+1);
            }else{
                freqMap.put(ch,1);
            }

            while(freqMap.size() > k){
                char removeChar = str.charAt(i);
                freqMap.put(removeChar,freqMap.get(removeChar)-1);
                if(freqMap.get(removeChar) == 0){
                   freqMap.remove(removeChar);
                }
                i++;
            }
            if(freqMap.size() == k){
                System.out.println(str.substring(i,j+1));
                max = Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }

}
