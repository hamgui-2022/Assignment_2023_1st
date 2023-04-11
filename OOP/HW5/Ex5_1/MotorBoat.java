package Ex5_1;

public class MotorBoat {
	public static final double tankCapacity = 60.0; // Capacity

	private double f; // Amount
	public static final double maxSpeed = 50.0; // Maximum speed
	private double s; // current speed
	private double e; // efficiency of the boat's motor
	
	public double getf() {
		return f;
	}

	public void setf(double f) {
		if (tankCapacity < f) {
			System.out.println("Wrong fuel amount(much than capacity)");
			this.f = 0;
		}
		else if (f < 0) {
			System.out.println("Wrong fuel amount(negative value)");
			this.f = 0;
		}
		else {
			this.f = f;
		}
		return;
	}

	public double gets() {
		return this.s;
	}

	public void sets(double s) {
		if (maxSpeed < s) {
			System.out.println("Wrong speed(faster than maxSpeed)");
			this.s = 0;
		}
		else if (s < 0) {
			System.out.println("Wrong speed(negative value)");
			this.s = 0;
		}
		else {
			this.s = s;
		}
	}

	public double gete() {
		return e;
	}

	public void sete(double e) {
		if (e < 0) {
			System.out.println("Wrong efficiency(negative value)");
			this.e = 0;
		}
		else {
			this.e = e;
		}
	}

	public void amountofFuel(int t, double s, double e) { // given time
		double amountMax = e * maxSpeed * maxSpeed * t;
		System.out.println("The amount of fuel at the maximum speed: " + amountMax);
		double amountCurr = e * s * s * t;
		System.out.println("The amount of fuel at the current speed: " + amountCurr);
	}

	public void travelDistanceGivenTime(int t, double s) { // given time
		double distanceMax = maxSpeed * t;
		System.out.println("The travel distance at the maximum speed: " + distanceMax);
		double distanceCurr = s * t;
		System.out.println("The travel distance at the current speed: " + distanceCurr);
	}

	public void travelDistance(double e, double s, double f) {
		double distance = (double) f / e / s;
		System.out.println("The travel distance: " + distance);
	}

	public boolean equals(MotorBoat otherMotorBoat) {
		return ((this.e == otherMotorBoat.e) &&
				(this.f == otherMotorBoat.f) &&
				(this.s == otherMotorBoat.f));
	}
}
