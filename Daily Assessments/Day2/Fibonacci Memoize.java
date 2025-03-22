import java.util.*;
public class Main
{
	static HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
	public static void main(String[] args) {
		int n = 6;
		long res = fib(n);
		System.out.println(res);

	}

	private static long fib(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1; 
		if(memo.containsKey(n))
			return memo.get(n);

		long res = fib(n - 1) + fib(n - 2);
		memo.put(n, res);
		return res;


	}
} 
