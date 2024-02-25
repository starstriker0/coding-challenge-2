import java.util.Scanner;

import javax.swing.JOptionPane;

public class Coding_Challenge_2 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Scanner input = new Scanner(System.in);
		
		

		System.out.print("Number: ");
		long num = 0;
		try {
			num = input.nextLong();
		} catch (Exception e) {
			quit();
		}
//		long num = 4003600000000014L;
		long num3 = num;
		
		
//		prep variables
		int brand = 0;
		String brand2 = "";
		String num2 = num + "";
		int l = num2.length();
		int d = 0;
		long digit = 0;

		
		
		
//		checks the brand
		digit = num;
	    while (digit > 9) {
	        digit /= 10;
	    }	    
	    switch((int)digit) {
	    case 3:brand = 1;d = 100;brand2 = "American Express"; break;
	    case 4:brand = 2;d = 10;brand2 = "VISA"; break;
	    case 5:brand = 3;d = 100;brand2 = "MasterCard"; break;
	    default:quit(); break;
	    }
	    	
//	    checks if the first digit  and the amount of digits in the credit card number 
//	    matches the number of digits that are supposed to be in the credit card number
	    if(brand == 1 && (l != 15))
	    	quit();
	    else if(brand == 2 && !(l > 13) && (l < 16))
		    quit();
	    else if(brand == 3 && (l != 16))
	    	quit();
	    
		
		
		int s1 = 0;
		int s2 = 0;
		
//retrieves every other didgt, multiplies them by 2 and adds them together
		for(long x =(long) (Math.pow(10, l-1)+1); x > 10; x++) {
			x--;
			long a = ((num / x ) % 10)*2;
			while(a > 0)  {  
			s1 += (int) (a%10);
			a= a / 10;
			}
			x= x /100;
		}
		
//gets the digits that weren't multiplied and added and adds thoe together
		for(long x =(long) (Math.pow(10, l-2)+1); x >= 2; x++) {
			x--;
			long a = ((num / x ) % 10);
			s2 += (int) (a);
			x= x /100;
		}
//adds numbers together and does one final check to see if they add up to a number with a 0 in the first digit
		if (((s1 + s2)%10) == 0)
		System.out.println(brand2);
		else
			quit();

		
		
//sample output
//		Number: 4003600004000014
//		invalid card number
		
//		Number: 4003600000000014
//		VISA

		
		

	}
	
//	method to end the program on an error
	public static void quit() {
	System.out.println("invalid card number");
    System.exit(1);

	}
	

}
