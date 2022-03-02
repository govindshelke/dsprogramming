package strings;

import java.text.DecimalFormat;

public class DigitalClock {
    public static void main(String[] args) {
        int time = 1141;
        String digitalTime = convertToDigitalTime(time);
        System.out.println("Digital Time :"+digitalTime);
    }

    private static String convertToDigitalTime(int time) {

        int hr = time/60;
        int min = time%60;
        String hrStr = String.valueOf(hr);
        DecimalFormat format = new DecimalFormat("00");
        String minStr = format.format(min);
        return hrStr+":"+minStr;
    }
}
