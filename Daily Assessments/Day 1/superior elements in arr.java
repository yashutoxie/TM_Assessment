/*Superior elements

Problem statement

In an array, a superior element is one that is greater than all elements to its right. The rightmost element will always be considered as a superior element. You are given a function,

Int findnumberofsuperiorelements(int* arr, int n);

The function accepts an integer array ‘arr’ and its length ‘n’. Implement the function to find and return the number of superior elements in array ‘arr’.

Example

Input

5

7 9 5 2 8 7

Output

3

Explanation

9 is greater than all the elements to its right, 8 is greater than the element to its right, and 7 is the rightmost element. Hence total 3 superior elements.
*/
class Main
{
	static int findSuperiorEle(int arr[], int n)
	{
		int c = 1, j ;
		for(int i = n-2 ; i>=0 ; i--)
		{
			for(j = i+1 ; j<n ; j++)
			{
				if(arr[i]<=arr[j]) break ;
			}
			if(j==n) c++ ;
		}
		return c;
	}

	public static void main(String args[])
	{
		int[] a = {7, 9, 5, 2, 8, 7};
		int n = a.length; 
		System.out.print(findSuperiorEle(a, n));
	}
}

/* Output: 3 */
