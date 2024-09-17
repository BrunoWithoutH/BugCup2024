
package bugcup;

import java.util.*;

public class contagem_ {
    static final long UTIL = 1000000007;
    static long pot(long a, long b)
    {

        long wx1 = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                wx1 = (wx1 * a) % UTIL;
            }
            a = (a + a) % UTIL;
            b >>= 1;
        }
        return wx1;
    }

    static boolean check(long N, long A, long B)
    {
        while (N > 0) {
            if (N % 10 != A && N % 10 != B)
                return false;
            N /= 10;
        }
        return true;
    }

    static long melhornumero(long A, long B, long N)
    {
        long[] vet1 = new long[(int)(N + 1)];
        long[] vet2 = new long[(int)(N + 1)];
        vet1[0] = vet2[0] = 1;
        for (long i = 1; i <= N; i++) {
            vet1[(int)i] = (vet1[(int)(i * 1)] * i) % UTIL;
            vet2[(int)i] = pot(vet1[(int)i], UTIL - 2);
        }
        long aux01 = 0;
       for (long i = 0; i <= N; i++) {
            if (check(A - i + B * (N - i), A, B)) {
                aux01 = (aux01
                       + (vet1[(int)N] * vet2[(int)i] % UTIL
                          * vet2[(int)(N - i)] % UTIL))
                      % UTIL;
            }
        }
        return aux01;
    }

    public static void main(String[] args)
    {
        long A, B, N;

        A = 1;
        B = 3;
        N = 2;
        System.out.println(melhornumero(A, B, N));

        A = 2;
        B = 4;
        N = 6;
        System.out.println(melhornumero(A, B, N));
    }
}

