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

            // Busca por um ID específico (ajuste conforme necessário)
            String searchId = "S1";
            long startSearch = System.currentTimeMillis();
            StudentData found = list.findById(searchId);
            long endSearch = System.currentTimeMillis();
            if (found != null) {
                System.out.println("Registro encontrado para ID " + searchId + ": " + found.getStudentId());
            } else {
                System.out.println("Registro não encontrado para ID " + searchId);
            }
            System.out.println("Tempo para buscar: " + (endSearch - startSearch) + " ms");

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

            // Ordenar por ID
            long startSortId = System.nanoTime();
            list.sortById();
            long endSortId = System.nanoTime();
            System.out.println("(BubbleSort) Tempo para ordenar por ID: " + (endSortId - startSortId) / 1_000_000.0 + " ms");

            // Ordenar por idade
            long startSortAge = System.nanoTime();
            list.sortByAge();
            long endSortAge = System.nanoTime();
            System.out.println("(BubbleSort) Tempo para ordenar por idade: " + (endSortAge - startSortAge) / 1_000_000.0 + " ms");

            // Ordenar por nota do exame (exemplo de uso do Comparator)
            long startSortExam = System.currentTimeMillis();
            list.sort(java.util.Comparator.comparing(StudentData::getExamScore));
            long endSortExam = System.currentTimeMillis();
            System.out.println("(BubbleSort) Tempo para ordenar por nota do exame: " + (endSortExam - startSortExam) + " ms");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}