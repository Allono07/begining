import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int num = sc.nextInt();

        if(num<=1){
            flag = false;
        }
        for(int i =2;i<num/2;i++){
            if(num%i==0){
                flag = false;
                break;
            }
        }
        if(flag==true){
            System.out.println("Entered number is a prime number");
        }
        else {
            System.out.println("Entered number is not a prime number");
        }

    }
}