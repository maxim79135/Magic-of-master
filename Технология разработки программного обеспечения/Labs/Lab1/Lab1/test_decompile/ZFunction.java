package library;

public class ZFunction {
   private String str;

   public ZFunction(String s) {
      this.str = s;
   }

   public int[] calculate() {
      int[] z = new int[this.str.length()];
      int left = 0;
      int right = 0;

      for(int i = 1; i < this.str.length(); ++i) {
         int var10002;
         for(z[i] = Math.max(0, Math.min(z[i - left], right - 1)); i + z[i] < this.str.length() && this.str.charAt(z[i]) == this.str.charAt(i + z[i]); var10002 = z[i]++) {
         }

         if (i + z[i] > right) {
            left = i;
            right = i + z[i];
         }
      }

      return z;
   }
}
