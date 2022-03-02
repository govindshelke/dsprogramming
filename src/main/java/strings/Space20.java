package strings;

public class Space20 {

    public static void main(String[] args) {
        String str = "I like the movie acting in the movie was great";
        String newStr = replaceSpaces(str);
        System.out.println("REsult :"+newStr);
    }

    private static String replaceSpaces(String str) {
        int spaceIndex = str.indexOf(" ");
        if(spaceIndex == -1){
            return str;
        }

        int count=0;
        while(spaceIndex != -1){
            count++;
            spaceIndex = str.indexOf(" ",spaceIndex+1);
        }
        int n = str.length();
        char[] result = new char[n+2*count];
        int i = n-1;
        int j = result.length-1;
        while(i>=0){
            if(str.charAt(i) ==' '){
                result[j] = '0';
                result[j-1] = '2';
                result[j-2] = '%';
                j = j -3;
            }else{
                result[j] = str.charAt(i);
               j--;
            }
            i--;
        }

        return new String(result);
    }
}
