/*
 * Refrences: 
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string-search_algorithm
 * https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/ 
 * https://www.sanfoundry.com/java-program-boyer-moore-algorithm/
 */

// Define the BoyerMoore class
public class BoyerMooreAlgo {
    private final int R; // The radix (size of the alphabet)
    private int[] right; // The bad-character skip array
    private String patterneString; // The patterneStringtern as a string

    // Constructor for the class it takes a string in this case the list of states.
    public BoyerMooreAlgo(String patterneString) {
        this.R = 256; // Initialize the radix to the size of the ASCII character set
        this.patterneString = patterneString; // Store the patterneStringtern

        // Initialize the right[] array to store the rightmost occurrence of each
        // character in the patterneStringtern
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1; // Initialize all entries to -1
        for (int j = 0; j < patterneString.length(); j++)
            right[patterneString.charAt(j)] = j; // Set the rightmost occurrence of each character
    }

    // Method to search for the patterneStringtern in the given text and return the
    // number of matches for a pattern.
    public int search(String txt) {
        int m = patterneString.length(); // Length of the patterneStringtern
        int n = txt.length(); // Length of the text
        int skip; // Number of characters to skip

        // Iterate over the text
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0; // Initialize skip to 0

            // Iterate over the patterneStringtern from right to left
            for (int j = m - 1; j >= 0; j--) {
                // If a mismatch is found
                if (patterneString.charAt(j) != txt.charAt(i + j)) {
                    // Calculate the number of characters to skip
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break; // Break the inner loop
                }
            }

            // If no mismatch was found (i.e., a match was found)
            if (skip == 0)
                return i; // Return the starting index of the match
        }

        // If no match was found
        return n; // Return the length of the text
    }
}
