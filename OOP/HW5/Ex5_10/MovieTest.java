package Ex5_10;
import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Movie mov1 = new Movie();
		
		System.out.print("name of movie1: ");
		String movName = keyboard.nextLine();
		mov1.setName(movName);
		System.out.printf("name: %s\n", mov1.getName());
		
		System.out.print("MPAA grade of the movie: ");
		String movRate = keyboard.nextLine();
		mov1.setMPAA(movRate);
		System.out.printf("MPAA: %s\n", mov1.getMPAA());
		for (int i = 0; i < 5; i++) {
			System.out.print("rate: ");
			int rate = keyboard.nextInt();
			mov1.addRating(rate);
		}
		
		System.out.printf("Movie 1 Average rating: %d\n", mov1.getAverage());

		System.out.println("");
		
		keyboard.nextLine();
		
		Movie mov2 = new Movie();

		System.out.print("name of movie2: ");
		String mov2Name = keyboard.nextLine();
		mov2.setName(mov2Name);
		System.out.printf("name: %s\n", mov2.getName());
		
		System.out.print("MPAA grade of the movie: ");
		String mov2Rate = keyboard.nextLine();
		mov2.setMPAA(mov2Rate);
		System.out.printf("MPAA: %s\n", mov2.getMPAA());
		for (int i = 0; i < 5; i++) {
			System.out.print("rate: ");
			int rate = keyboard.nextInt();
			mov2.addRating(rate);
		}
		
		System.out.printf("Movie 2 Average rating: %d\n", mov2.getAverage());
		
		System.out.printf("Equals of two movies: ");
		if (mov1.equals(mov2)) {
			System.out.printf("Equal!!!!!\n");
		}
		else {
			System.out.printf("Not Equal!!!!!\n");
		}
		
		keyboard.close();
	}

}
