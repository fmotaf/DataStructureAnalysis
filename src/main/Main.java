package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "dataSample/updated_student_habits_performance.csv";
        int maxLines = Integer.MAX_VALUE;

        try {
            long startLoad = System.currentTimeMillis();

            List<String[]> lines = CSVReader.readCSV(filePath, maxLines);
            DoubleLinkedList list = new DoubleLinkedList();
            StudentDataLoader.loadIntoDoubleLinkedList(lines, list);

            long endLoad = System.currentTimeMillis();

            int count = 0;
            for (var link : list) {
                count++;
            }
            System.out.println("Tempo para carregar: " + (endLoad - startLoad) + " ms");
            System.out.println("Total de registros carregados: " + count);

            long startDelete = System.currentTimeMillis();
            while (true) {
                boolean hasElements = false;
                for (var link : list) {
                    hasElements = true;
                    break;
                }
                if (!hasElements) break;
                list.delete();
            }
            long endDelete = System.currentTimeMillis();
            System.out.println("Tempo para deletar todos: " + (endDelete - startDelete) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}