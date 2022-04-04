package Algorithms_i;


//Error Code
public class BinomialDistribution {
    public static double BinomialV1(int N,int R,double Q)
    {
        if (N==0 && R==0) return 1.0;
        if (N==0 || R==0) return 0.0;
        return (1.0-Q)*BinomialV1(N-1,R,Q)+Q*BinomialV1(N-1,R-1,Q);
    }
    public static double BinomialV2(int N,int R,double Q)
    {
        double[][] arr=new double[N+1][R+1];
        for (int i = 0; i <=N; i++) {
            arr[i][0]=Math.pow(1.0-Q,i);
        }
        arr[0][0]=0.0;
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=R; j++) {
                arr[i][j]=Q*arr[i-1][j-1] + (1.0-Q)*arr[i-1][j];
            }
        }
        return arr[N][R];
    }
    public static void main(String[] args) {
        System.out.println(BinomialV1(10,3,.5));
        System.out.println(BinomialV2(10,3,.5));
    }
}
