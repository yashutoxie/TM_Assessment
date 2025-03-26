import java.util.HashMap;

public class Fibonacci {
	static HashMap<Integer, Long> memo = new HashMap<Integer, Long>();

   	private static long fibo(int n) {
   		
		// TODO Auto-generated method stub
		if(n<=1)return n;
		
		if(memo.containsKey(n))
			return memo.get(n);
		
		long result=fib(n-1)+fib(n-2);
		memo.put(n, result);
				
		return result;
	}
	 public static void main(String[] args) {
	       
	    	int n=5;
	    	n=n+1;
	    	long res=fibo(n);
	    	System.out.println(res);
	    	
	    	
	    }
}
