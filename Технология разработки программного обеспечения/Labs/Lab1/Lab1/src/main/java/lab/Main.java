package lab;

import library.KMT;
import library.ZFunction;
import library.RabinKarp;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final String RED = "\033[0;31m";
    static final String RESET = "\033[0m";

    static void mainMenu(int index) {
        System.out.println("Possible options:");
        String[] options = {
                "1. Rabin Karp algo\n",
                "2. KMT algo\n",
                "3. Z-index algo\n",
                "4. Exit\n"};
        if (index != -1) {
            for (int i = 0; i < index; i++) System.out.print(RESET + options[i]);
            System.out.print(RED + options[index]);
            for (int i = index + 1; i < options.length; i++) System.out.print(RESET + options[i]);
        } else {
            for (String option : options) System.out.print(RESET + option);
        }
    }

    public static void main(String[] args) {
        int currentPos = -1;
        while (true) {
            System.out.println("=======================================");
            mainMenu(currentPos);
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter the option: ");
                int code = scanner.nextInt();
                if (code > 4) {
                    currentPos = -1;
                    continue;
                } else currentPos = code - 1;
                if (code == 4) break;

                scanner.nextLine();

                String str, substr;
                switch (code) {
                    case 1:
                        System.out.print("Enter first string: ");
                        str = scanner.nextLine();
                        System.out.print("Enter second string: ");
                        substr = scanner.nextLine();
                        RabinKarp rk = new RabinKarp(str, substr, 2147483647);
                        System.out.println(rk.search());
                        break;
                    case 2:
                        System.out.print("Enter first string: ");
                        str = scanner.nextLine();
                        System.out.print("Enter second string: ");
                        substr = scanner.nextLine();
                        KMT kmt = new KMT(str, substr);
                        System.out.println(kmt.search());
                        break;
                    case 3:
                        System.out.print("Enter string: ");
                        str = scanner.nextLine();
                        ZFunction zFunc = new ZFunction(str);
                        System.out.println(Arrays.toString(zFunc.calculate()));
                        break;
                }
                System.out.print("Enter for continue");
                scanner.nextLine();
            } catch (InputMismatchException ignored) {
            }

        }
    }
}
