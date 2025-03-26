// Dutch National Flag Algorithm
class Main { 
    public static void main(String[] args)
    {
        int a[] = {2, 0, 2, 1, 1, 0};
        int l = 0, h = a.length - 1, mid = 0;
        while(mid <= h){
            if(a[mid] == 0) {
            swap(a, mid, l);
            l++;
            mid++;
        } else if(a[mid] == 1){
            mid++;
        } else{
            swap(a, mid, h);
            h--;
        }
        
    }
    for (int i = 0; i < a.length ; i++){
        System.out.print(a[i]+" ");
    } 
    }
    
    private static void swap(int[] a, int l, int h){
        int tmp = a[l];
        a[l] = a[h];
        a[h] = tmp;
        l++;
        h--;
    }
}
