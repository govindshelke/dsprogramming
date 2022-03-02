package strings;

public class FindAll {
    public static void main(String[] args) {
        String str = "I like the movie, acting in the movie was great, movie was good";
        String word = "movie";
        findAllOccuranc(str,word);
    }

    private static void findAllOccuranc(String str, String word) {
        int index = str.indexOf(word);
        if(index == -1){
            System.out.println("String not found");
            return;
        }
        int i=1;
        do{
            System.out.println(i+" Occurance :"+index);
            i++;
            index = str.indexOf(word,index+1);
        }while(index != -1);
    }
}
