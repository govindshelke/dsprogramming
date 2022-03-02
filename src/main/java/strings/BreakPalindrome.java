package strings;

public class BreakPalindrome {

    public static void main(String[] args) {
        String str = "ab";
        String result = breakPalindrome(str);
        System.out.println("Result :"+result);
    }

    private static String breakPalindrome(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        for(int i=0; i<n; i++){
            if(n%2!=0 && i==n/2){
                continue;
            }
            if(chars[i] != 'a'){
                chars[i] = 'a';
                return new String(chars);
            }
            if(i == n-1){
                chars[i] = 'b';
                return new String(chars);
            }
        }
        return "";
    }
}
