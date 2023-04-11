package Ex5_1;
import java.util.Scanner;

public class MotorBoatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);

		MotorBoat myBoat = new MotorBoat();

		System.out.println("Enter the Amount of fuel in the tank");

		double f = keyboard.nextDouble();

		myBoat.setf(f);

		System.out.println("Enter the Current speed");

		double s = keyboard.nextDouble();

		myBoat.sets(s);

		System.out.println("Enter the Efficiency of the boat's motor");

		double e = keyboard.nextDouble();

		myBoat.sete(e);

		System.out.println("Enter the time passed: ");

		int t = keyboard.nextInt();

		System.out.println("1. the amount of fuel used at the maximum and current speeds");

		myBoat.amountofFuel(t, myBoat.gets(), myBoat.gete());

		System.out.println("2. the travel distance at the maximum and current speeds");

		myBoat.travelDistanceGivenTime(t, myBoat.gets());

		System.out.println("3. the travel distance for current speed and fuel amount");

		myBoat.travelDistance(myBoat.gete(), myBoat.gets(), myBoat.getf());

		
		System.out.println("---------Boat2----------");
		
		MotorBoat myBoat2 = new MotorBoat();

		System.out.println("Enter the Amount of fuel in the tank");

		double f2 = keyboard.nextDouble();

		myBoat2.setf(f2);

		System.out.println("Enter the Current speed");

		double s2 = keyboard.nextDouble();

		myBoat2.sets(s2);

		System.out.println("Enter the Efficiency of the boat's motor");

		double e2 = keyboard.nextDouble();

		myBoat2.sete(e2);

		System.out.println("Enter the time passed: ");

		int t2 = keyboard.nextInt();

		System.out.println("1. the amount of fuel used at the maximum and current speeds");

		myBoat2.amountofFuel(t2, myBoat2.gets(), myBoat2.gete());

		System.out.println("2. the travel distance at the maximum and current speeds");

		myBoat2.travelDistanceGivenTime(t2, myBoat2.gets());

		System.out.println("3. the travel distance for current speed and fuel amount");

		myBoat.travelDistance(myBoat2.gete(), myBoat2.gets(), myBoat2.getf());
		
		if (myBoat.equals(myBoat2)) {
			System.out.println("Equal!!!!");
		}
		else {
			System.out.println("Not Equall!!!!");
		}
		
		keyboard.close();
	}

}
