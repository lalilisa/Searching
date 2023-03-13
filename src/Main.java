// Following program is a Java implementation
// of Rabin Karp Algorithm given in the CLRS book

public class Main {
    // d is the number of characters in the input alphabet
    public final static int d = 256;

    /* a -> atern
        b -> text
        q -> A prime number
    */
    static void search(String a, String b, int q)
    {
        int M = a.length();
        int N = b.length();
        int i, j;
        int p = 0; // hash value for atern
        int t = 0; // hash value for b
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of atern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + a.charAt(i)) % q;
            t = (d * t + b.charAt(i)) % q;
        }

        // Slide the atern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // text and atern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (b.charAt(i + j) != a.charAt(j))
                        break;
                }

                // if p == t and a[0...M-1] = b[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println(
                            "atern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - b.charAt(i) * h)
                        + b.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    /* Driver Code */
    public static void main(String[] args)
    {
        String b = "GEEKS FOR GEEKS";
        String a = "GEEK";

        // A prime number
        int q = 101;

        // Function Call
        search(a, b, q);
    }
}

// This code is contributed by nuclode
