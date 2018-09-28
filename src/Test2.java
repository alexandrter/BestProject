import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test2 {


    public static void main(String[] args) {

//        long startTime = System.nanoTime();
//
//        int[] a = rndArray();
//        System.out.println(Solution4.solution(a));
//
//        long endTime = System.nanoTime();
//        System.out.println("time needed: " + TimeUnit.SECONDS.toSeconds(endTime - startTime));

        int n = 5;

        int [][] matrix =  getMatrix(n);

        System.out.println( "Solution 2 for loops took  "  + getAverageSolutionTime(matrix, new Solution2()) + " mikroseconds");
        System.out.println( "Solution TreeSet via for  "  + getAverageSolutionTime(matrix, new Solution3()) + " mikroseconds");
        System.out.println( "Solution int[] + mergeSort "  + getAverageSolutionTime(matrix, new Solution4()) + " mikroseconds");
        System.out.println( "Solution TreeSet via stream "  + getAverageSolutionTime(matrix, new Solution5()) + " mikroseconds");
        System.out.println( "Solution int [] + QuickSort "  + getAverageSolutionTime(matrix, new Solution6()) + " mikroseconds");
        System.out.println( "Solution from Elena "  + getAverageSolutionTime(matrix, new Solution7()) + " mikroseconds");
    }



    public static int[] rndArray(){
        //int arr [] = new int[(int)((Math.random()*1100000)+1)];
        int arr [] = new int[1100000];

        for (int i = 0; i< arr.length; i++){
            arr[i]= (int)((Math.random()-0.5)*2000000);
            //System.out.println(arr[i]+ " ");
        }
        return arr;
    }

    public static int[][] getMatrix(int n){

        int [][]matrix = new int [n][];

        for(int i = 0; i < n; i++){
            matrix[i] = rndArray();
        }

        return matrix;
    }

    public static long getAverageSolutionTime (int [][]matrix, SolutionAbstract sol){

        long timeSum = 0;
        long tempTime = 0;

        for(int i = 0; i < matrix.length; i++){

            tempTime= System.nanoTime();

           sol.solution(matrix[i]);

            timeSum += System.nanoTime()-tempTime;
        }


        return (timeSum/matrix.length)-(timeSum/matrix.length)%1000;
    }



}


