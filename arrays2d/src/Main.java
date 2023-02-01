import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

       int[][] arr = new int[2][2];
       Scanner sc = new Scanner(System.in);
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[i].length;j++){
               arr[i][j] = sc.nextInt();
           }
       }
       for(int[] a:arr){
           for(int i:a){
               System.out.print(i+" ");
           }
           System.out.println();
       }


    }
}