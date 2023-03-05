package exercise2;

import java.util.Scanner;

public class Recursive2 {

	String s;
	
	
	Recursive2(String s){
		this.s = s;
	}
	
	static boolean isPalindrome (String s){
		 if (s.length() <= 1) {   // base case 
	            return true;
	        } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
	            return isPalindrome(s.substring(1, s.length() - 1));
	        } else {
	            return false;
	        }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string to check for palindrome: ");
	        String s = scanner.nextLine();
	        boolean isPalindrome = isPalindrome(s);
	        if (isPalindrome) {
	            System.out.println(s + " is a palindrome.");
	        } else {
	            System.out.println(s + " is not a palindrome.");
	        }
	}
}

