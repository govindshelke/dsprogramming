package strings;


import java.util.ArrayList;
import java.util.List;

public class Tokenisation {
    static String input = null;
    public static void main(String[] args) {
        String str = "I like the movie acting in the movie was great";
        String token = myStrTok(str,' ');
        System.out.println("Token :"+token);
        while(token != null){
            System.out.println("Token :"+token);
            token = myStrTok(null,' ');
        }
    }

    private static String myStrTok(String str, char deli) {

        if(str != null){
            input = str;
        }
        if(input == null){
            return null;
        }
        int i=0;
        char[] charArr = new char[input.length()+1];
        String token = null;
        while(i<input.length()){
            if(input.charAt(i) != deli){
                charArr[i] = input.charAt(i);
            }else{
                token = new String(charArr);
                input = input.substring(i+1);
                break;
            }
            i++;
        }
        input = null;
        return token;
    }
}
