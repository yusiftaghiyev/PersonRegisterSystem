package util;

import java.io.*;

public class InputOutput {

    public static void fileWriter(String filename, String name, String surname, int age, boolean append) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, append));
        bw.write(name);
        bw.write(surname);
        bw.write(age);
        bw.close();

    }

    public static void fileReader(String filename) throws IOException {
        try (BufferedReader bw = new BufferedReader(new FileReader(filename));) {
            System.out.println(bw.readLine() + "\n");
            System.out.println(bw.read());
        }
    }

}
