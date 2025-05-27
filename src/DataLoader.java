import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {
    public static DoublyLinkedList loadTransactions(String filePath) {
        DoublyLinkedList list = new DoublyLinkedList();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Supondo que os dados estejam separados por vírgula
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Transaction transaction = new Transaction(parts[0], parts[1],
                            Double.parseDouble(parts[2]), parts[3]);
                    list.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
