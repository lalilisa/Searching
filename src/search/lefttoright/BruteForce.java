package search.lefttoright;

public class BruteForce {
    public static void searching(String a,String b){
        int  m=a.length();
        int n=b.length();
        for(int i=0;i<n-m;i++){
            for (int j=0;j<m && a.charAt(j)==b.charAt(i+j);j++){
                if(j==m-1)
                    System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        String a="aa";
        String b="aaimaai";
        searching(a,b);
    }
}
