import java.util.*;

public class Main {
	public static void main(String[] args) {
		String str = "AABAACAADAABAABA";
		String pattern = "AABA";
		findPattern(str, pattern);
	}

	private static void findPattern(String str, String pattern) {
		int mainLen = str.length();
		int subLen = pattern.length();
		boolean flag = false;

		for (int i = 0; i <= mainLen - subLen; i++) {
			int j;

			for (j = 0; j < subLen; j++) {
				if (str.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}

			if (j == subLen) {
				System.out.println(pattern+" found at index: " + i + " end at index: "+ (i +  subLen - 1)  );
				flag = true;
			}
		}
		if(flag == false) {
			System.out.println("Pattern not matching.");
		}
	}
}
