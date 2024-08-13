import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoyerMooreAlgo {
    private final int SIZE = 256; // size of the ASCII table
    private int[] shiftTable; // the shift table

    private String pattern; // the pattern string

    public BoyerMooreAlgo(String pattern) {
        this.pattern = pattern;
        this.shiftTable = new int[SIZE]; // initialize the shift table with the size of the ASCII table

        // Initialize all occurrences as -1
        Arrays.fill(shiftTable, -1);

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < pattern.length(); i++)
            shiftTable[pattern.charAt(i)] = i;
    }

    // Function that performs the search algorithm
    public List<Integer> search(String txt) {
        List<Integer> indices = new ArrayList<>();
        int m = pattern.length();
        int n = txt.length();

        // A loop to slide pattern[] one by one
        for (int i = 0; i <= n - m;) {
            int j = m - 1; // Start from the rightmost character of pattern[]

            // Keep reducing index j while characters of pattern[] and txt[] are matching at
            // this shift i
            while (j >= 0 && pattern.charAt(j) == txt.charAt(i + j))
                j--;

            // If the pattern is present at the current shift, then index j will become -1
            // after the above loop
            if (j < 0) {
                indices.add(i);

                // Shift the pattern so that the next character in txt aligns with the last
                // occurrence of it in pattern[]..
                i += (i + m < n) ? m - shiftTable[txt.charAt(i + m)] : 1;

            } else {
                // Shift the pattern so that the mismatched character in txt aligns with the
                // last occurrence of it in pattern[].
                // The max function to make sure we get a positive shift
                i += Math.max(1, j - shiftTable[txt.charAt(i + j)]);
            }
        }
        return indices;
    }
}
