package Ex12_3;
import java.util.Scanner;

public class FibonacciDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to calculate: ");
        int num = keyboard.nextInt();

        long prev = 0;
        long curr = 0;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                curr = Fibonacci.fibonacci(i);
                System.out.println("Fibonacci #1 = 0");
            } else if (i == 2) {
                prev = curr;
                curr = Fibonacci.fibonacci(i);
                System.out.println("Fibonacci #2 = 1");
            } else {
                prev = Fibonacci.fibonacci(i - 2);
                curr = Fibonacci.fibonacci(i - 1);
                System.out.printf("Fibonacci #%d = %d; %d/%d = %.1f\n", i, curr, curr, prev, (float) curr / prev);
            }
        }
        
        keyboard.close();
	}

}
