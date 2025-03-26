class Main {
	public static void main(String[] args)
	{
		int[] a  = {1, 0, 1, 0, 0};
		int n = a.length;
		int l = 0, r = n - 1;
		while(l < r) {
			while(l < r && a[l] == 0) {
				l++;
			}
			while(l < r && a[r] == 1) {
				r--;
			}
			if(l < r) {
				int tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
				l++;
				r--;
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
