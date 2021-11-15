package library;

public class ZFunction {

    private String str;

    public ZFunction(String s) {
        this.str = s;
    }

    public int[] calculate() {
        int[] z = new int[str.length()];
        int left = 0, right = 0;

        for (int i = 1; i < str.length(); i++) {
            z[i] = Math.max(0, Math.min(z[i - left], right - 1));
            while (i + z[i] < str.length() && str.charAt(z[i]) == str.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] > right) {
                left = i;
                right = i + z[i];
            }
        }
        return z;
    }

}
