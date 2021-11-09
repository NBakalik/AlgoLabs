package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fantz {
    String x;
    int n;
    int count = 0;

    public Fantz(String filename) {
        readFile(filename);
    }

    public void findSubNumbers(String str) {
        int index = -1;
        for (int i = str.length(); i > 0; i--) {
            if (isPower(n, Integer.parseInt(str.substring(0, i), 2))) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            count++;
            findSubNumbers(str.substring(index));
        }
    }

    public boolean isPower(int x, int y) {
        if (x == 1) {
            return (y == 1);
        }
        int pow = 1;
        while (pow < y) {
            pow = pow * x;
        }
        return (pow == y);
    }

    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            x = line.split(" ")[0];
            n = Integer.parseInt(line.split(" ")[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fantz fantz = new Fantz("input.txt");
        fantz.findSubNumbers(fantz.x);
        if (fantz.count != 0) {
            System.out.println(fantz.count);
        } else {
            System.out.println(-1);
        }
    }
}
