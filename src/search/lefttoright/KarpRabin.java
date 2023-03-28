package search.lefttoright;

public class KarpRabin {
    public final static int d = 256;

    public static int rehashing(char a,char b,int t,int q ,int power){
        t = (d * (t - a * power) + b) % q;
        if (t < 0)
            t = (t + q);
       return t;
    }
    public static  int powerCal(int m,int q){
        int power=1;
        for (int i = 0; i < m - 1; i++)
            power = (power * d) % q;
        return power;
    }
    static void search(String a, String b, int q)
    {
        int m = a.length();
        int n = b.length();
        int p = 0;
        int t = 0;
        int power = powerCal(m,q);
        for (int i = 0; i < m; i++) {
            p = (d * p + a.charAt(i)) % q;
            t = (d * t + b.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                for (int j = 0; j < m; j++) {
                    if (b.charAt(i + j) != a.charAt(j))
                        break;
                    if (j == m-1)
                        System.out.println("patern found at index " + i);
                }
            }
            if (i < n - m) {
                t=rehashing(b.charAt(i),b.charAt(i+m),t,q,power);
            }
        }
    }

    public static void main(String[] args) {
        String b = "trimai";
        String a = "i";
        int q = 101;
        search(a, b, q);
    }
}
