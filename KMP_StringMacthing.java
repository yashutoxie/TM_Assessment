import java.util.*;

public class Main {
	public static void main(String[] args) {
		String text = "AABAACAADAABAABA";
		String pattern = "AABA";
		KMPSearch(text, pattern);
	}

	private static void KMPSearch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int[] lps = computeLPSArray(pattern);

		int i = 0, j = 0;

		while(i < n) {
			//if text and pattern matches inc i, j.
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}

			// if len of Pattern and idx of Pattern matches, print pattern found
			// change the idx pos to lps[j - 1].
			if(j == m) {
				System.out.println("Pattern found at index: "+ (i - j));
				j = lps[j - 1];
			}
// 			when idx of txt < len of txt and charAt i, charAt j is not equal.
//          idx of pattern is chnaged(positioned) to lps[j - 1]; else inc i.
			else if(i < n && text.charAt(i) != pattern.charAt(j)) {
				if( j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

	}

	private static int[] computeLPSArray(String pattern) {
		int n = pattern.length();
		int[] lps = new int[n];
		int len = 0, i = 1;

		while(i < n) {
			//  if charAt pattern at i and charAt j of pattern is equal.
			// inc idx of pattern & lps[i] = len, i++;
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if(len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
}
