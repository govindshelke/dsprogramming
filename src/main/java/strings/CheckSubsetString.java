package strings;

public class CheckSubsetString {
    public static void main(String[] args) {
        String str = "I like the movie acting in the movie was great";
        String subStr = "Iltmaitmwg";
        boolean result = isSubSet(str,subStr);
        System.out.println("Result :"+result);
    }

    //(O(N))
    private static boolean isSubSet(String str, String subStr) {
        int i=0;
        int j=0;

        while(i<str.length() && j<subStr.length()){
            if(str.charAt(i) == subStr.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == subStr.length();
    }
}
