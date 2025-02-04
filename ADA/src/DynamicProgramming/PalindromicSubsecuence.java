package DynamicProgramming;

public class PalindromicSubsecuence {

	// Function to find the length of Longest Palindromic Subsequence
		// of substring X[i..j]
		public static int longestPalindrome(String X, int i, int j)
		{
			// base condition
			if (i > j) {
				return 0;
			}

			// if String X has only one character, it is palindrome
			if (i == j) {
				return 1;
			}

			// if last character of the string is same as the first character
			if (X.charAt(i) == X.charAt(j))
			{
				// include first and last characters in palindrome
				// and recur for the remaining substring X[i+1, j-1]
				return longestPalindrome(X, i + 1, j - 1) + 2;
			}

			// if last character of string is different to the first character

			// return maximum of -
			// 1. Remove last character & recur for the remaining
			// substring X[i, j-1]
			// 2. Remove first character & recur for the remaining
			// substring X[i+1, j]
			return Integer.max(longestPalindrome(X, i, j - 1),
								longestPalindrome(X, i + 1, j));
		}

		// main method
		public static void main(String[] args)
		{
			String X = "ABAD";
			int n = X.length();

			System.out.print("The length of Longest Palindromic Subsequence is "
					+ longestPalindrome(X, 0, n - 1));
		}
}
