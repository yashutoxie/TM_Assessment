class Main {
	public static void main(String[] args)
	{
		int a[] = {8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, };
		int n = a.length;
		int max = Integer.MIN_VALUE;
		for(int i =0; i < n; i++) {
		    if(a[i] > max){
		        max = a[i];
		    }
		}
		    System.out.print(max);
	}

}

/* 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12*/
