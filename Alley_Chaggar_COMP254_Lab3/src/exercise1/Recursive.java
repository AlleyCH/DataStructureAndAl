package exercise1;

public class Recursive {

	int number1;
	int number2;
	
	Recursive(int m, int n ){
		number1 = m;
		number2 = n;
	}
	
	static int getProduct(int m , int n){
		
		if (m == 0 || n == 0) { // If an int is zero the product will be zero 
			return 0; // returns 0
		}
	    if (n == 1){ // Anything timed by 1 is it's self
	        return m;
	    }
	    if (m == 1){ // Anything timed by 1 is it's self
	        return n;
	    }      
	    else {
	       return m + getProduct(m, n - 1); // 
	    }
		
	}
	
	//getProduct(1,2)  2
	//getProduct(2,3)  2+2+2
	//getProduct(2,4)  2+2+2+2
	//getProduct(2,5)  2+getProduct(2,4)
	
	//return m+getProduct(m,n-1)
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int m = 5;
	        int n = 4;
	        int product = getProduct(m, n);
	        System.out.println("Product of " + m + " and " + n + " is " + product);
	}

}
