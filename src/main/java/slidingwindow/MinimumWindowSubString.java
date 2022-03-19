package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        String str = "a";
        String subStr= "a";
        String result = minWindow(str,subStr);
        System.out.println("Result: "+result);
    }
    public static String minWindow(String s, String t) {

        Map<Character,Integer> freqMap = new HashMap<>();

        for(char ch : t.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

            int count = freqMap.size();

            int i=0;
            int j=0;
            int min = Integer.MAX_VALUE;
            String result = "";

            while(j<s.length()){
                char ch = s.charAt(j);

                if(freqMap.containsKey(ch)){
                    freqMap.put(ch,freqMap.get(ch)-1);
                    if(freqMap.get(ch) == 0){
                        count--;
                    }
                }

                while(count ==0){
                    if((j-i+1)<min){
                        result = s.substring(i,j+1);
                        min = j-i+1;
                    }

                    char removeChar = s.charAt(i);
                    if(freqMap.containsKey(removeChar)){
                        freqMap.put(removeChar,freqMap.get(removeChar)+1);
                        if(freqMap.get(removeChar) == 1){
                            count++;
                        }
                    }
                    i++;
                }

                j++;
            }
            return result;
        }

    private static int minimumWindowSubStr(String str,String subStr) {
        Map<Character,Integer> freqMap = new HashMap<>();

        for(Character ch : subStr.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        int i=0;
        int j=0;
        int count = freqMap.size();
        int min = Integer.MAX_VALUE;

        while(j<str.length()){
            // calculation
            Character ch = str.charAt(j);
            if(freqMap.containsKey(ch)){
                freqMap.put(ch,freqMap.get(ch)-1);
                if(freqMap.get(ch) == 0){
                    count--;
                }
            }

            while(count == 0){
                System.out.println("Sub String :"+str.substring(i,j+1));
                min = Math.min(min,(j-i+1));

                char removeCh = str.charAt(i);
                if(freqMap.containsKey(removeCh)){
                    freqMap.put(removeCh,freqMap.get(removeCh)+1);
                    if(freqMap.get(removeCh) == 1){
                        count++;
                    }
                }
                i++;
            }

            j++;
        }
        return min;
    }
}
