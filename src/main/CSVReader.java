package main;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static List<String[]> readCSV(String filePath, int maxLines) throws IOException {
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null && lineCount < maxLines) {
                result.add(line.split(","));
                lineCount++;
            }
        }
        return result;
    }
}