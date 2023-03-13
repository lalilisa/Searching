package search;
public class MorrisPratt {
    public static int[] preMP(String x) {
        int[] mpNext = new int[x.length()+1];
        int i = 0;
        // "GCAGAGAG";
        int j = mpNext[0] = -1;
        while (i < x.length()) {
            while (j > -1 && (x.charAt(i) != x.charAt(j))) {
                j = mpNext[j];
            }
            mpNext[++i] = ++j;
            for(int k=0;k<x.length()+1;k++)
                System.out.print(mpNext[k]+" ");
            System.out.println();
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
            i++;j++;
            if(i==xLength){
                System.out.println(j-i);
                i=mpNext[i];
            }

        }
    }
    public static void main(String[] args) {
        String x = "GCAGAGAG";

        String y = "GCATCGCAGAGAGTATACAGTACG";
        search(x, y);
    }
}