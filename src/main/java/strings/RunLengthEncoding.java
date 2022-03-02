package strings;

import java.util.Arrays;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String str = "oooooooooo";
        String encodedStr = encode(str);
        System.out.println("Encoded :"+encodedStr);

        compress(str.toCharArray());
    }

    private static String encode(String str) {

        char[] output = new char[str.length()];
        int index = -1;
        int i=0;
        int j =0;

        while(j<str.length()){
            int cnt = 0;
            char ch = str.charAt(j);
            output[++index] = ch;
            while(j<str.length() && str.charAt(j) == str.charAt(i)){
                cnt++;
                j++;
            }
            if(cnt>1){
                output[++index] = Character.forDigit(cnt,10);
            }
            i=j;
        }

        return new String(output).trim();
    }

    public static int compress(char[] chars) {

        int i=0;
        int j=0;
        int index = -1;

        while(j<chars.length){
            int cnt = 0;
            char ch = chars[j];
            chars[++index] = ch;
            while(j<chars.length && chars[j] == chars[i]){
                cnt++;
                j++;
            }

            if(cnt>1 && cnt<10){
                chars[++index] = Character.forDigit(cnt,10);
            }
            if(cnt>=10){
                chars[++index] = Character.forDigit((cnt/10),10);
                chars[++index] = Character.forDigit((cnt%10),10);
            }

            System.out.println(Arrays.toString(chars));
            System.out.println("Len:"+(index+1));
            i=j;
        }
        return index+1;

    }
}
