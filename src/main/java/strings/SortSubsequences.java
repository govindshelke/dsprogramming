package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortSubsequences {
    public static void main(String[] args) {
        String str = "abcd";
        List<String> subsets = sortedSubsets(str);
        System.out.println("Result :"+ subsets);
    }

    private static List<String> sortedSubsets(String str) {
        List<String> subsets = new ArrayList<>();
        String output = "";
        subsequences(str,output,subsets);
        Collections.sort(subsets,(a,b)->{
            if(a.length() == b.length()){
                return a.compareTo(b);
            }else{
                return a.length() - b.length();
            }
        });
        System.out.println(subsets);
        return subsets;
    }

    private static void subsequences(String str, String output, List<String> subsets) {
        if(str.length() == 0){
            subsets.add(output);
            return;
        }
        char ch = str.charAt(0);
        String reducedInput = str.substring(1);
        subsequences(reducedInput,output+ch,subsets);
        subsequences(reducedInput,output,subsets);
    }
}
