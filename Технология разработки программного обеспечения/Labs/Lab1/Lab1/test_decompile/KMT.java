package library;

import java.util.ArrayList;

public class KMT {
   private String str;
   private String substr;

   public KMT(String str, String substr) {
      this.str = str;
      this.substr = substr;
   }

   private int[] getPrefixes(String str) {
      int n = str.length();
      int[] pi = new int[n];

      for(int i = 1; i < n; ++i) {
         int j;
         for(j = pi[i - 1]; j > 0 && str.charAt(i) != str.charAt(j); j = pi[j - 1]) {
         }

         if (str.charAt(i) == str.charAt(j)) {
            ++j;
         }

         pi[i] = j;
      }

      return pi;
   }

   public ArrayList<Integer> search() {
      ArrayList<Integer> res = new ArrayList();
      int[] pi = this.getPrefixes(this.substr.concat("#").concat(this.str));

      for(int i = 0; i < this.str.length(); ++i) {
         if (pi[this.substr.length() + i + 1] == this.substr.length()) {
            res.add(i - this.substr.length() + 1);
         }
      }

      return res;
   }
}
