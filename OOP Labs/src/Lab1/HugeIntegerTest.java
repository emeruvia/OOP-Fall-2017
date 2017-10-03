package Lab1;

// Test Driver for HugeInteger
public class HugeIntegerTest {
	public static void main(String args[]){
		String [][] testInputs = {
			{"987654321", "234567890"},
			{"987654321", "-234567890"},
			{"-987654321", "234567890"},
			{"-987654321", "-234567890"},
			{"234567890", "987654321"},
			{"234567890", "-987654321"},
			{"-234567890", "987654321"},
			{"-234567890", "-987654321"}
		};

		for(String [] ints : testInputs){
			HugeInteger h1 = new HugeInteger(ints[0]);
			HugeInteger h2 = new HugeInteger(ints[1]);

			System.out.println("h1="+h1);
			System.out.println("h2="+h2);
			if(h1.isEqualTo(h2)){
				System.out.println("h1 is equal to h2.");
			}
			if(h1.isNotEqualTo(h2)){
				System.out.println("h1 is not equal to h2.");
			}
			if(h1.isGreaterThan(h2)){
				System.out.println("h1 is greater than h2.");
			}
			if(h1.isLessThan(h2)){
				System.out.println("h1 is less than to h2.");
			}
			if(h1.isGreaterThanOrEqualTo(h2)){
				System.out.println("h1 is greater than or equal to h2.");
			}
			if(h1.isLessThanOrEqualTo(h2)){
				System.out.println("h1 is less than or equal to h2.");
			}
			h1.add(h2); // h1 += h2
			System.out.println("h1.add(h2);");
			System.out.printf("h1=%s\n",h1);

			h1.subtract(h2); // h1 -= h2
			System.out.println("h1.subtract(h2);");
			h1.subtract(h2); // h1 -= h2
			System.out.println("h1.subtract(h2);");
			System.out.printf("h1=%s\n",h1);
			
			h1.add(h2); // h1 += h2
			System.out.println("h1.add(h2);");
			h1.multiply(h2); // h1 *= h2
			System.out.println("h1.multiply(h2);");
			System.out.printf("h1=%s\n\n",h1);
		}
	}
	
	private static int[] multiplyDigitsArray(int[] arr1, int indexPosition) {
		int length = arr1.length + 1;
		int[] resultant = new int[length];
		int carryOver = 0;
		int j = arr1.length - 1;
		
		for (int i = length - 1; i >= 0; i--) {
			resultant[i] = (arr1[j] * indexPosition) + carryOver;
			carryOver = 0;
			if (resultant[i] > 9) {
				while (resultant[i] > 9) {
					resultant[i] -= 10;
					carryOver++;
				}
			}
			if (j == 0) {
				resultant[i - 1] = carryOver;
				break;
			}
			j--;
		}
		return resultant;
	}
	
}


