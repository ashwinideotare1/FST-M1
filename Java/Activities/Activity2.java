package activities;

public class Activity2 {

	public static void main(String[] args) {
	
	//Initialize an array with 6 number: [10, 77, 10, 54, -11, 10]
		int[] sample = {10, 6, 10, 70, 10, -90};
		verifySum(sample);
					
	}
	
	public static boolean verifySum(int[] sampleArray) {
		int sum=0;
		
		//Find the 10's in the array and add them
			for(int i=0; i<sampleArray.length; i++) {
				if(sampleArray[i]==10) {
					sum= sampleArray[i]+sum;
					System.out.println("Sum is "+sum);
				}
			}
			if(sum==30) {
				System.out.println("Condition is satisfied");
				return true;
			}else {
				System.out.println("Condition is not satisfied");
				return false;
			}
	}
}
