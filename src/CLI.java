import java.util.Scanner;

public class CLI {
    private DoublyLinkedList list;

    public CLI(DoublyLinkedList list) {
        this.list = list;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("\nComandos disponíveis: add, remove, find, list, exit");
            System.out.print("Digite um comando: ");
            command = scanner.nextLine();
            switch (command) {
                case "add":
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Data: ");
                    String date = scanner.nextLine();
                    System.out.print("Valor: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();
                    Transaction transaction = new Transaction(id, date, amount, description);
                    list.add(transaction);
                    System.out.println("Transação adicionada.");
                    break;
                case "remove":
                    System.out.print("ID da transação a remover: ");
                    String removeId = scanner.nextLine();
                    boolean removed = list.removeById(removeId);
                    System.out.println(removed ? "Transação removida." : "Transação não encontrada.");
                    break;
                case "find":
                    System.out.print("ID da transação a buscar: ");
                    String findId = scanner.nextLine();
                    Transaction found = list.findById(findId);
                    System.out.println(found != null ? found : "Transação não encontrada.");
                    break;
                case "list":
                    list.printAll();
                    break;
                case "exit":
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Comando inválido.");
            }
        } while (!command.equals("exit"));
        scanner.close();
    }
}
