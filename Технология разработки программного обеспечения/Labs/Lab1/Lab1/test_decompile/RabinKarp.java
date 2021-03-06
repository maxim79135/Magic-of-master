package library;

import java.util.ArrayList;

public class RabinKarp {
   public static final int d = 10;
   private String str;
   private String substr;
   private int q;

   public RabinKarp(String str, String substr, int q) {
      this.str = str;
      this.substr = substr;
      this.q = q;
   }

   public ArrayList<Integer> search() {
      int m = this.substr.length();
      int n = this.str.length();
      int p = 0;
      int t = 0;
      int h = 1;
      ArrayList<Integer> res = new ArrayList();

      int i;
      for(i = 0; i < m - 1; ++i) {
         h = h * 10 % this.q;
      }

      for(i = 0; i < m; ++i) {
         p = (10 * p + this.substr.charAt(i)) % this.q;
         t = (10 * t + this.str.charAt(i)) % this.q;
      }

      for(i = 0; i <= n - m; ++i) {
         if (p == t) {
            int j;
            for(j = 0; j < m && this.str.charAt(i + j) == this.substr.charAt(j); ++j) {
            }

            if (j == m) {
               res.add(i + 1);
            }
         }

         if (i < n - m) {
            t = (10 * (t - this.str.charAt(i) * h) + this.str.charAt(i + m)) % this.q;
            if (t < 0) {
               t += this.q;
            }
         }
      }

      return res;
   }
}
