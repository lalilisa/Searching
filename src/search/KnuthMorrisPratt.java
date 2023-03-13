package search;

public class KnuthMorrisPratt {

    public static int[] preMP(String x) {
        int[] mpNext = new int[x.length()+1];
        int i = 0;
        int j = mpNext[0] = -1;
        while (i < x.length()) {
            while (j > -1 && (x.charAt(i) != x.charAt(j)))
                j = mpNext[j];
            i++;
            j++;
            if(i<x.length()&& x.charAt(i)==x.charAt(j))
                mpNext[i]=mpNext[j];
            else
                mpNext[i]=j;
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
        String x = "a";
        String y = "basdccaaaaa";
        search(x, y);
    }
}
