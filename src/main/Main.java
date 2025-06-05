package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "dataSample/updated_student_habits_performance.csv"; // ajuste o nome do arquivo conforme necessário
        int maxLines = Integer.MAX_VALUE; // lê todas as linhas

        try {
            long start = System.currentTimeMillis();

            List<String[]> lines = CSVReader.readCSV(filePath, maxLines);
            DoubleLinkedList list = new DoubleLinkedList();
            StudentDataLoader.loadIntoDoubleLinkedList(lines, list);

            long end = System.currentTimeMillis();

            list.printAll();

            System.out.println("Tempo para carregar: " + (end - start) + " ms");
            int count = 0;
            for (var link : list) {
                count++;
            }
            System.out.println("Total de registros carregados: " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}