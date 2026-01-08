package ui;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public boolean readYesNo(String prompt) {
        String r = readLine(prompt);
        return r.equalsIgnoreCase("y") || r.equalsIgnoreCase("yes");
    }
}