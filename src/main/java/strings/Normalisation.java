package strings;

public class Normalisation {
    public static void main(String[] args) {
        String str= "This is so MuCH FUN! f ?";
        String result = normalise(str);
        System.out.println(result);
    }

    private static String normalise(String str) {
        char[] arr = str.toCharArray();

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] == ' '){
                arr[i] = Character.toUpperCase(arr[i]);
            }else{
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr);
    }
}
