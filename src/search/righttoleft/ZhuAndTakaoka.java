package search.righttoleft;

public class ZhuAndTakaoka {






    // Preprocessing and calculating the ZTBC for above
    // pattern by creating an integer array

    // As alphabets are 26 so
    // square matrix of 26 * 26
    public static int[][] ZTBC = new int[26][26];

    // Method
    // To calculate ZTBC to
    // print the indepattern at which the patternlenatches
    // occurs
    public static void ZTBCCalculation(String pattern)
    {

        // Declaring variables within this scope
        int i, j;
        int patternlen=pattern.length();
        // Iterating over to compute
        // using nested for loops
        for (i = 0; i < 26; ++i)
            for (j = 0; j < 26; ++j)
                ZTBC[i][j] = patternlen;

        for (i = 0; i < 26; ++i)
            ZTBC[i][pattern.charAt(0) - 'A']
                    = patternlen - 1;
        for (i = 1; i < patternlen-1 ; ++i)
            ZTBC[pattern.charAt(i - 1) - 'A']
                    [pattern.charAt(i) - 'A']
                    = patternlen - 1 - i;
        for (i = 0; i < 26; ++i) {
            for (j = 0; j < 26; ++j) {
                System.out.print(ZTBC[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void searching(String pattern,String text){
        int i, j;

        // Calling the above created Method 1
        ZTBCCalculation(pattern);

        // Lastly, searching pattern and printing the
        // indepattern

        j = 0;
        int patternlen=pattern.length();
        int stringlen=text.length();
        // Till condition holds true
        while (j <= stringlen - patternlen) {

            i = patternlen - 1;
            while (i >= 0
                    && pattern.charAt(i)
                    == text.charAt(i + j))
                --i;
            if (i < 0) {

                // Pattern detected
                System.out.println("Pattern Found at "
                        + (j + 1));
                j += patternlen;
            }

            // Not detected
            else
                j += ZTBC[text.charAt(j + patternlen - 2)
                        - 'A']
                        [text.charAt(j + patternlen - 1)
                        - 'A'];
        }
    }
    // Main driver method
    public static void main(String args[])
    {
         String txt = "AABCDBCDEABCDEA";
         String pattern = "ABCD";
         searching(pattern,txt);

    }
}
