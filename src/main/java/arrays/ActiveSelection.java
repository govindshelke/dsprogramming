package arrays;

import java.util.Arrays;

public class ActiveSelection {
    public static void main(String[] args) {
        /*int[][] input = new int[][]{{7,9},{0,10},{4,5},{8,9},{4,10},{5,7}};
        int result = maxActivities(input);
        System.out.println("Result :"+result);
*/
        long[][] input = new long[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
       // int[][] input = new int[][]{{-1,-5},{1,2}};
        int result = findMinArrowShots(input);
        System.out.println("Result :"+result);
    }

    private static int maxActivities(int[][] input) {
        Activity[] list = new Activity[input.length];
        for(int i=0; i<input.length; i++){
            list[i] = new Activity(input[i][0],input[i][1]);
        }

        Arrays.sort(list,(a,b)->{
            return a.end - b.end;
        });

        int count = 1;
        for(int i=1; i<list.length; i++){
            if(list[i].start>= list[i-1].end){
                count++;
            }
        }
        System.out.println(Arrays.toString(list));
        return count;
    }

    static class Activity{
        int start;
        int end;

        Activity(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public String toString() {
            return "{" +
                    + start +
                    ","+ end +
                    '}';
        }
    }

    static class Ballon{
        long start;
        long end;

        Ballon(long s, long e){
            this.start = s;
            this.end = e;
        }
    }
        public static int findMinArrowShots(long[][] points) {

            Ballon[] ballons = new Ballon[points.length];

            for(int i=0; i<points.length; i++){
                ballons[i] = new Ballon(points[i][0],points[i][1]);
            }

            Arrays.sort(ballons,(a,b)->{
                return (int) (a.end - b.end);
            });

            int count = 1;
            Ballon prevBallon = ballons[0];
            for(int i=1; i<ballons.length; i++){
                if(prevBallon.end >= ballons[i].start){

                }else{
                    count++;
                    prevBallon = ballons[i];
                }

            }
            return count;

        }

    }
