import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String filePath = "dataSample/updated_student_habits_performance.csv";
        String line;
        String cvsSplitBy = ",";
        int lineCount = 0;
        int maxLines = 10;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null && lineCount < maxLines) {
                String[] columns = line.split(",");
                for (String column : columns) {
                    System.out.print(column + " | ");
                }
                System.out.println();
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}