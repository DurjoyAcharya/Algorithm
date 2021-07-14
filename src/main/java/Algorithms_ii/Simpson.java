package Algorithms_ii;

public class Simpson {
    private static float func(float x)
    {
        return (float)Math.pow(x,2)+1;
    }
    public static float _simpsons(float upper, float lower, int n)
    {
        float h = (upper - lower) / n;

        float[] x = new float[100];
        float[] fx= new float[100];

        for (int i = 0; i <= n; i++) {
            x[i] = upper + i * h;
            fx[i] = func(x[i]);
        }

        float res = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == n)
                res += fx[i];
            else if (i % 2 != 0)
                res += 4 * fx[i];
            else
                res += 2 * fx[i];
        }

        res = res * (h / 3);
        return res;
    }

    public static void main(String...args) {
        float lower_limit = 0;
        float upper_limit =  3.0f;
        int n = 50;
        System.out.println(_simpsons(lower_limit,
                upper_limit, n));
    }
}

