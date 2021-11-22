package library;

import java.util.Vector;

public class RabinKarp {
    public final static int d = 10;
    private String str;
    private String substr;
    private int q;

    public RabinKarp(String str, String substr, int q) {
        this.str = str;
        this.substr = substr;
        this.q = q;
    }

    public Vector<Integer> search() {
        int m = substr.length();
        int n = str.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        Vector<Integer> res = new Vector<>();

        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        for (i = 0; i < m; i++) {
            p = (d * p + substr.charAt(i)) % q;
            t = (d * t + str.charAt(i)) % q;
        }

        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (str.charAt(i + j) != substr.charAt(j))
                        break;
                }
                if (j == m)
                    res.add(i + 1);
            }

            if (i < n - m) {
                t = (d * (t - str.charAt(i) * h) + str.charAt(i + m)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
        return res;
    }
}