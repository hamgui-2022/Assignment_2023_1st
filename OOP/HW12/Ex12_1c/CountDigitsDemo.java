package Ex12_1c;

public class CountDigitsDemo {
	static int count = 0;
	public static int countDigits(String s) {
		if (s.isEmpty()) {
			int cDigit = CountDigitsDemo.count;
			CountDigitsDemo.count = 0;
			return cDigit;
		}
		
		if(Character.isDigit(s.charAt(0))) {
			CountDigitsDemo.count += 1;
		}
		
		return countDigits(s.substring(1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDigits("010-2067-3534"));
		
		System.out.println(countDigits("Hello-JH107"));
	}

}
