package Ex12_1d;
import java.util.Scanner;

public class CheckPalindrome {
	public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a string or enter exit to complete : ");
            String str = keyboard.nextLine();

            // when user enters exit , then we break the loop
            if (str.equals("exit"))
                break;

            String strPreprocessed = preprocessString(str);
            
            if (isPalindrome(strPreprocessed))
                System.out.println(str + " is a palindrome .");
            else
                System.out.println(str + " is not a palindrome .");
        }
        
        keyboard.close();
    }
	
	// Function to preprocess the string
    static String preprocessString(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("\\s", ""); // removes whitespaces
        str = str.replaceAll("\\p{Punct}", ""); // removes punctuation
        return str;
    }

    // Recursive function to check if a string is a palindrome
    static boolean isPalindrome(String str) {
        if (str.length() <= 1)
            return true;

        if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;

        return isPalindrome(str.substring(1, str.length() - 1));
    }
}
