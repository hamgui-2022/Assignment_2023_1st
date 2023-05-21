package Ex12_1b;
import java.util.Scanner;

public class RecursiveToIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an integer:");
        Scanner keyboard = new Scanner(System.in);
        
        int number = keyboard.nextInt();
        
        System.out.println("The digits in that number are:");
        displayAsWords(number);
        System.out.println();
        
        System.out.println();
        keyboard.close();
	}
	
	public static void displayAsWords(int number) {

		int divisor = getPowerOfTen(number);
		int next = number;
		while (divisor >= 10)
		{
			System.out.print(getWordFromDigit(next / divisor) + " ");
			next = next % divisor;
			divisor = divisor / 10;
		}
		System.out.print(getWordFromDigit(next / divisor) + " ");
	}
	
	private static int getPowerOfTen(int n) {
		int result = 1;
		while (n >= 10)
		{
			result = result * 10;
			n = n / 10;
		}
		return result;
	}
	
	public static String getWordFromDigit(int digit) {
		String[] word = new String[] {
				"zero", "one", "two", "three", "four", 
				"five", "six", "seven", "eight", "nine"
		};
		
		return word[digit];
	}

}
