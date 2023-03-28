package search.lefttoright;
public class MorrisPratt {
    public static int[] preMP(String x) {
        int[] mpNext = new int[x.length()+1];
        int i = 0;
        int j = mpNext[0] = -1;
        while (i < x.length()) {
            while (j > -1 && (x.charAt(i) != x.charAt(j))) {
                j = mpNext[j];
            }
            mpNext[++i] = ++j;
        }
        return mpNext;
    }
    public static void search(String x, String y) {
        int[] mpNext = preMP(x);
        int i = 0;
        int j= 0;
        int xLength=x.length();
        int yLength=y.length();
        System.out.println("Các vị trí xuất hiện của x trong y là: ");
        while (j < yLength) {
            while (i >-1 && x.charAt(i)!=y.charAt(j))
                i=mpNext[i];
            System.out.println(i);
            i++;j++;
            if(i==xLength){
                i=mpNext[i];
            }

        }
    }
    public static void main(String[] args) {
        String x = "aaannaa";

        String y = "basdaaaannaaa";
        search(x, y);
    }
}