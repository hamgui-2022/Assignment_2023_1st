package Ex5_10;

public class Movie {
	private String name;
	private String MPAA;
	private int rate1; private int rate2; private int rate3;
	private int rate4; private int rate5;
	
	public String getName() {
		return name;
	}
	public void setName(String movName) {
		this.name = String.valueOf(movName);
	}
	
	public String getMPAA() {
		return MPAA;
	}
	public void setMPAA(String movRate) {
		this.MPAA = String.valueOf(movRate);
	}
	
	public void addRating(int newRate) {
		switch (newRate) {
		case 1:
			this.rate1++;
			break;
		case 2:
			this.rate2++;
			break;
		case 3:
			this.rate3++;
			break;
		case 4:
			this.rate4++;
			break;
		case 5:
			this.rate5++;
			break;
		}
	}
	
	public int getAverage() {
		int total = this.rate1 * 1 + this.rate2 * 2 + this.rate3 * 3 + this.rate4 * 4 + this.rate5 * 5;
		return total / (this.rate1 + this.rate2 + this.rate3 + this.rate4 + this.rate5);
	}
	

	
	public boolean equals(Movie otherObject) {
		return (this.name.equalsIgnoreCase(otherObject.name)) &&
				(this.MPAA.equalsIgnoreCase(otherObject.MPAA)) &&
				(this.getAverage() 
						== 
				otherObject.getAverage());
	}
	
}
