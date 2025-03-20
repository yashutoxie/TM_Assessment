class Main
{
	public static void main(String args[])
	{
		int[] a = {7, 9, 5, 2, 8, 7};
		int n = a.length;
		int l = 0, r = n - 1;
		while(l <= r) {
			int tmp = a[l];
			a[l] = a[r];
			a[r] = tmp;
			l++;
			r--;
		}
		for(int i = 0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
	}
}

/* 7, 8, 2, 5, 9, 7 */
