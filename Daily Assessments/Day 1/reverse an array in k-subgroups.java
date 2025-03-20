class Main {
	public static void main(String[] args)
	{
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int n = a.length;
		int k = 7;
		for(int i =0; i < n; i+=k) {
			int l = i, r;
			if(i + k - 1 < n - 1) r = i + k - 1;
			else r = n - 1;
			while(l <= r) {
				int tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
				l++;
				r--;
			}
		}
		for(int i =0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
	}

}

/* Ouput: 7 6 5 4 3 2 1 12 11 10 9 8 */
